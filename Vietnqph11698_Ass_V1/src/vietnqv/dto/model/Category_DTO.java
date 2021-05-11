package vietnqv.dto.model;

import java.io.Serializable;
import java.util.List;


/**
 * The persistent class for the tblCategory database table.
 * 
 */
public class Category_DTO implements Serializable {
	private static final long serialVersionUID = 1L;

	public int idCategory;

	public String nameCategory;

	public Status_DTO status_DTO;

	public List<Product_DTO> products_DTO;

	public Category_DTO() {
	}

	public Category_DTO(int idCategory, String nameCategory, Status_DTO status_DTO,
			List<Product_DTO> products_DTO) {
	
		this.idCategory = idCategory;
		this.nameCategory = nameCategory;
		this.status_DTO = status_DTO;
		this.products_DTO = products_DTO;
	}

	
	public int getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}

	public String getNameCategory() {
		return nameCategory;
	}

	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
	}

	public Status_DTO getStatus_DTO() {
		return status_DTO;
	}

	public void setStatus_DTO(Status_DTO status_DTO) {
		this.status_DTO = status_DTO;
	}

	public List<Product_DTO> getProducts_DTO() {
		return products_DTO;
	}

	public void setProducts_DTO(List<Product_DTO> products_DTO) {
		this.products_DTO = products_DTO;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Category_DTO [idCategory=" + idCategory + ", nameCategory=" + nameCategory + ", status_DTO="
				+ status_DTO + ", products_DTO=" + products_DTO + "]";
	}

}