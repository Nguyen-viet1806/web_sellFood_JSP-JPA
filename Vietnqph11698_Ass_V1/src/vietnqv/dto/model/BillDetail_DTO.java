package vietnqv.dto.model;

import java.io.Serializable;



/**
 * The persistent class for the tblBillDetail database table.
 * 
 */

public class BillDetail_DTO implements Serializable {
	private static final long serialVersionUID = 1L;

	public int idBillDetail;

	public int quantityProduct;

	public Bill_DTO bill_DTO;

	public Product_DTO product_DTO;

	public BillDetail_DTO() {
	}

	public BillDetail_DTO(int idBillDetail, int quantityProduct, Bill_DTO bill_DTO, Product_DTO product_DTO) {
		
		this.idBillDetail = idBillDetail;
		this.quantityProduct = quantityProduct;
		this.bill_DTO = bill_DTO;
		this.product_DTO = product_DTO;
	}

	
	public int getIdBillDetail() {
		return idBillDetail;
	}

	public void setIdBillDetail(int idBillDetail) {
		this.idBillDetail = idBillDetail;
	}

	public int getQuantityProduct() {
		return quantityProduct;
	}

	public void setQuantityProduct(int quantityProduct) {
		this.quantityProduct = quantityProduct;
	}

	public Bill_DTO getBill_DTO() {
		return bill_DTO;
	}

	public void setBill_DTO(Bill_DTO bill_DTO) {
		this.bill_DTO = bill_DTO;
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
		return "BillDetail_DTO [idBillDetail=" + idBillDetail + ", quantityProduct=" + quantityProduct + ", bill_DTO="
				+ bill_DTO + ", product_DTO=" + product_DTO + "]";
	}


}