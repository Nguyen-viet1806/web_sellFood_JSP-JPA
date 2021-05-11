package vietnqv.controller.admin;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import vietnqv.dto.model.Account_DTO;
import vietnqv.dto.model.Category_DTO;
import vietnqv.dto.model.Product_DTO;
import vietnqv.mapper.Category_MapperImpl;
import vietnqv.server.model.TblCategory;
import vietnqv.service.Account_Service;
import vietnqv.service.Category_Service;
import vietnqv.service.Product_Service;
import vietnqv.utils.Cookies_Utils;
import vietnqv.utils.JPA_Utils;

@MultipartConfig
@WebServlet({ "/ProductServlet", "/ProductServlet/Submit", "/ProductServlet/Reset", "/ProductServlet/Search" })
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Account_Service account_Service = new Account_Service();
	Product_Service product_Service = new Product_Service();
	Category_Service category_Service = new Category_Service();
	String xanh = "#13eba2";
	String cam = "#ff966c";
	Category_MapperImpl category_mapper = new Category_MapperImpl();
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
				int idProduct = Integer.parseInt(request.getParameter("idProduct"));
				Product_DTO product_DTO = product_Service.find(idProduct);
				request.setAttribute("Product", product_DTO);
			}else if(action.equalsIgnoreCase("delete")) {
				int idProduct = Integer.parseInt(request.getParameter("idProduct"));
				Product_DTO product_DTO = product_Service.find(idProduct);
				int check = product_Service.delete(product_DTO);
				
				if(check==4) {
					request.setAttribute("style", "block");
					request.setAttribute("backgroundErro", xanh);
					request.setAttribute("content","Khôi phục thành công!!!");
				}else {
					request.setAttribute("style", "block");
					request.setAttribute("backgroundErro", cam);
					request.setAttribute("content","Xóa thành công!!");
				}
			} else if (action.equalsIgnoreCase("off")) {
				request.setAttribute("menuSmart", "style=\"display: none\"");
				request.setAttribute("menuSmart1", "");
			} else if (action.equalsIgnoreCase("on")) {
				request.setAttribute("menuSmart", "");
				request.setAttribute("menuSmart1", "style=\"display: none\"");
			}
		}
		List<Category_DTO> lstCategory_DTO = getListCategory_DTOWithStatus();
		List<Product_DTO> listProducts_DTO = product_Service.getListPage(page, 5);
		Account_DTO account_DTO = getAccount_DTO(request, response);
		request.setAttribute("account", account_DTO);
		request.setAttribute("lstCategory", lstCategory_DTO);
		request.setAttribute("lstProduct", listProducts_DTO);
		request.setAttribute("page", page);
		request.setAttribute("tieude", "Đây là trang product");
		request.setAttribute("View", "../Admin/Product/Product.jsp");
		request.getRequestDispatcher("/view/Admin/Admin.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		List<Product_DTO> listProducts_DTO = new ArrayList<Product_DTO>();
		boolean validate = validateForm(request, response);
		if (uri.contains("/ProductServlet/Submit")) {
//			String nameProduct = request.getParameter("nameProduct");
//			double moneyProduct =0;
//			int idCategory=0;
//			try {
//				 moneyProduct = Double.parseDouble(request.getParameter("moneyProduct"));
//				 idCategory = Integer.parseInt(request.getParameter("nameCategory"));
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			Part img = request.getPart("imgProduct");
//			String noteProduct = request.getParameter("noteProduct");
			if (!validate) {
				List<Category_DTO> lstCategory_DTO = category_Service.selectAll();
				listProducts_DTO = product_Service.getListPage(0, 5);
				request.setAttribute("lstCategory", lstCategory_DTO);
				request.setAttribute("lstProduct", listProducts_DTO);
				request.setAttribute("page", 0);
				request.setAttribute("style", "block");
				request.setAttribute("backgroundErro", cam);
				request.setAttribute("content", "Vui lòng nhập đầy đủ thông tin!");
				request.setAttribute("View", "../Admin/Product/Product.jsp");
			} else {
				double moneyProduct = Double.parseDouble(request.getParameter("moneyProduct"));
				int idCategory = Integer.parseInt(request.getParameter("nameCategory"));
				String nameProduct = request.getParameter("nameProduct");
				Part img = request.getPart("imgProduct");
				String noteProduct = request.getParameter("noteProduct");
				if (request.getParameter("idP") == null || request.getParameter("idP").trim().equalsIgnoreCase("")) {
					Product_DTO product_DTO = new Product_DTO();
					product_DTO.setNameProduct(nameProduct);
					product_DTO.setMoneyProduct(moneyProduct);
					product_DTO.setNoteProduct(noteProduct);
					Category_DTO category_DTO = category_Service.find(idCategory);
					product_DTO.setCategory_DTO(category_DTO);
					File dir = new File(request.getServletContext().getRealPath("/Files"));
					if (!dir.exists()) {
						dir.mkdirs();
					}
					File PathImage = new File(dir, img.getSubmittedFileName());
					img.write(PathImage.getAbsolutePath());
					product_DTO.setImgProduct("/Vietnqph11698_Ass_V1/Files/" + PathImage.getName());
					int result = product_Service.create(product_DTO);
					if (result > 0) {
						request.setAttribute("style", "block");
						request.setAttribute("backgroundErro", xanh);
						request.setAttribute("content", "Tạo mới thành công!");
					} else {
						request.setAttribute("style", "block");
						request.setAttribute("backgroundErro", cam);
						request.setAttribute("content", "Tạo mới thất bại!");
					}
					List<Category_DTO> lstCategory_DTO = category_Service.selectAll();
					listProducts_DTO = product_Service.getListPage(0, 5);
					request.setAttribute("lstCategory", lstCategory_DTO);
					request.setAttribute("lstProduct", listProducts_DTO);
					request.setAttribute("page", 0);
					request.setAttribute("View", "../Admin/Product/Product.jsp");
				} else {
					int idProduct = Integer.parseInt(request.getParameter("idP"));
					Product_DTO product_DTO = product_Service.find(idProduct);
					product_DTO.setNameProduct(nameProduct);
					product_DTO.setMoneyProduct(moneyProduct);
					product_DTO.setNoteProduct(noteProduct);
					Category_DTO category_DTO = category_Service.find(idCategory);
					product_DTO.setCategory_DTO(category_DTO);
					File dir = new File(request.getServletContext().getRealPath("/imgProduct"));
					if (!dir.exists()) {
						dir.mkdirs();
					}
					File PathImage = new File(dir, img.getSubmittedFileName());
					img.write(PathImage.getAbsolutePath());
					product_DTO.setImgProduct("/Vietnqph11698_Ass_V1/imgProduct/" + PathImage.getName());
					int result = product_Service.update(product_DTO);
					if (result > 0) {
						request.setAttribute("style", "block");
						request.setAttribute("backgroundErro", xanh);
						request.setAttribute("content", "Cập nhập thành công!");
					} else {
						request.setAttribute("style", "block");
						request.setAttribute("backgroundErro", cam);
						request.setAttribute("content", "Cập nhập thất bại!");
					}
					List<Category_DTO> lstCategory_DTO = category_Service.selectAll();
					listProducts_DTO = product_Service.getListPage(0, 5);
					request.setAttribute("lstCategory", lstCategory_DTO);
					request.setAttribute("lstProduct", listProducts_DTO);
					request.setAttribute("page", 0);
					request.setAttribute("View", "../Admin/Product/Product.jsp");
				}
			}

		} else if (uri.contains("/ProductServlet/Reset")) {
			List<Category_DTO> lstCategory_DTO = category_Service.selectAll();
			listProducts_DTO = product_Service.getListPage(0, 5);
			request.setAttribute("lstCategory", lstCategory_DTO);
			request.setAttribute("lstProduct", listProducts_DTO);
			request.setAttribute("View", "../Admin/Product/Product.jsp");
		}else  if(uri.contains("/ProductServlet/Search")){
			String keyword = request.getParameter("text-search");
			if(keyword==null || keyword.trim().equals("")) {
				List<Category_DTO> lstCategory_DTO = category_Service.selectAll();
				listProducts_DTO = product_Service.getListPage(0, 5);
				request.setAttribute("lstCategory", lstCategory_DTO);
				request.setAttribute("lstProduct", listProducts_DTO);
				request.setAttribute("style", "block");
				request.setAttribute("backgroundErro", cam);
				request.setAttribute("content", "Vui lòng nhập tên sản phẩm cần tìm!");
				request.setAttribute("page", 0);
				request.setAttribute("View", "../Admin/Product/Product.jsp");
			}else {
				listProducts_DTO = product_Service.search(keyword);
				List<Category_DTO> lstCategory_DTO = category_Service.selectAll();
				request.setAttribute("lstCategory", lstCategory_DTO);
				request.setAttribute("lstProduct", listProducts_DTO);
				request.setAttribute("style", "block");
				request.setAttribute("backgroundErro", xanh);
				request.setAttribute("content", listProducts_DTO.size()>0? "Nội dung tìm kiếm đã được hiển thị ở bảng!":"Không có sản phẩm nào khớp với tên bạn nhập!");
				request.setAttribute("page", 0);
				request.setAttribute("View", "../Admin/Product/Product.jsp");
			}
			
		}
		request.setAttribute("tieude", "Đây là trang product");
		request.getRequestDispatcher("/view/Admin/Admin.jsp").forward(request, response);
	}

	public boolean validateForm(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String nameProduct = request.getParameter("nameProduct");
		String moneyProduct = request.getParameter("moneyProduct");
		String idCategory = request.getParameter("nameCategory");
		Part img =null;
		try {
			img = request.getPart("imgProduct");
		} catch (Exception e) {
			
		}
		if (img != null) {
			String imgProduct = img.getSubmittedFileName();
			if (idCategory == null || idCategory.trim().equalsIgnoreCase("")) {
				return false;
			} else if (nameProduct == null || nameProduct.trim().equalsIgnoreCase("")) {
				return false;
			} else if (moneyProduct == null || moneyProduct.trim().equalsIgnoreCase("")) {
				return false;
			} else if (imgProduct == null || imgProduct.trim().equalsIgnoreCase("Thể loại")) {
				return false;
			}
		} else {

			if (idCategory == null || idCategory.trim().equalsIgnoreCase("")) {
				return false;
			} else if (moneyProduct == null || moneyProduct.trim().equalsIgnoreCase("")) {
				return false;
			} else if (nameProduct == null || nameProduct.trim().equalsIgnoreCase("")) {
				return false;
			}
		}

		return true;

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
	public List<Category_DTO> getListCategory_DTOWithStatus() {
		List<TblCategory> list = new ArrayList<TblCategory>();
		EntityManager em = JPA_Utils.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			TypedQuery<TblCategory> query = em.createNamedQuery("TblCategory.findAllWithStatus", TblCategory.class);
			list = query.getResultList();
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		}finally {
			em.close();
		}
		List<Category_DTO> lstCategory = new ArrayList<Category_DTO>();
	    for (TblCategory c : list) {
			Category_DTO category = category_mapper.category_DTO(c);
			lstCategory.add(category);
	    }
	    return lstCategory;
	}

}
