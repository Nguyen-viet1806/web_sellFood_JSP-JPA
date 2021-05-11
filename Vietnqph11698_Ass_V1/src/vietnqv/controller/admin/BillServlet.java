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
import vietnqv.dto.model.BillDetail_DTO;
import vietnqv.dto.model.Bill_DTO;
import vietnqv.dto.model.Status_DTO;
import vietnqv.service.Account_Service;
import vietnqv.service.BillDtail_Service;
import vietnqv.service.Bill_Service;
import vietnqv.service.Status_Service;
import vietnqv.utils.Cookies_Utils;

@WebServlet({ "/BillServlet", "/BillServlet/UpdateBill" })
public class BillServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Account_Service account_Service = new Account_Service();
	Bill_Service bill_Service = new Bill_Service();
	Status_Service status_Service = new Status_Service();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		BillDtail_Service billDtail_Service = new BillDtail_Service();
		Account_DTO account_DTO = getAccount_DTO(request, response);
		List<BillDetail_DTO> lstBillDetail = new ArrayList<BillDetail_DTO>();
		int idBill;
		String action = request.getParameter("action");
		if (action != null && !action.equals("")) {
			if (action.equalsIgnoreCase("off")) {
				request.setAttribute("menuSmart", "style=\"display: none\"");
				request.setAttribute("menuSmart1", "");
			} else if (action.equalsIgnoreCase("on")) {
				request.setAttribute("menuSmart", "");
				request.setAttribute("menuSmart1", "style=\"display: none\"");
			} else if (action.equalsIgnoreCase("showBill")) {
				idBill = Integer.parseInt(request.getParameter("idBill"));
				Bill_DTO bill_DTO = bill_Service.find(idBill);
				request.setAttribute("input1", bill_DTO.getIdBill());
				request.setAttribute("input2", bill_DTO.getUser_DTO().getNameUser());
				request.setAttribute("input3", bill_DTO.getDateOrder());
				request.setAttribute("input4", bill_DTO.getNoteBill());
				request.setAttribute("imgBill", null);
				request.setAttribute("lbl1", "ID Bill:");
				request.setAttribute("lbl2", "Name User:");
				request.setAttribute("lbl3", "Date Oder:");
				request.setAttribute("lbl4", "Note:");
				request.setAttribute("Bill", bill_DTO);
				if(bill_DTO.getStatus_DTO().getIdStatus()==6) {
					request.setAttribute("sumbitBill", "style=\"display: none\"");
				}
				lstBillDetail = billDtail_Service.search(request.getParameter("idBill"));
				request.setAttribute("lstBillDetail", lstBillDetail);
			} else if (action.equalsIgnoreCase("showBillDetail")) {
				idBill = Integer.parseInt(request.getParameter("idBill"));
				int idBillDetail = Integer.parseInt(request.getParameter("idBillDetail"));
				BillDetail_DTO billDetail_DTO = billDtail_Service.find(idBillDetail);
				request.setAttribute("input1", billDetail_DTO.getIdBillDetail());
				request.setAttribute("input2", billDetail_DTO.getBill_DTO().getIdBill());
				request.setAttribute("input3", billDetail_DTO.getProduct_DTO().getNameProduct());
				request.setAttribute("input4", billDetail_DTO.getQuantityProduct());
				request.setAttribute("imgProduct", billDetail_DTO.getProduct_DTO().getImgProduct());
				request.setAttribute("imgBill", "");
				request.setAttribute("lbl1", "ID BillDetail:");
				request.setAttribute("lbl2", "ID Bill:");
				request.setAttribute("lbl3", "Name Product:");
				request.setAttribute("lbl4", "Quantity:");
				request.setAttribute("statusBill", "style=\"display: none\"");
				request.setAttribute("sumbitBill", "style=\"display: none\"");
				lstBillDetail = billDtail_Service.search(request.getParameter("idBill"));
				request.setAttribute("lstBillDetail", lstBillDetail);
			}
		}

		List<Bill_DTO> listBIll = bill_Service.selectAll();
		List<Status_DTO> listStatus = status_Service.selectAll();
		request.setAttribute("listStatus", listStatus);
		request.setAttribute("listBIll", listBIll);
		request.setAttribute("account", account_DTO);
		request.setAttribute("tieude", "Đây là trang bill");
		request.setAttribute("View", "../Admin/Bill/Bill.jsp");
		request.getRequestDispatcher("/view/Admin/Admin.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String xanh = "#13eba2";
		String cam = "#ff966c";
		request.setAttribute("tieude", "Đây là trang bill");
		String uri = request.getRequestURI();
		Account_DTO account_DTO = getAccount_DTO(request, response);
		if (uri.contains("/BillServlet/UpdateBill")) {
			int id = 0;
			try {
				id = Integer.parseInt(request.getParameter("id") + "");
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (id == 0) {
				request.setAttribute("style", "block");
				request.setAttribute("backgroundErro", cam);
				request.setAttribute("content", "Mời bạn chọn một cái bill rồi hãy update!!!");
			} else {
				int idStatus = 0;
				try {
					idStatus = Integer.parseInt(request.getParameter("statusBill") + "");
				} catch (Exception e) {
				e.printStackTrace();
				}

				if (idStatus == 1 || idStatus == 2 || idStatus == 6 || idStatus == 7 || idStatus == 0) {
					request.setAttribute("style", "block");
					request.setAttribute("backgroundErro", cam);
					request.setAttribute("content", "Trạng thái này không hợp lệ đâu chọn cái khác đi !!");
				} else {
					Status_DTO status_DTO = status_Service.find(idStatus);
					Bill_DTO bill_DTO = bill_Service.find(id);
					bill_DTO.setStatus_DTO(status_DTO);
					int check = bill_Service.update(bill_DTO);
					if (check == 2) {
						request.setAttribute("style", "block");
						request.setAttribute("backgroundErro", xanh);
						request.setAttribute("content", "Cập nhập thành công!!");
					} else {
						request.setAttribute("style", "block");
						request.setAttribute("backgroundErro", cam);
						request.setAttribute("content", "Cập nhập thất bại!!");
					}

				}
			}
		}
		List<Bill_DTO> listBIll = bill_Service.selectAll();
		List<Status_DTO> listStatus = status_Service.selectAll();
		request.setAttribute("listStatus", listStatus);
		request.setAttribute("listBIll", listBIll);
		request.setAttribute("account", account_DTO);
		request.setAttribute("tieude", "Đây là trang bill");
		request.setAttribute("View", "../Admin/Bill/Bill.jsp");
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
		} else {
			return null;
		}

		return account_DTO;
	}
}
