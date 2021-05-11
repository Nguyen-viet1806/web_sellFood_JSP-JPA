package vietnqv.dto.model;

import java.io.Serializable;
import java.util.List;


/**
 * The persistent class for the tblStatus database table.
 * 
 */
public class Status_DTO implements Serializable {
	private static final long serialVersionUID = 1L;

	public int idStatus;

	public String nameStatus;

	public List<Account_DTO> accounts_DTO;

	public List<Bill_DTO> bills_DTO;
	
	public List<Cart_DTO> carts_DTO;

	public List<Category_DTO> categories_DTO;

	public List<Product_DTO> products_DTO;
	
	public List<Role_DTO> roles_DTO;

	public List<User_DTO> users_DTO;

	public Status_DTO() {
	}

	public Status_DTO(int idStatus, String nameStatus, List<Account_DTO> accounts_DTO, List<Bill_DTO> bills_DTO,
			List<Cart_DTO> carts_DTO, List<Category_DTO> categories_DTO, List<Product_DTO> products_DTO,
			List<Role_DTO> roles_DTO, List<User_DTO> users_DTO) {
		
		this.idStatus = idStatus;
		this.nameStatus = nameStatus;
		this.accounts_DTO = accounts_DTO;
		this.bills_DTO = bills_DTO;
		this.carts_DTO = carts_DTO;
		this.categories_DTO = categories_DTO;
		this.products_DTO = products_DTO;
		this.roles_DTO = roles_DTO;
		this.users_DTO = users_DTO;
	}

	
	public int getIdStatus() {
		return idStatus;
	}

	public void setIdStatus(int idStatus) {
		this.idStatus = idStatus;
	}

	public String getNameStatus() {
		return nameStatus;
	}

	public void setNameStatus(String nameStatus) {
		this.nameStatus = nameStatus;
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

	public List<Category_DTO> getCategories_DTO() {
		return categories_DTO;
	}

	public void setCategories_DTO(List<Category_DTO> categories_DTO) {
		this.categories_DTO = categories_DTO;
	}

	public List<Product_DTO> getProducts_DTO() {
		return products_DTO;
	}

	public void setProducts_DTO(List<Product_DTO> products_DTO) {
		this.products_DTO = products_DTO;
	}

	public List<Role_DTO> getRoles_DTO() {
		return roles_DTO;
	}

	public void setRoles_DTO(List<Role_DTO> roles_DTO) {
		this.roles_DTO = roles_DTO;
	}

	public List<User_DTO> getUsers_DTO() {
		return users_DTO;
	}

	public void setUsers_DTO(List<User_DTO> users_DTO) {
		this.users_DTO = users_DTO;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Status_DTO [idStatus=" + idStatus + ", nameStatus=" + nameStatus + ", accounts_DTO=" + accounts_DTO
				+ ", bills_DTO=" + bills_DTO + ", carts_DTO=" + carts_DTO + ", categories_DTO=" + categories_DTO
				+ ", products_DTO=" + products_DTO + ", roles_DTO=" + roles_DTO + ", users_DTO=" + users_DTO + "]";
	}
    
	
	

}