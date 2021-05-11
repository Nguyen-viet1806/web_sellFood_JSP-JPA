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

import vietnqv.dto.model.Account_DTO;
import vietnqv.dto.model.Bill_DTO;
import vietnqv.dto.model.Status_DTO;
import vietnqv.dto.model.User_DTO;
import vietnqv.mapper.Bill_MapperImpl;
import vietnqv.server.model.TblBill;
import vietnqv.service.Account_Service;
import vietnqv.service.Bill_Service;
import vietnqv.service.Status_Service;
import vietnqv.service.User_Service;
import vietnqv.utils.Cookies_Utils;
import vietnqv.utils.JPA_Utils;

@WebServlet("/Bill1User")
public class BillUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Bill_MapperImpl bill_mapper = new Bill_MapperImpl();
	Account_Service account_Service = new Account_Service();
	User_Service user_Service = new User_Service();
	Bill_Service bill_Service = new Bill_Service();
	Status_Service status_Service = new Status_Service();
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		User_DTO user_DTO = new User_DTO();
		String email = Cookies_Utils.getCookie("email", "không");
		// kiem tra nếu k có tài khoản vào login khi ấn vào giỏ hàng
		if (!email.equals("không") && !email.equals("")) {
			List<Account_DTO> lstAccount_DTO = account_Service.search(email);
			Account_DTO account_DTO = lstAccount_DTO.get(0);
			user_DTO = user_Service.find(account_DTO.getUser_DTO().getIdUser());

		} else {
			request.getRequestDispatcher("/view/Login/Login.jsp").forward(request, response);
		}
		String action = request.getParameter("action");
		int idUser = user_DTO.getIdUser();
		List<Bill_DTO> lstBill = getListBill(3, idUser);
		if (action != null && !action.equalsIgnoreCase("")) {
			if (action.equalsIgnoreCase("xuLi")) {

				lstBill = getListBill(3, idUser);
				request.setAttribute("lstbill", lstBill);
			} else if (action.equalsIgnoreCase("xacNhan")) {

				lstBill = getListBill(4, idUser);
				request.setAttribute("lstbill", lstBill);
			} else if (action.equalsIgnoreCase("dangGiao")) {
				request.setAttribute("updateBill", " ");

				lstBill = getListBill(5, idUser);
				request.setAttribute("lstbill", lstBill);
			} else if (action.equalsIgnoreCase("thanhCong")) {
                
				lstBill = getListBill(6, idUser);
				request.setAttribute("lstbill", lstBill);
			}else if(action.equalsIgnoreCase("updateBillTT")) {
				int idBill=-1;
				try {
					idBill = Integer.parseInt(request.getParameter("idBill"));
				} catch (Exception e) {
					e.printStackTrace();
				}
				if(idBill>0) {
					Status_DTO status_DTO = status_Service.find(6);
					Bill_DTO bill_DTO = bill_Service.find(idBill);
					bill_DTO.setStatus_DTO(status_DTO);
					int check = bill_Service.update(bill_DTO);
					if (check == 2) {
						lstBill = getListBill(6, idUser);
						request.setAttribute("lstbill", lstBill);
					}
				}
			}
		}

		request.setAttribute("lstbill", lstBill);
		request.setAttribute("tieude", "Đây là trang bill");
		request.setAttribute("View", "/view/User/BillUser.jsp");
		request.getRequestDispatcher("/view/User/User.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
	}

	public List<Bill_DTO> getListBill(int idStatus, int idUser) {
		List<TblBill> list = new ArrayList<TblBill>();
		EntityManager em = JPA_Utils.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			TypedQuery<TblBill> query = em.createNamedQuery("TblBill.findAllInStatus", TblBill.class);
			query.setParameter("keyword", idStatus);
			query.setParameter("keyword1", idUser);
			list = query.getResultList();
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
		} finally {
			em.close();
		}
		List<Bill_DTO> lstBill = new ArrayList<Bill_DTO>();
		for (TblBill bl : list) {
			Bill_DTO bill = bill_mapper.bill_DTO(bl);
			lstBill.add(bill);
		}
		return lstBill;
	}
}
