package vietnqv.server.model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the tblBill database table.
 * 
 */
@Entity
@Table(name="tblBill")
@NamedQueries({
@NamedQuery(name="TblBill.findAll", query="SELECT t FROM TblBill t"),
@NamedQuery(name="TblBill.findAllInStatus", query="SELECT t FROM TblBill t where t.tblStatus.idStatus =:keyword and t.tblUser.idUser =:keyword1"),
@NamedQuery(name="TblBill.findAllInUser", query="SELECT t FROM TblBill t where  t.tblUser.idUser =:keyword"),
})
public class TblBill implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idBill;

	private Date dateOrder;

	private String noteBill;

	//bi-directional many-to-one association to TblStatus
	@ManyToOne
	@JoinColumn(name="idStatus")
	private TblStatus tblStatus;

	//bi-directional many-to-one association to TblUser
	@ManyToOne
	@JoinColumn(name="idUser")
	private TblUser tblUser;

	//bi-directional many-to-one association to TblBillDetail
	@OneToMany(mappedBy="tblBill",cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
	private List<TblBillDetail> tblBillDetails;

	public TblBill() {
	}

	public TblBill(Integer idBill, Date dateOrder, String noteBill, TblStatus tblStatus, TblUser tblUser,
			List<TblBillDetail> tblBillDetails) {
		
		this.idBill = idBill;
		this.dateOrder = dateOrder;
		this.noteBill = noteBill;
		this.tblStatus = tblStatus;
		this.tblUser = tblUser;
		this.tblBillDetails = tblBillDetails;
	}

	public Integer getIdBill() {
		return this.idBill;
	}

	public void setIdBill(Integer idBill) {
		this.idBill = idBill;
	}

	public Date getDateOrder() {
		return this.dateOrder;
	}

	public void setDateOrder(Date dateOrder) {
		this.dateOrder = dateOrder;
	}

	public String getNoteBill() {
		return this.noteBill;
	}

	public void setNoteBill(String noteBill) {
		this.noteBill = noteBill;
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

	public List<TblBillDetail> getTblBillDetails() {
		return this.tblBillDetails;
	}

	public void setTblBillDetails(List<TblBillDetail> tblBillDetails) {
		this.tblBillDetails = tblBillDetails;
	}

	public TblBillDetail addTblBillDetail(TblBillDetail tblBillDetail) {
		getTblBillDetails().add(tblBillDetail);
		tblBillDetail.setTblBill(this);

		return tblBillDetail;
	}

	public TblBillDetail removeTblBillDetail(TblBillDetail tblBillDetail) {
		getTblBillDetails().remove(tblBillDetail);
		tblBillDetail.setTblBill(null);

		return tblBillDetail;
	}

}