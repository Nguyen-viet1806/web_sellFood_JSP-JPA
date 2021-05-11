package vietnqv.server.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tblProduct database table.
 * 
 */
@Entity
@Table(name="tblProduct")
@NamedQueries({
	@NamedQuery(name="TblProduct.findAll", query="SELECT t FROM TblProduct t"),
	@NamedQuery(name="TblProduct.findAllWithStatus", query="SELECT t FROM TblProduct t Where t.tblStatus.idStatus =1"),
	@NamedQuery(name="TblProduct.search", query="SELECT t FROM TblProduct t"+" WHERE  t.nameProduct Like :keyword"),
	@NamedQuery(name="TblProduct.show", query="SELECT t FROM TblProduct t"+" WHERE  t.tblCategory.idCategory = :keyword")
})

public class TblProduct implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idProduct;

	private String imgProduct;

	private Double moneyProduct;

	private String nameProduct;

	private String noteProduct;

	//bi-directional many-to-one association to TblBillDetail
	@OneToMany(mappedBy="tblProduct",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<TblBillDetail> tblBillDetails;

	//bi-directional many-to-one association to TblCartDetail
	@OneToMany(mappedBy="tblProduct",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<TblCartDetail> tblCartDetails;

	//bi-directional many-to-one association to TblCategory
	@ManyToOne
	@JoinColumn(name="idCategory")
	private TblCategory tblCategory;

	//bi-directional many-to-one association to TblStatus
	@ManyToOne
	@JoinColumn(name="idStatus")
	private TblStatus tblStatus;

	public TblProduct() {
	}

	public TblProduct(Integer idProduct, String imgProduct, Double moneyProduct, String nameProduct, String noteProduct,
			List<TblBillDetail> tblBillDetails, List<TblCartDetail> tblCartDetails, TblCategory tblCategory,
			TblStatus tblStatus) {
	
		this.idProduct = idProduct;
		this.imgProduct = imgProduct;
		this.moneyProduct = moneyProduct;
		this.nameProduct = nameProduct;
		this.noteProduct = noteProduct;
		this.tblBillDetails = tblBillDetails;
		this.tblCartDetails = tblCartDetails;
		this.tblCategory = tblCategory;
		this.tblStatus = tblStatus;
	}

	public Integer getIdProduct() {
		return this.idProduct;
	}

	public void setIdProduct(Integer idProduct) {
		this.idProduct = idProduct;
	}

	public String getImgProduct() {
		return this.imgProduct;
	}

	public void setImgProduct(String imgProduct) {
		this.imgProduct = imgProduct;
	}

	public Double getMoneyProduct() {
		return this.moneyProduct;
	}

	public void setMoneyProduct(Double moneyProduct) {
		this.moneyProduct = moneyProduct;
	}

	public String getNameProduct() {
		return this.nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

	public String getNoteProduct() {
		return this.noteProduct;
	}

	public void setNoteProduct(String noteProduct) {
		this.noteProduct = noteProduct;
	}

	public List<TblBillDetail> getTblBillDetails() {
		return this.tblBillDetails;
	}

	public void setTblBillDetails(List<TblBillDetail> tblBillDetails) {
		this.tblBillDetails = tblBillDetails;
	}

	public TblBillDetail addTblBillDetail(TblBillDetail tblBillDetail) {
		getTblBillDetails().add(tblBillDetail);
		tblBillDetail.setTblProduct(this);

		return tblBillDetail;
	}

	public TblBillDetail removeTblBillDetail(TblBillDetail tblBillDetail) {
		getTblBillDetails().remove(tblBillDetail);
		tblBillDetail.setTblProduct(null);

		return tblBillDetail;
	}

	public List<TblCartDetail> getTblCartDetails() {
		return this.tblCartDetails;
	}

	public void setTblCartDetails(List<TblCartDetail> tblCartDetails) {
		this.tblCartDetails = tblCartDetails;
	}

	public TblCartDetail addTblCartDetail(TblCartDetail tblCartDetail) {
		getTblCartDetails().add(tblCartDetail);
		tblCartDetail.setTblProduct(this);

		return tblCartDetail;
	}

	public TblCartDetail removeTblCartDetail(TblCartDetail tblCartDetail) {
		getTblCartDetails().remove(tblCartDetail);
		tblCartDetail.setTblProduct(null);

		return tblCartDetail;
	}

	public TblCategory getTblCategory() {
		return this.tblCategory;
	}

	public void setTblCategory(TblCategory tblCategory) {
		this.tblCategory = tblCategory;
	}

	public TblStatus getTblStatus() {
		return this.tblStatus;
	}

	public void setTblStatus(TblStatus tblStatus) {
		this.tblStatus = tblStatus;
	}

}