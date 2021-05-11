package vietnqv.controller.user;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vietnqv.dto.model.Product_DTO;
import vietnqv.service.Product_Service;
import vietnqv.utils.Cookies_Utils;

@WebServlet("/Home1User")
public class HomeUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Product_Service product_Service = new Product_Service();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");
		if (action != null && !action.equalsIgnoreCase("")) {
            if(action.equalsIgnoreCase("logout")) {
            	Cookies_Utils.add("email", null, 60);
				Cookies_Utils.add("pass", null, 60);
				request.getRequestDispatcher("/view/Login/Login.jsp").forward(request, response);
            }
		} else {

			List<Product_DTO> lstProduct_DTO = product_Service.selectAll();
			List<Product_DTO> lstProduct_DTOs = new ArrayList<Product_DTO>();
			if (lstProduct_DTO.size() >= 5) {
				for (int i = 0; i < 4; i++) {
					lstProduct_DTOs.add(lstProduct_DTO.get(i));
				}
				request.setAttribute("lstproduct", lstProduct_DTOs);
			} else if (lstProduct_DTO.size() > 0 && lstProduct_DTO.size() < 5) {
				request.setAttribute("lstproduct", lstProduct_DTO);
			}
			request.setAttribute("tieude", "Đây là trang home");
			request.setAttribute("View", "/view/User/HomeUser.jsp");
			request.getRequestDispatcher("/view/User/User.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("tieude", "Đây là trang home");
	}

}
