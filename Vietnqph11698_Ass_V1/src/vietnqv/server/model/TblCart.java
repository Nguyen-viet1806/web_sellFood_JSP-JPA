package vietnqv.server.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tblCart database table.
 * 
 */
@Entity
@Table(name="tblCart")
@NamedQuery(name="TblCart.findAll", query="SELECT t FROM TblCart t")
public class TblCart implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCart;

	private String noteCart;

	//bi-directional many-to-one association to TblStatus
	@ManyToOne
	@JoinColumn(name="idStatus")
	private TblStatus tblStatus;

	//bi-directional many-to-one association to TblUser
	@ManyToOne
	@JoinColumn(name="idUser")
	private TblUser tblUser;

	//bi-directional many-to-one association to TblCartDetail
	@OneToMany(mappedBy="tblCart",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<TblCartDetail> tblCartDetails;

	public TblCart() {
	}

	public TblCart(Integer idCart, String noteCart, TblStatus tblStatus, TblUser tblUser,
			List<TblCartDetail> tblCartDetails) {
		
		this.idCart = idCart;
		this.noteCart = noteCart;
		this.tblStatus = tblStatus;
		this.tblUser = tblUser;
		this.tblCartDetails = tblCartDetails;
	}

	public Integer getIdCart() {
		return this.idCart;
	}

	public void setIdCart(Integer idCart) {
		this.idCart = idCart;
	}

	public String getNoteCart() {
		return this.noteCart;
	}

	public void setNoteCart(String noteCart) {
		this.noteCart = noteCart;
	}

	public TblStatus getTblStatus() {
		return this.tblStatus;
	}

	public void setTblStatus(TblStatus tblStatus) {
		this.tblStatus = tblStatus;
	}

	public TblUser getTblUser() {
		return this.tblUser;
	}

	public void setTblUser(TblUser tblUser) {
		this.tblUser = tblUser;
	}

	public List<TblCartDetail> getTblCartDetails() {
		return this.tblCartDetails;
	}

	public void setTblCartDetails(List<TblCartDetail> tblCartDetails) {
		this.tblCartDetails = tblCartDetails;
	}

	public TblCartDetail addTblCartDetail(TblCartDetail tblCartDetail) {
		getTblCartDetails().add(tblCartDetail);
		tblCartDetail.setTblCart(this);

		return tblCartDetail;
	}

	public TblCartDetail removeTblCartDetail(TblCartDetail tblCartDetail) {
		getTblCartDetails().remove(tblCartDetail);
		tblCartDetail.setTblCart(null);

		return tblCartDetail;
	}

}