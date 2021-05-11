package vietnqv.server.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tblStatus database table.
 * 
 */
@Entity
@Table(name="tblStatus")
@NamedQuery(name="TblStatus.findAll", query="SELECT t FROM TblStatus t")
public class TblStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idStatus;

	private String nameStatus;

	//bi-directional many-to-one association to TblAccount
	@OneToMany(mappedBy="tblStatus",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<TblAccount> tblAccounts;

	//bi-directional many-to-one association to TblBill
	@OneToMany(mappedBy="tblStatus",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<TblBill> tblBills;

	//bi-directional many-to-one association to TblCart
	@OneToMany(mappedBy="tblStatus",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<TblCart> tblCarts;

	//bi-directional many-to-one association to TblCategory
	@OneToMany(mappedBy="tblStatus",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<TblCategory> tblCategories;

	//bi-directional many-to-one association to TblProduct
	@OneToMany(mappedBy="tblStatus",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<TblProduct> tblProducts;

	//bi-directional many-to-one association to TblRole
	@OneToMany(mappedBy="tblStatus",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<TblRole> tblRoles;

	//bi-directional many-to-one association to TblUser
	@OneToMany(mappedBy="tblStatus",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<TblUser> tblUsers;

	public TblStatus() {
	}

	public TblStatus(Integer idStatus, String nameStatus, List<TblAccount> tblAccounts, List<TblBill> tblBills,
			List<TblCart> tblCarts, List<TblCategory> tblCategories, List<TblProduct> tblProducts,
			List<TblRole> tblRoles, List<TblUser> tblUsers) {
		
		this.idStatus = idStatus;
		this.nameStatus = nameStatus;
		this.tblAccounts = tblAccounts;
		this.tblBills = tblBills;
		this.tblCarts = tblCarts;
		this.tblCategories = tblCategories;
		this.tblProducts = tblProducts;
		this.tblRoles = tblRoles;
		this.tblUsers = tblUsers;
	}

	public Integer getIdStatus() {
		return this.idStatus;
	}

	public void setIdStatus(Integer idStatus) {
		this.idStatus = idStatus;
	}

	public String getNameStatus() {
		return this.nameStatus;
	}

	public void setNameStatus(String nameStatus) {
		this.nameStatus = nameStatus;
	}

	public List<TblAccount> getTblAccounts() {
		return this.tblAccounts;
	}

	public void setTblAccounts(List<TblAccount> tblAccounts) {
		this.tblAccounts = tblAccounts;
	}

	public TblAccount addTblAccount(TblAccount tblAccount) {
		getTblAccounts().add(tblAccount);
		tblAccount.setTblStatus(this);

		return tblAccount;
	}

	public TblAccount removeTblAccount(TblAccount tblAccount) {
		getTblAccounts().remove(tblAccount);
		tblAccount.setTblStatus(null);

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
		tblBill.setTblStatus(this);

		return tblBill;
	}

	public TblBill removeTblBill(TblBill tblBill) {
		getTblBills().remove(tblBill);
		tblBill.setTblStatus(null);

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
		tblCart.setTblStatus(this);

		return tblCart;
	}

	public TblCart removeTblCart(TblCart tblCart) {
		getTblCarts().remove(tblCart);
		tblCart.setTblStatus(null);

		return tblCart;
	}

	public List<TblCategory> getTblCategories() {
		return this.tblCategories;
	}

	public void setTblCategories(List<TblCategory> tblCategories) {
		this.tblCategories = tblCategories;
	}

	public TblCategory addTblCategory(TblCategory tblCategory) {
		getTblCategories().add(tblCategory);
		tblCategory.setTblStatus(this);

		return tblCategory;
	}

	public TblCategory removeTblCategory(TblCategory tblCategory) {
		getTblCategories().remove(tblCategory);
		tblCategory.setTblStatus(null);

		return tblCategory;
	}

	public List<TblProduct> getTblProducts() {
		return this.tblProducts;
	}

	public void setTblProducts(List<TblProduct> tblProducts) {
		this.tblProducts = tblProducts;
	}

	public TblProduct addTblProduct(TblProduct tblProduct) {
		getTblProducts().add(tblProduct);
		tblProduct.setTblStatus(this);

		return tblProduct;
	}

	public TblProduct removeTblProduct(TblProduct tblProduct) {
		getTblProducts().remove(tblProduct);
		tblProduct.setTblStatus(null);

		return tblProduct;
	}

	public List<TblRole> getTblRoles() {
		return this.tblRoles;
	}

	public void setTblRoles(List<TblRole> tblRoles) {
		this.tblRoles = tblRoles;
	}

	public TblRole addTblRole(TblRole tblRole) {
		getTblRoles().add(tblRole);
		tblRole.setTblStatus(this);

		return tblRole;
	}

	public TblRole removeTblRole(TblRole tblRole) {
		getTblRoles().remove(tblRole);
		tblRole.setTblStatus(null);

		return tblRole;
	}

	public List<TblUser> getTblUsers() {
		return this.tblUsers;
	}

	public void setTblUsers(List<TblUser> tblUsers) {
		this.tblUsers = tblUsers;
	}

	public TblUser addTblUser(TblUser tblUser) {
		getTblUsers().add(tblUser);
		tblUser.setTblStatus(this);

		return tblUser;
	}

	public TblUser removeTblUser(TblUser tblUser) {
		getTblUsers().remove(tblUser);
		tblUser.setTblStatus(null);

		return tblUser;
	}

}