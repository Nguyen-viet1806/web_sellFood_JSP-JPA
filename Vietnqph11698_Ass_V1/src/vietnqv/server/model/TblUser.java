package vietnqv.server.model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the tblUser database table.
 * 
 */
@Entity
@Table(name="tblUser")
@NamedQuery(name="TblUser.findAll", query="SELECT t FROM TblUser t")
public class TblUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idUser;

	private String addressUser;

	private Date birthDayUser;

	private String imgUser;

	private String nameUser;

	private String noteUser;

	private String phoneNumber;

	//bi-directional many-to-one association to TblAccount
	@OneToMany(mappedBy="tblUser",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<TblAccount> tblAccounts;

	//bi-directional many-to-one association to TblBill
	@OneToMany(mappedBy="tblUser",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<TblBill> tblBills;

	//bi-directional many-to-one association to TblCart
	@OneToMany(mappedBy="tblUser",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<TblCart> tblCarts;

	//bi-directional many-to-one association to TblStatus
	@ManyToOne
	@JoinColumn(name="idStatus")
	private TblStatus tblStatus;

	public TblUser() {
	}

	
	public TblUser(Integer idUser, String addressUser, Date birthDayUser, String imgUser, String nameUser,
			String noteUser, String phoneNumber, List<TblAccount> tblAccounts, List<TblBill> tblBills,
			List<TblCart> tblCarts, TblStatus tblStatus) {
	
		this.idUser = idUser;
		this.addressUser = addressUser;
		this.birthDayUser = birthDayUser;
		this.imgUser = imgUser;
		this.nameUser = nameUser;
		this.noteUser = noteUser;
		this.phoneNumber = phoneNumber;
		this.tblAccounts = tblAccounts;
		this.tblBills = tblBills;
		this.tblCarts = tblCarts;
		this.tblStatus = tblStatus;
	}


	public Integer getIdUser() {
		return this.idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public String getAddressUser() {
		return this.addressUser;
	}

	public void setAddressUser(String addressUser) {
		this.addressUser = addressUser;
	}

	public Date getBirthDayUser() {
		return this.birthDayUser;
	}

	public void setBirthDayUser(Date birthDayUser) {
		this.birthDayUser = birthDayUser;
	}

	public String getImgUser() {
		return this.imgUser;
	}

	public void setImgUser(String imgUser) {
		this.imgUser = imgUser;
	}

	public String getNameUser() {
		return this.nameUser;
	}

	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}

	public String getNoteUser() {
		return this.noteUser;
	}

	public void setNoteUser(String noteUser) {
		this.noteUser = noteUser;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<TblAccount> getTblAccounts() {
		return this.tblAccounts;
	}

	public void setTblAccounts(List<TblAccount> tblAccounts) {
		this.tblAccounts = tblAccounts;
	}

	public TblAccount addTblAccount(TblAccount tblAccount) {
		getTblAccounts().add(tblAccount);
		tblAccount.setTblUser(this);

		return tblAccount;
	}

	public TblAccount removeTblAccount(TblAccount tblAccount) {
		getTblAccounts().remove(tblAccount);
		tblAccount.setTblUser(null);

		return tblAccount;
	}

	public List<TblBill> getTblBills() {
		return this.tblBills;
	}

	public void setTblBills(List<TblBill> tblBills) {
		this.tblBills = tblBills;
	}

	public TblBill addTblBill(TblBill tblBill) {
		getTblBills().add(tblBill);
		tblBill.setTblUser(this);

		return tblBill;
	}

	public TblBill removeTblBill(TblBill tblBill) {
		getTblBills().remove(tblBill);
		tblBill.setTblUser(null);

		return tblBill;
	}

	public List<TblCart> getTblCarts() {
		return this.tblCarts;
	}

	public void setTblCarts(List<TblCart> tblCarts) {
		this.tblCarts = tblCarts;
	}

	public TblCart addTblCart(TblCart tblCart) {
		getTblCarts().add(tblCart);
		tblCart.setTblUser(this);

		return tblCart;
	}

	public TblCart removeTblCart(TblCart tblCart) {
		getTblCarts().remove(tblCart);
		tblCart.setTblUser(null);

		return tblCart;
	}

	public TblStatus getTblStatus() {
		return this.tblStatus;
	}

	public void setTblStatus(TblStatus tblStatus) {
		this.tblStatus = tblStatus;
	}

}