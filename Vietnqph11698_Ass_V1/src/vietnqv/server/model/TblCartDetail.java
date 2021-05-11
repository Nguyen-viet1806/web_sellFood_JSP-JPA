package vietnqv.server.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the tblCartDetail database table.
 * 
 */
@Entity
@Table(name = "tblCartDetail")
@NamedQueries({ @NamedQuery(name = "TblCartDetail.findAll", query = "SELECT t FROM TblCartDetail t where t.tblCart.idCart =:keyword"),
		@NamedQuery(name = "TblCartDetail.search", query = "SELECT t FROM TblCartDetail t WHERE  t.tblProduct.idProduct = :keyword")

})
@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(
			name = "TblCartDetail.delete", procedureName = "spCartDetail",
			parameters = {
			@StoredProcedureParameter(name = "Id", type = Integer.class) }, 
			resultClasses = { TblCartDetail.class })
})

public class TblCartDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCartDetail;

	private Integer quantityProduct;

	// bi-directional many-to-one association to TblCart
	@ManyToOne
	@JoinColumn(name = "idCart")
	private TblCart tblCart;

	// bi-directional many-to-one association to TblProduct
	@ManyToOne
	@JoinColumn(name = "idProduct")
	private TblProduct tblProduct;

	public TblCartDetail() {
	}

	public TblCartDetail(Integer idCartDetail, Integer quantityProduct, TblCart tblCart, TblProduct tblProduct) {

		this.idCartDetail = idCartDetail;
		this.quantityProduct = quantityProduct;
		this.tblCart = tblCart;
		this.tblProduct = tblProduct;
	}

	public Integer getIdCartDetail() {
		return this.idCartDetail;
	}

	public void setIdCartDetail(Integer idCartDetail) {
		this.idCartDetail = idCartDetail;
	}

	public Integer getQuantityProduct() {
		return this.quantityProduct;
	}

	public void setQuantityProduct(Integer quantityProduct) {
		this.quantityProduct = quantityProduct;
	}

	public TblCart getTblCart() {
		return this.tblCart;
	}

	public void setTblCart(TblCart tblCart) {
		this.tblCart = tblCart;
	}

	public TblProduct getTblProduct() {
		return this.tblProduct;
	}

	public void setTblProduct(TblProduct tblProduct) {
		this.tblProduct = tblProduct;
	}

}