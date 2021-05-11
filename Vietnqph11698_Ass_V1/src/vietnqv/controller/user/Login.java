package vietnqv.controller.user;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vietnqv.dto.model.Account_DTO;
import vietnqv.dto.model.Product_DTO;
import vietnqv.service.Account_Service;
import vietnqv.service.Product_Service;
import vietnqv.utils.Cookies_Utils;

@WebServlet({"/Login","/Login/LoginPage"})
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Account_Service account_Service = new Account_Service();
	String xanh = "#13eba2";
	String cam = "red";
	 Product_Service product_Service = new Product_Service();
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		request.getRequestDispatcher("/view/Login/Login.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String email = request.getParameter("Email");
		String pass = request.getParameter("Pass");
		String uri = request.getRequestURI();
	
		if(uri.contains("/LoginPage")) {
			
			List<Account_DTO> lstAccount_DTO = account_Service.search(email);
			if(lstAccount_DTO.size()<1) {
				request.setAttribute("style", "block");
				request.setAttribute("backgroundErro", cam);
				request.setAttribute("content","Tài khoản hoặc mật khẩu không chính xác!!!");
				request.getRequestDispatcher("/view/Login/Login.jsp").forward(request, response);
			}else {
				if(!lstAccount_DTO.get(0).getPassword().equals(pass)) {
					request.setAttribute("style", "block");
					request.setAttribute("backgroundErro", cam);
					request.setAttribute("content","Tài khoản hoặc mật khẩu không chính xác!!!");
					request.getRequestDispatcher("/view/Login/Login.jsp").forward(request, response);
				}else {
					request.setAttribute("style", "block");
					request.setAttribute("backgroundErro", xanh);
					request.setAttribute("content","Đăng nhập thành công");
					Cookies_Utils.add("email", email, 60);
					Cookies_Utils.add("pass", pass, 60);
					List<Product_DTO> lstProduct_DTO = product_Service.selectAll();
					List<Product_DTO> lstProduct_DTOs = new ArrayList<Product_DTO>();
					if(lstProduct_DTO.size()>=5) {
						for (int i = 0; i < 4; i++) {
							lstProduct_DTOs.add(lstProduct_DTO.get(i));
							
						}
						request.setAttribute("lstproduct", lstProduct_DTOs);
					}else if(lstProduct_DTO.size()>0 && lstProduct_DTO.size()<5){
						request.setAttribute("lstproduct", lstProduct_DTO);
					}
					
				request.setAttribute("View", "/view/User/HomeUser.jsp");
					request.getRequestDispatcher("/view/User/User.jsp").forward(request, response);
				}
			}
		}
		

		
	}

}
