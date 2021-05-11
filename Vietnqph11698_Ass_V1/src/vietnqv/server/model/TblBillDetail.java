package vietnqv.server.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tblBillDetail database table.
 * 
 */
@Entity
@Table(name="tblBillDetail")
@NamedQueries({
@NamedQuery(name="TblBillDetail.findAll", query="SELECT t FROM TblBillDetail t "),
@NamedQuery(name="TblBillDetail.findAllInBill", query="SELECT t FROM TblBillDetail t where t.tblBill.idBill =:keyword")
})
public class TblBillDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idBillDetail;

	private Integer quantityProduct;

	//bi-directional many-to-one association to TblBill
	@ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
	@JoinColumn(name="idBill")
	private TblBill tblBill;

	//bi-directional many-to-one association to TblProduct
	@ManyToOne
	@JoinColumn(name="idProduct")
	private TblProduct tblProduct;

	public TblBillDetail() {
	}

	public TblBillDetail(Integer idBillDetail, Integer quantityProduct, TblBill tblBill, TblProduct tblProduct) {

		this.idBillDetail = idBillDetail;
		this.quantityProduct = quantityProduct;
		this.tblBill = tblBill;
		this.tblProduct = tblProduct;
	}

	public Integer getIdBillDetail() {
		return this.idBillDetail;
	}

	public void setIdBillDetail(Integer idBillDetail) {
		this.idBillDetail = idBillDetail;
	}

	public Integer getQuantityProduct() {
		return this.quantityProduct;
	}

	public void setQuantityProduct(Integer quantityProduct) {
		this.quantityProduct = quantityProduct;
	}

	public TblBill getTblBill() {
		return this.tblBill;
	}

	public void setTblBill(TblBill tblBill) {
		this.tblBill = tblBill;
	}

	public TblProduct getTblProduct() {
		return this.tblProduct;
	}

	public void setTblProduct(TblProduct tblProduct) {
		this.tblProduct = tblProduct;
	}

}