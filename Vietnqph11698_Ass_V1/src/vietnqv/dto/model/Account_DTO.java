package vietnqv.dto.model;

import java.io.Serializable;


public class Account_DTO implements Serializable {
	private static final long serialVersionUID = 1L;

	public int idAccount;

	public String email;

	public String password;

	public Role_DTO role_DTO;

	public Status_DTO status_DTO;

	public User_DTO user_DTO;

	public Account_DTO() {

	}

	public Account_DTO(int idAccount, String email, String password, Role_DTO role_DTO, Status_DTO status_DTO,
			User_DTO user_DTO) {
		super();
		this.idAccount = idAccount;
		this.email = email;
		this.password = password;
		this.role_DTO = role_DTO;
		this.status_DTO = status_DTO;
		this.user_DTO = user_DTO;
	}
	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getIdAccount() {
		return idAccount;
	}

	public void setIdAccount(int idAccount) {
		this.idAccount = idAccount;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role_DTO getRole_DTO() {
		return role_DTO;
	}

	public void setRole_DTO(Role_DTO role_DTO) {
		this.role_DTO = role_DTO;
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

	@Override
	public String toString() {
		return "Account_DTO [idAccount=" + idAccount + ", email=" + email + ", password=" + password + ", role_DTO="
				+ role_DTO + ", status_DTO=" + status_DTO + ", user_DTO=" + user_DTO + "]";
	}

	
}