package vietnqv.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vietnqv.dto.model.Account_DTO;
import vietnqv.dto.model.Bill_DTO;
import vietnqv.dto.model.Category_DTO;
import vietnqv.dto.model.Product_DTO;
import vietnqv.service.Account_Service;
import vietnqv.service.Bill_Service;
import vietnqv.service.Category_Service;
import vietnqv.service.Product_Service;
import vietnqv.utils.Cookies_Utils;

@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Account_Service account_Service = new Account_Service();
	Product_Service product_Service = new Product_Service();
	Bill_Service bill_Service = new Bill_Service();
	Category_Service category_Service = new Category_Service();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");
		if (action != null && !action.equals("")) {
			if (action.equalsIgnoreCase("off")) {
				request.setAttribute("menuSmart", "style=\"display: none\"");
				request.setAttribute("menuSmart1", "");
			} else if (action.equalsIgnoreCase("on")) {
				request.setAttribute("menuSmart", "");
				request.setAttribute("menuSmart1", "style=\"display: none\"");
			}
		}
		List<Product_DTO> lstProduct = product_Service.selectAll();
		List<Category_DTO> lstCategory = category_Service.selectAll();
		List<Bill_DTO> lstBill = bill_Service.selectAll();
		request.setAttribute("product", lstProduct.size());
		request.setAttribute("category", lstCategory.size());
		request.setAttribute("bill", lstBill.size());
		Account_DTO account_DTO = getAccount_DTO(request, response);
		request.setAttribute("account", account_DTO);
		request.setAttribute("tieude", "Đây là trang home");
		request.setAttribute("View", "../Admin/Home/Home.jsp");
		request.getRequestDispatcher("/view/Admin/Admin.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("tieude", "Đây là trang home");
	}

	public Account_DTO getAccount_DTO(HttpServletRequest request, HttpServletResponse response) {
		String email = Cookies_Utils.getCookie("email", "không");
		Account_DTO account_DTO = new Account_DTO();
		if (!email.equals("không") && !email.trim().equals("")) {
			List<Account_DTO> lstAccount = account_Service.search(email);
			if (lstAccount.size() > 0) {
				account_DTO = lstAccount.get(0);
			}
		} else {
			return null;
		}
		return account_DTO;
	}
}
