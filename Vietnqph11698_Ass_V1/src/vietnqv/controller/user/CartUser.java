package vietnqv.controller.user;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vietnqv.dto.model.Account_DTO;
import vietnqv.dto.model.BillDetail_DTO;
import vietnqv.dto.model.Bill_DTO;
import vietnqv.dto.model.CartDetail_DTO;
import vietnqv.dto.model.Cart_DTO;
import vietnqv.dto.model.Product_DTO;
import vietnqv.dto.model.User_DTO;
import vietnqv.mapper.CartDetail_MapperImpl;
import vietnqv.server.model.TblCartDetail;
import vietnqv.service.Account_Service;
import vietnqv.service.BillDtail_Service;
import vietnqv.service.Bill_Service;
import vietnqv.service.CartDetail_Service;
import vietnqv.service.Product_Service;
import vietnqv.service.User_Service;
import vietnqv.utils.Cookies_Utils;
import vietnqv.utils.JPA_Utils;

@WebServlet({ "/Cart1User", "/Cart1User/UpdateCart", "/Cart1User/Pay" })
public class CartUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CartDetail_Service cartDetail_Service = new CartDetail_Service();
	Account_Service account_Service = new Account_Service();
	User_Service user_Service = new User_Service();
	Product_Service product_Service = new Product_Service();
	List<CartDetail_DTO> lstCartDetail = new ArrayList<>();
	BillDtail_Service billDtail_Service = new BillDtail_Service();
	Bill_Service bill_Service = new Bill_Service();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idProduct = request.getParameter("idProduct");
		String idCartDetail = request.getParameter("idCartDetail");
		String action = request.getParameter("action");
		Cart_DTO cart_DTO = new Cart_DTO();
		String email = Cookies_Utils.getCookie("email", "không");
		// kiem tra nếu k có tài khoản vào login khi ấn vào giỏ hàng
		if (!email.equals("không") && !email.equals("")) {
			List<Account_DTO> lstAccount_DTO = account_Service.search(email);
			Account_DTO account_DTO = lstAccount_DTO.get(0);
			User_DTO user_DTO = user_Service.find(account_DTO.getUser_DTO().getIdUser());
			cart_DTO = user_DTO.getCarts_DTO().get(0);
		} else {
			request.getRequestDispatcher("/view/Login/Login.jsp").forward(request, response);
		}
