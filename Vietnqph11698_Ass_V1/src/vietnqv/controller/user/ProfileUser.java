package vietnqv.controller.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vietnqv.dto.model.Account_DTO;
import vietnqv.service.Account_Service;
import vietnqv.utils.Cookies_Utils;

@WebServlet("/Profile1User")
public class ProfileUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Account_Service account_Service = new Account_Service();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = Cookies_Utils.getCookie("email", "không");
		Account_DTO account_DTO = new Account_DTO(); 
		if (!email.equals("không") && !email.trim().equals("")) {
			List<Account_DTO> lstAccount = account_Service.search(email);
			if(lstAccount.size()>0) {
			account_DTO = lstAccount.get(0);}
		}else {
			request.getRequestDispatcher("/view/Login/Login.jsp").forward(request, response);
		}
		request.setAttribute("tieude", "Đây là trang profile");
		request.setAttribute("account", account_DTO);
		request.setAttribute("View", "/view/User/Profile/Profile.jsp");
		request.getRequestDispatcher("/view/User/User.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("tieude", "Đây là trang profile");
	}

}
