package vietnqv.dto.model;

import java.io.Serializable;


/**
 * The persistent class for the tblCartDetail database table.
 * 
 */
public class CartDetail_DTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public int idCartDetail;

	public int quantityProduct;

	public Cart_DTO cart_DTO;

	public Product_DTO product_DTO;

	public CartDetail_DTO() {
	}

	public CartDetail_DTO(int idCartDetail, int quantityProduct, Cart_DTO cart_DTO, Product_DTO product_DTO) {
		
		this.idCartDetail = idCartDetail;
		this.quantityProduct = quantityProduct;
		this.cart_DTO = cart_DTO;
		this.product_DTO = product_DTO;
	}

	public int getIdCartDetail() {
		return idCartDetail;
	}

	public void setIdCartDetail(int idCartDetail) {
		this.idCartDetail = idCartDetail;
	}

	public int getQuantityProduct() {
		return quantityProduct;
	}

	public void setQuantityProduct(int quantityProduct) {
		this.quantityProduct = quantityProduct;
	}

	public Cart_DTO getCart_DTO() {
		return cart_DTO;
	}

	public void setCart_DTO(Cart_DTO cart_DTO) {
		this.cart_DTO = cart_DTO;
	}

	public Product_DTO getProduct_DTO() {
		return product_DTO;
	}

	public void setProduct_DTO(Product_DTO product_DTO) {
		this.product_DTO = product_DTO;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "CartDetail_DTO [idCartDetail=" + idCartDetail + ", quantityProduct=" + quantityProduct + ", cart_DTO="
				+ cart_DTO + ", product_DTO=" + product_DTO + "]";
	}

}