package vietnqv.server.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tblRole database table.
 * 
 */
@Entity
@Table(name="tblRole")
@NamedQuery(name="TblRole.findAll", query="SELECT t FROM TblRole t")
public class TblRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idRole;

	private String nameRole;

	//bi-directional many-to-one association to TblAccount
	@OneToMany(mappedBy="tblRole",fetch = FetchType.EAGER)
	private List<TblAccount> tblAccounts;

	//bi-directional many-to-one association to TblStatus
	@ManyToOne
	@JoinColumn(name="idStatus")
	private TblStatus tblStatus;

	public TblRole() {
	}

	
	public TblRole(Integer idRole, String nameRole, List<TblAccount> tblAccounts, TblStatus tblStatus) {
	
		this.idRole = idRole;
		this.nameRole = nameRole;
		this.tblAccounts = tblAccounts;
		this.tblStatus = tblStatus;
	}


	public Integer getIdRole() {
		return this.idRole;
	}

	public void setIdRole(Integer idRole) {
		this.idRole = idRole;
	}

	public String getNameRole() {
		return this.nameRole;
	}

	public void setNameRole(String nameRole) {
		this.nameRole = nameRole;
	}

	public List<TblAccount> getTblAccounts() {
		return this.tblAccounts;
	}

	public void setTblAccounts(List<TblAccount> tblAccounts) {
		this.tblAccounts = tblAccounts;
	}

	public TblAccount addTblAccount(TblAccount tblAccount) {
		getTblAccounts().add(tblAccount);
		tblAccount.setTblRole(this);

		return tblAccount;
	}

	public TblAccount removeTblAccount(TblAccount tblAccount) {
		getTblAccounts().remove(tblAccount);
		tblAccount.setTblRole(null);

		return tblAccount;
	}

	public TblStatus getTblStatus() {
		return this.tblStatus;
	}

	public void setTblStatus(TblStatus tblStatus) {
		this.tblStatus = tblStatus;
	}

}