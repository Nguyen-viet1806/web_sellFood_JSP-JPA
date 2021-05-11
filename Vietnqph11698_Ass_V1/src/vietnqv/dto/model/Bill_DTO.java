package vietnqv.dto.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;




public class Bill_DTO implements Serializable {
	private static final long serialVersionUID = 1L;

	
	public int idBill;

	public Date dateOrder;

	public String noteBill;

	
	public Status_DTO status_DTO;

	
	public User_DTO user_DTO;

	
	public List<BillDetail_DTO> billDetails_DTO;

	public Bill_DTO() {
	}

	public Bill_DTO(int idBill, Date dateOrder, String noteBill, Status_DTO status_DTO, User_DTO user_DTO,
			List<BillDetail_DTO> billDetails_DTO) {
		
		this.idBill = idBill;
		this.dateOrder = dateOrder;
		this.noteBill = noteBill;
		this.status_DTO = status_DTO;
		this.user_DTO = user_DTO;
		this.billDetails_DTO = billDetails_DTO;
	}

	
	public int getIdBill() {
		return idBill;
	}

	public void setIdBill(int idBill) {
		this.idBill = idBill;
	}

	public Date getDateOrder() {
		return dateOrder;
	}

	public void setDateOrder(Date dateOrder) {
		this.dateOrder = dateOrder;
	}

	public String getNoteBill() {
		return noteBill;
	}

	public void setNoteBill(String noteBill) {
		this.noteBill = noteBill;
	}

	public Status_DTO getStatus_DTO() {
		return status_DTO;
	}

	public void setStatus_DTO(Status_DTO status_DTO) {
		this.status_DTO = status_DTO;
	}

	public User_DTO getUser_DTO() {
		return user_DTO;
	}

	public void setUser_DTO(User_DTO user_DTO) {
		this.user_DTO = user_DTO;
	}

	public List<BillDetail_DTO> getBillDetails_DTO() {
		return billDetails_DTO;
	}

	public void setBillDetails_DTO(List<BillDetail_DTO> billDetails_DTO) {
		this.billDetails_DTO = billDetails_DTO;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Bill_DTO [idBill=" + idBill + ", dateOrder=" + dateOrder + ", noteBill=" + noteBill + ", status_DTO="
				+ status_DTO + ", user_DTO=" + user_DTO + ", billDetails_DTO=" + billDetails_DTO + "]";
	}

	

	

}