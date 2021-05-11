package vietnqv.controller.user;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vietnqv.dto.model.Category_DTO;
import vietnqv.dto.model.Product_DTO;
import vietnqv.mapper.Category_MapperImpl;
import vietnqv.mapper.Product_MapperImpl;
import vietnqv.server.model.TblCategory;
import vietnqv.server.model.TblProduct;
import vietnqv.service.Category_Service;
import vietnqv.service.Product_Service;
import vietnqv.utils.JPA_Utils;

@WebServlet({ "/Product1User", "/Product1User/action=search" })
public class ProductUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Category_Service category_Service = new Category_Service();
	Product_Service product_Service = new Product_Service();
	Category_MapperImpl category_mapper = new Category_MapperImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		List<Category_DTO> lstCategory = getListCategory_DTOWithStatus();
		request.setAttribute("lstCategory", lstCategory);
		int page = 0;
		String action = request.getParameter("action");
		String uri = request.getRequestURI();
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
					page -= 6;
				}
			} else if (action.equalsIgnoreCase("next")) {
				page += 6;
			}

		}
		List<Product_DTO> listProducts_DTO = new ArrayList<Product_DTO>();
		List<Product_DTO> lstProducts1 = new ArrayList<Product_DTO>();
		List<Product_DTO> lstProducts2 = new ArrayList<Product_DTO>();

		if (action != null && action.equalsIgnoreCase("show")) {
			int idCategory = Integer.parseInt(request.getParameter("idCategory"));
			listProducts_DTO.removeAll(listProducts_DTO);
			listProducts_DTO = getListProductInCatgegory(idCategory);
		} else if (uri != null && uri.contains("search")) {
			String textSearch = request.getParameter("textSearch");
			listProducts_DTO.removeAll(listProducts_DTO);
			listProducts_DTO = product_Service.search(textSearch);
		} else {
			listProducts_DTO.removeAll(listProducts_DTO);
			listProducts_DTO = product_Service.getListPage(page, 6);
		}

		if (listProducts_DTO.size() >= 6) {
			for (int i = 0; i < 3; i++) {
				lstProducts1.add(listProducts_DTO.get(i));
			}
			for (int i = 3; i < 6; i++) {
				lstProducts2.add(listProducts_DTO.get(i));
			}
		} else {
			lstProducts1 = listProducts_DTO;
		}
		request.setAttribute("lstProduct1", lstProducts1);
		request.setAttribute("lstProduct2", lstProducts2);
		request.setAttribute("page", page);
		request.setAttribute("tieude", "Đây là trang product");
		request.setAttribute("View", "/view/User/ProductUser.jsp");
		request.getRequestDispatcher("/view/User/User.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("tieude", "Đây là trang product");
	}

	public List<Product_DTO> getListProductInCatgegory(int keyword) {
		EntityManager em = JPA_Utils.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		List<TblProduct> lstProduct = new ArrayList<TblProduct>();
		try {
			trans.begin();
			TypedQuery<TblProduct> query = em.createNamedQuery("TblProduct.show", TblProduct.class);
			query.setParameter("keyword", keyword);
			lstProduct = query.getResultList();
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		} finally {
			em.close();
		}
		Product_MapperImpl product_mapper = new Product_MapperImpl();
		List<Product_DTO> lstProduct_DTO1 = new ArrayList<Product_DTO>();
		for (TblProduct p : lstProduct) {
			Product_DTO product = product_mapper.product_DTO(p);
			lstProduct_DTO1.add(product);
		}
		return lstProduct_DTO1;

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
