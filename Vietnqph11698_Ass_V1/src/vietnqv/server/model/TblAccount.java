package vietnqv.server.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tblAccount database table.
 * 
 */
@Entity
@Table(name="tblAccount")
@NamedQueries({
	@NamedQuery(name="TblAccount.findAll", query="SELECT t FROM TblAccount t"),
	@NamedQuery(name="TblAccount.search", query="SELECT t FROM TblAccount t WHERE  t.email = :keyword")
})

public class TblAccount implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idAccount;

	private String email;

	private String password;

	//bi-directional many-to-one association to TblRole
	@ManyToOne
	@JoinColumn(name="idRole")
	private TblRole tblRole;

	//bi-directional many-to-one association to TblStatus
	@ManyToOne
	@JoinColumn(name="idStatus")
	private TblStatus tblStatus;

	//bi-directional many-to-one association to TblUser
	@ManyToOne
	@JoinColumn(name="idUser")
	private TblUser tblUser;

	public TblAccount() {
	}
    
	public TblAccount(Integer idAccount, String email, String password, TblRole tblRole, TblStatus tblStatus,
			TblUser tblUser) {
		this.idAccount = idAccount;
		this.email = email;
		this.password = password;
		this.tblRole = tblRole;
		this.tblStatus = tblStatus;
		this.tblUser = tblUser;
	}

	public Integer getIdAccount() {
		return this.idAccount;
	}

	public void setIdAccount(Integer idAccount) {
		this.idAccount = idAccount;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public TblRole getTblRole() {
		return this.tblRole;
	}

	public void setTblRole(TblRole tblRole) {
		this.tblRole = tblRole;
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

}