//delete 
		if (action != null && !action.equals("")) {
			if (action.equalsIgnoreCase("delete")) {
				int idcd = Integer.parseInt(idCartDetail);
				CartDetail_DTO cartDetail_DTO = cartDetail_Service.find(idcd);
				cartDetail_Service.delete(cartDetail_DTO);
			}

		}
		if (idProduct != null && !idProduct.equals("")) {
			Account_DTO account_DTO = new Account_DTO();
			if (!email.equals("không")) {
				CartDetail_DTO check = getCartDetail_DTO(idProduct);
				if (check != null) {
					int quantity = check.getQuantityProduct() + 1;
					check.setQuantityProduct(quantity);
					cartDetail_Service.update(check);
				} else {
					List<Account_DTO> lstAccount_DTO = account_Service.search(email);
					account_DTO = lstAccount_DTO.get(0);
					User_DTO user_DTO = user_Service.find(account_DTO.getUser_DTO().getIdUser());
					cart_DTO = user_DTO.getCarts_DTO().get(0);
					CartDetail_DTO cartDetail_DTO = new CartDetail_DTO();
					int idpr = Integer.parseInt(idProduct);
					Product_DTO product_DTO = product_Service.find(idpr);
					cartDetail_DTO.setProduct_DTO(product_DTO);
					cartDetail_DTO.setCart_DTO(cart_DTO);
					cartDetail_DTO.setQuantityProduct(1);
					cartDetail_Service.create(cartDetail_DTO);
				}
			} else {
				request.getRequestDispatcher("/view/Login/Login.jsp").forward(request, response);
			}

		}

		double tt = 0;
		lstCartDetail = getListCartDetail(cart_DTO.getIdCart());
		for (int i = 0; i < lstCartDetail.size(); i++) {
			double a = (lstCartDetail.get(i).product_DTO.moneyProduct) * (lstCartDetail.get(i).quantityProduct);
			tt += a;
		}
		request.setAttribute("tieude", "Đây là trang cart");
		request.setAttribute("PriceAll", tt);
		request.setAttribute("lstCartDetail", lstCartDetail);
		request.setAttribute("View", "/view/User/CartUser.jsp");
		request.getRequestDispatcher("/view/User/User.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		Cart_DTO cart_DTO = new Cart_DTO();
		User_DTO user_DTO = new User_DTO();
		String email = Cookies_Utils.getCookie("email", "không");
		// kiem tra nếu k có tài khoản vào login khi ấn vào giỏ hàng
		if (!email.equals("không") && !email.equals("")) {
			List<Account_DTO> lstAccount_DTO = account_Service.search(email);
			Account_DTO account_DTO = lstAccount_DTO.get(0);
			user_DTO = user_Service.find(account_DTO.getUser_DTO().getIdUser());
			cart_DTO = user_DTO.getCarts_DTO().get(0);
		} else {
			request.getRequestDispatcher("/view/Login/Login.jsp").forward(request, response);
		}
		if (uri.contains("/Cart1User/UpdateCart")) {
			int quatity = 1;
			for (int i = 0; i < lstCartDetail.size(); i++) {
				quatity = Integer.parseInt(request.getParameter(lstCartDetail.get(i).getIdCartDetail() + "".trim()));
				lstCartDetail.get(i).setQuantityProduct(quatity);
				cartDetail_Service.update(lstCartDetail.get(i));
			}
			double tt = 0;
			lstCartDetail = getListCartDetail(cart_DTO.getIdCart());
			for (int i = 0; i < lstCartDetail.size(); i++) {
				double a = (lstCartDetail.get(i).product_DTO.moneyProduct) * (lstCartDetail.get(i).quantityProduct);
				tt += a;
			}
			request.setAttribute("PriceAll", tt);
			request.setAttribute("lstCartDetail", lstCartDetail);
			request.setAttribute("View", "/view/User/CartUser.jsp");
			request.getRequestDispatcher("/view/User/User.jsp").forward(request, response);
		} else if (uri.contains("/Cart1User/Pay")) {
			if (user_DTO != null) {
				String xanh = "#13eba2";
				String cam = "#ff966c";
				Bill_DTO bill_DTO = new Bill_DTO();
				bill_DTO.setDateOrder(new Date());
				bill_DTO.setNoteBill("khong ghi chu");
				bill_DTO.setUser_DTO(user_DTO);

				if (lstCartDetail.size() > 0) {
					int check = bill_Service.create(bill_DTO);
					if (check == 1) {
						List<Bill_DTO> list_bill = bill_Service.search(user_DTO.getIdUser() + "".trim());
						Bill_DTO bill = new Bill_DTO();
						for (int i = 0; i < list_bill.size(); i++) {
							if (list_bill.get(i).getBillDetails_DTO().size() == 0) {
								bill = list_bill.get(i);
							}
						}
						for (int i = 0; i < lstCartDetail.size(); i++) {
							BillDetail_DTO billDetail_DTO = new BillDetail_DTO();
							billDetail_DTO.setProduct_DTO(lstCartDetail.get(i).getProduct_DTO());
							billDetail_DTO.setQuantityProduct(lstCartDetail.get(i).getQuantityProduct());
                            billDetail_DTO.setBill_DTO(bill);
                         int test=   billDtail_Service.create(billDetail_DTO);
                         if(test==1) {
                        	 cartDetail_Service.delete(lstCartDetail.get(i));
                         }
						}
						request.setAttribute("style", "block");
						request.setAttribute("backgroundErro", xanh);
						request.setAttribute("content", "Thanh toán thành công!!");
					}else {
						request.setAttribute("style", "block");
						request.setAttribute("backgroundErro", cam);
						request.setAttribute("content", "Thanh toán thất bại!!");
					}

				} else {
					request.setAttribute("style", "block");
					request.setAttribute("backgroundErro", cam);
					request.setAttribute("content", "Bạn vui lòng chọn mua sản phẩm trước để thanh tóan");
				}
			}

		}
		double tt = 0;
		lstCartDetail = getListCartDetail(cart_DTO.getIdCart());
		for (int i = 0; i < lstCartDetail.size(); i++) {
			double a = (lstCartDetail.get(i).product_DTO.moneyProduct) * (lstCartDetail.get(i).quantityProduct);
			tt += a;
		}
		request.setAttribute("tieude", "Đây là trang cart");
		request.setAttribute("PriceAll", tt);
		request.setAttribute("lstCartDetail", lstCartDetail);
		request.setAttribute("View", "/view/User/CartUser.jsp");
		request.getRequestDispatcher("/view/User/User.jsp").forward(request, response);
	}

	public CartDetail_DTO getCartDetail_DTO(String idProduct) {
		List<CartDetail_DTO> list = cartDetail_Service.search(idProduct);
		if (list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}

	}

	public List<CartDetail_DTO> getListCartDetail(int idCart) {
		List<TblCartDetail> lstCartDetail = new ArrayList<TblCartDetail>();
		EntityManager em = JPA_Utils.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		CartDetail_MapperImpl cartdetail_mapper = new CartDetail_MapperImpl();
		try {
			trans.begin();
			TypedQuery<TblCartDetail> query = em.createNamedQuery("TblCartDetail.findAll", TblCartDetail.class);
			query.setParameter("keyword", idCart);
			lstCartDetail = query.getResultList();
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		} finally {
			em.close();
		}

		List<CartDetail_DTO> lstCartDetail_DTO = new ArrayList<CartDetail_DTO>();
		for (TblCartDetail cd : lstCartDetail) {
			CartDetail_DTO cartDetail = cartdetail_mapper.cartDetail_DTO(cd);
			lstCartDetail_DTO.add(cartDetail);
		}
		return lstCartDetail_DTO;
	}
}
