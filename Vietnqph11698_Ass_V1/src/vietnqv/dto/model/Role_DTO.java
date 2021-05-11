package vietnqv.dto.model;

import java.io.Serializable;
import java.util.List;


/**
 * The persistent class for the tblRole database table.
 * 
 */
public class Role_DTO implements Serializable {
	private static final long serialVersionUID = 1L;

	public int idRole;

	public String nameRole;

	public List<Account_DTO> accounts_DTO;

	public Status_DTO status_DTO;

	public Role_DTO() {
	}

	public Role_DTO(int idRole, String nameRole, List<Account_DTO> accounts_DTO, Status_DTO status_DTO) {
		this.idRole = idRole;
		this.nameRole = nameRole;
		this.accounts_DTO = accounts_DTO;
		this.status_DTO = status_DTO;
	}

	
	public int getIdRole() {
		return idRole;
	}

	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}

	public String getNameRole() {
		return nameRole;
	}

	public void setNameRole(String nameRole) {
		this.nameRole = nameRole;
	}

	public List<Account_DTO> getAccounts_DTO() {
		return accounts_DTO;
	}

	public void setAccounts_DTO(List<Account_DTO> accounts_DTO) {
		this.accounts_DTO = accounts_DTO;
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
		return "Role_DTO [idRole=" + idRole + ", nameRole=" + nameRole + ", accounts_DTO=" + accounts_DTO
				+ ", status_DTO=" + status_DTO + "]";
	}
    
	

}