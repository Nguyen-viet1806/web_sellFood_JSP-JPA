package vietnqv.controller.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vietnqv.dto.model.Account_DTO;
import vietnqv.dto.model.Category_DTO;
import vietnqv.service.Account_Service;
import vietnqv.service.Category_Service;
import vietnqv.utils.Cookies_Utils;

@WebServlet({ "/CategoryServlet", "/CategoryServlet/Submit", "/CategoryServlet/Reset", "/CategoryServlet/Search" })
public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Category_Service category_Service = new Category_Service();
	Account_Service account_Service = new Account_Service();
	String xanh = "#13eba2";
	String cam = "#ff966c";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		

		int page = 0;
		String action = request.getParameter("action");
		try {
			page = Integer.parseInt(request.getParameter("page"));
		} catch (Exception e) {
			page = 0;
		}
		if (action == null || action.trim().equalsIgnoreCase("")) {
			page = 0;
		} else {
			if (action.equalsIgnoreCase("prev")) {
				if (page == 0) {
					page = 0;
				} else {
					page -= 5;
				}
			} else if (action.equalsIgnoreCase("next")) {
				page += 5;
			} else if (action.equalsIgnoreCase("show")) {
				int idCategory = Integer.parseInt(request.getParameter("idCategory"));
				Category_DTO category_DTO = category_Service.find(idCategory);
				request.setAttribute("Category", category_DTO);
			} else if (action.equalsIgnoreCase("delete")) {
				int idCategory = Integer.parseInt(request.getParameter("idCategory"));
				Category_DTO category_DTO = category_Service.find(idCategory);
				int check = category_Service.delete(category_DTO);
				request.setAttribute("style", "block");
				if (check == 4) {
					request.setAttribute("backgroundErro", xanh);
				} else {
					request.setAttribute("backgroundErro", cam);
				}
				request.setAttribute("content", check == 4 ? "Khôi phục thành công!!!" : "Xóa thành công!!!");
			}else if (action.equalsIgnoreCase("off")) {
				request.setAttribute("menuSmart", "style=\"display: none\"");
				request.setAttribute("menuSmart1", "");
			} else if (action.equalsIgnoreCase("on")) {
				request.setAttribute("menuSmart", "");
				request.setAttribute("menuSmart1", "style=\"display: none\"");
			}
		}

		List<Category_DTO> lstCategorys_DTO = category_Service.getListPage(page, 5);
		Account_DTO account_DTO = getAccount_DTO(request, response);
		request.setAttribute("account", account_DTO);
		request.setAttribute("lstCategory", lstCategorys_DTO);
		request.setAttribute("page", page);
		request.setAttribute("tieude", "Đây là trang category");
		request.setAttribute("View", "/view/Admin/Category/Category.jsp");
		request.getRequestDispatcher("/view/Admin/Admin.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		List<Category_DTO> lstCategory_DTO = new ArrayList<Category_DTO>();
		if (uri.contains("/CategoryServlet/Reset")) {
			lstCategory_DTO = category_Service.getListPage(0, 5);
			request.setAttribute("lstCategory", lstCategory_DTO);
			request.setAttribute("page", 0);
			request.setAttribute("View", "/view/Admin/Category/Category.jsp");
		} else if (uri.contains("/CategoryServlet/Submit")) {

			if (request.getParameter("idct") == null || request.getParameter("idct").trim().equalsIgnoreCase("")) {
				String nameCategory = request.getParameter("nameCategory");
				if (nameCategory == null || nameCategory.trim().equalsIgnoreCase("")) {
					lstCategory_DTO = category_Service.getListPage(0, 5);
					request.setAttribute("lstCategory", lstCategory_DTO);
					request.setAttribute("page", 0);
					request.setAttribute("style", "block");
					request.setAttribute("backgroundErro", cam);
					request.setAttribute("content", "Vui lòng nhập đầy đủ thông tin!");
					request.setAttribute("View", "/view/Admin/Category/Category.jsp");
				} else {
					Category_DTO category_DTO = new Category_DTO();
					category_DTO.setNameCategory(nameCategory);
					int result = category_Service.create(category_DTO);
					if (result > 0) {
						lstCategory_DTO = category_Service.getListPage(0, 5);
						request.setAttribute("lstCategory", lstCategory_DTO);
						request.setAttribute("page", 0);
						request.setAttribute("style", "block");
						request.setAttribute("backgroundErro", xanh);
						request.setAttribute("content", "Tạo mới thành công!");
						request.setAttribute("View", "/view/Admin/Category/Category.jsp");
					}
				}
			} else {

				int idCategory = Integer.parseInt(request.getParameter("idct"));
				Category_DTO category_DTO = category_Service.find(idCategory);
				String nameCategory = request.getParameter("nameCategory");
				if (nameCategory == null || nameCategory.trim().equals("")) {
					lstCategory_DTO = category_Service.getListPage(0, 5);
					request.setAttribute("lstCategory", lstCategory_DTO);
					request.setAttribute("page", 0);
					request.setAttribute("Category", category_DTO);
					request.setAttribute("style", "block");
					request.setAttribute("backgroundErro", cam);
					request.setAttribute("content", "Vui lòng nhập đầy đủ thông tin!");
					request.setAttribute("View", "/view/Admin/Category/Category.jsp");
				} else {
					category_DTO.setNameCategory(nameCategory);
					category_Service.update(category_DTO);
					lstCategory_DTO = category_Service.getListPage(0, 5);
					request.setAttribute("lstCategory", lstCategory_DTO);
					request.setAttribute("page", 0);
					request.setAttribute("style", "block");
					request.setAttribute("backgroundErro", xanh);
					request.setAttribute("content", "Cập nhập thành công!");
					request.setAttribute("View", "/view/Admin/Category/Category.jsp");
				}
			}
		} else if (uri.contains("/CategoryServlet/Search")) {
		
			String keyword = request.getParameter("text-search");
			if(keyword==null || keyword.trim().equals("")) {
				lstCategory_DTO = category_Service.getListPage(0, 5);
				request.setAttribute("lstCategory", lstCategory_DTO);
				request.setAttribute("page", 0);
				request.setAttribute("style", "block");
				request.setAttribute("backgroundErro", cam);
				request.setAttribute("content", "Vui lòng nhập tên thể loại cần tìm!");
				request.setAttribute("View", "/view/Admin/Category/Category.jsp");
			}else {
				lstCategory_DTO = category_Service.search(keyword);
				request.setAttribute("lstCategory", lstCategory_DTO);
				request.setAttribute("page", 0);
				request.setAttribute("style", "block");
				request.setAttribute("backgroundErro", xanh);
				request.setAttribute("content", lstCategory_DTO.size()>0? "Nội dung tìm kiếm đã được hiển thị ở bảng!":"Không có thể loại nào khớp với tên bạn nhập!");
				request.setAttribute("View", "/view/Admin/Category/Category.jsp");
			}
		}
		request.setAttribute("tieude", "Đây là trang category");
		request.getRequestDispatcher("/view/Admin/Admin.jsp").forward(request, response);
	}
	public Account_DTO getAccount_DTO(HttpServletRequest request, HttpServletResponse response) {
		String email = Cookies_Utils.getCookie("email", "không");
		Account_DTO account_DTO = new Account_DTO();
		if (!email.equals("không") && !email.trim().equals("")) {
			List<Account_DTO> lstAccount = account_Service.search(email);
			if (lstAccount.size() > 0) {
				account_DTO = lstAccount.get(0);
			}
		}else {
			return null;
		}
		return account_DTO;
	}
	
}
