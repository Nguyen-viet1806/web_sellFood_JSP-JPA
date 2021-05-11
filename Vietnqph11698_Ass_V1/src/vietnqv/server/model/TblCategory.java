package vietnqv.server.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tblCategory database table.
 * 
 */
@Entity
@Table(name="tblCategory")
@NamedQueries({
	@NamedQuery(name="TblCategory.findAll", query="SELECT t FROM TblCategory t"),
	@NamedQuery(name="TblCategory.findAllWithStatus", query="SELECT t FROM TblCategory t Where t.tblStatus.idStatus =1"),
	@NamedQuery(name="TblCategory.search", query="SELECT t FROM TblCategory t"+" WHERE  t.nameCategory Like :keyword")
})

public class TblCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCategory;

	private String nameCategory;

	//bi-directional many-to-one association to TblStatus
	@ManyToOne
	@JoinColumn(name="idStatus")
	private TblStatus tblStatus;

	//bi-directional many-to-one association to TblProduct
	@OneToMany(mappedBy="tblCategory",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<TblProduct> tblProducts;

	public TblCategory() {
	}

	public TblCategory(Integer idCategory, String nameCategory, TblStatus tblStatus, List<TblProduct> tblProducts) {
	
		this.idCategory = idCategory;
		this.nameCategory = nameCategory;
		this.tblStatus = tblStatus;
		this.tblProducts = tblProducts;
	}

	public Integer getIdCategory() {
		return this.idCategory;
	}

	public void setIdCategory(Integer idCategory) {
		this.idCategory = idCategory;
	}

	public String getNameCategory() {
		return this.nameCategory;
	}

	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
	}

	public TblStatus getTblStatus() {
		return this.tblStatus;
	}

	public void setTblStatus(TblStatus tblStatus) {
		this.tblStatus = tblStatus;
	}

	public List<TblProduct> getTblProducts() {
		return this.tblProducts;
	}

	public void setTblProducts(List<TblProduct> tblProducts) {
		this.tblProducts = tblProducts;
	}

	public TblProduct addTblProduct(TblProduct tblProduct) {
		getTblProducts().add(tblProduct);
		tblProduct.setTblCategory(this);

		return tblProduct;
	}

	public TblProduct removeTblProduct(TblProduct tblProduct) {
		getTblProducts().remove(tblProduct);
		tblProduct.setTblCategory(null);

		return tblProduct;
	}

}