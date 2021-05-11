package vietnqv.dto.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the tblUser database table.
 * 
 */
public class User_DTO implements Serializable {
	private static final long serialVersionUID = 1L;

	public int idUser;

	public String addressUser;

	public Date birthDayUser;

	public String imgUser;

	public String nameUser;

	public String noteUser;

	public String phoneNumber;

	public List<Account_DTO> accounts_DTO;
	
	public List<Bill_DTO> bills_DTO;

	public List<Cart_DTO> carts_DTO;

	public Status_DTO status_DTO;

	public User_DTO() {
	}

	public User_DTO(int idUser, String addressUser, Date birthDayUser, String imgUser, String nameUser,
			String noteUser, String phoneNumber, List<Account_DTO> accounts_DTO, List<Bill_DTO> bills_DTO,
			List<Cart_DTO> carts_DTO, Status_DTO status_DTO) {
		
		this.idUser = idUser;
		this.addressUser = addressUser;
		this.birthDayUser = birthDayUser;
		this.imgUser = imgUser;
		this.nameUser = nameUser;
		this.noteUser = noteUser;
		this.phoneNumber = phoneNumber;
		this.accounts_DTO = accounts_DTO;
		this.bills_DTO = bills_DTO;
		this.carts_DTO = carts_DTO;
		this.status_DTO = status_DTO;
	}

	
	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getAddressUser() {
		return addressUser;
	}

	public void setAddressUser(String addressUser) {
		this.addressUser = addressUser;
	}

	public Date getBirthDayUser() {
		return birthDayUser;
	}

	public void setBirthDayUser(Date birthDayUser) {
		this.birthDayUser = birthDayUser;
	}

	public String getImgUser() {
		return imgUser;
	}

	public void setImgUser(String imgUser) {
		this.imgUser = imgUser;
	}

	public String getNameUser() {
		return nameUser;
	}

	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}

	public String getNoteUser() {
		return noteUser;
	}

	public void setNoteUser(String noteUser) {
		this.noteUser = noteUser;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<Account_DTO> getAccounts_DTO() {
		return accounts_DTO;
	}

	public void setAccounts_DTO(List<Account_DTO> accounts_DTO) {
		this.accounts_DTO = accounts_DTO;
	}

	public List<Bill_DTO> getBills_DTO() {
		return bills_DTO;
	}

	public void setBills_DTO(List<Bill_DTO> bills_DTO) {
		this.bills_DTO = bills_DTO;
	}

	public List<Cart_DTO> getCarts_DTO() {
		return carts_DTO;
	}

	public void setCarts_DTO(List<Cart_DTO> carts_DTO) {
		this.carts_DTO = carts_DTO;
	}

	public Status_DTO getStatus_DTO() {
		return status_DTO;
	}

	public void setStatus_DTO(Status_DTO status_DTO) {
		this.status_DTO = status_DTO;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "User_DTO [idUser=" + idUser + ", addressUser=" + addressUser + ", birthDayUser=" + birthDayUser
				+ ", imgUser=" + imgUser + ", nameUser=" + nameUser + ", noteUser=" + noteUser + ", phoneNumber="
				+ phoneNumber + ", accounts_DTO=" + accounts_DTO + ", bills_DTO=" + bills_DTO + ", carts_DTO="
				+ carts_DTO + ", status_DTO=" + status_DTO + "]";
	}


}