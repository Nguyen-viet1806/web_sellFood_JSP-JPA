package vietnqv.dto.model;

import java.io.Serializable;
import java.util.List;


/**
 * The persistent class for the tblProduct database table.
 * 
 */
public class Product_DTO implements Serializable {
	private static final long serialVersionUID = 1L;

	public int idProduct;

	public String imgProduct;

	public double moneyProduct;

	public String nameProduct;

	public String noteProduct;

	public List<BillDetail_DTO> billDetails_DTO;

	public List<CartDetail_DTO> cartDetails_DTO;

	public Category_DTO category_DTO;

	public Status_DTO status_DTO;

	public Product_DTO() {
	}

	public Product_DTO(int idProduct, String imgProduct, double moneyProduct, String nameProduct, String noteProduct,
			List<BillDetail_DTO> billDetails_DTO, List<CartDetail_DTO> cartDetails_DTO, Category_DTO category_DTO,
			Status_DTO status_DTO) {
	
		this.idProduct = idProduct;
		this.imgProduct = imgProduct;
		this.moneyProduct = moneyProduct;
		this.nameProduct = nameProduct;
		this.noteProduct = noteProduct;
		this.billDetails_DTO = billDetails_DTO;
		this.cartDetails_DTO = cartDetails_DTO;
		this.category_DTO = category_DTO;
		this.status_DTO = status_DTO;
	}

	
	public int getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	public String getImgProduct() {
		return imgProduct;
	}

	public void setImgProduct(String imgProduct) {
		this.imgProduct = imgProduct;
	}

	public double getMoneyProduct() {
		return moneyProduct;
	}

	public void setMoneyProduct(double moneyProduct) {
		this.moneyProduct = moneyProduct;
	}

	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

	public String getNoteProduct() {
		return noteProduct;
	}

	public void setNoteProduct(String noteProduct) {
		this.noteProduct = noteProduct;
	}

	public List<BillDetail_DTO> getBillDetails_DTO() {
		return billDetails_DTO;
	}

	public void setBillDetails_DTO(List<BillDetail_DTO> billDetails_DTO) {
		this.billDetails_DTO = billDetails_DTO;
	}

	public List<CartDetail_DTO> getCartDetails_DTO() {
		return cartDetails_DTO;
	}

	public void setCartDetails_DTO(List<CartDetail_DTO> cartDetails_DTO) {
		this.cartDetails_DTO = cartDetails_DTO;
	}

	public Category_DTO getCategory_DTO() {
		return category_DTO;
	}

	public void setCategory_DTO(Category_DTO category_DTO) {
		this.category_DTO = category_DTO;
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
		return "Product_DTO [idProduct=" + idProduct + ", imgProduct=" + imgProduct + ", moneyProduct=" + moneyProduct
				+ ", nameProduct=" + nameProduct + ", noteProduct=" + noteProduct + ", billDetails_DTO="
				+ billDetails_DTO + ", cartDetails_DTO=" + cartDetails_DTO + ", category_DTO=" + category_DTO
				+ ", status_DTO=" + status_DTO + "]";
	}

	

}