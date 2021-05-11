package vietnqv.service;

import java.util.ArrayList;
import java.util.List;

import vietnqv.dao.Account_Dao;
import vietnqv.dao.Dao;
import vietnqv.dto.model.Account_DTO;
import vietnqv.mapper.Account_MapperImpl;
import vietnqv.server.model.TblAccount;

public class Account_Service implements Service<Account_DTO> {

	Dao<TblAccount> dao = new Account_Dao();
	Account_MapperImpl account_mapper = new Account_MapperImpl();
	@Override
	public List<Account_DTO> selectAll() {
		List<TblAccount> list = dao.selectAll();
	    List<Account_DTO> lstAccount = new ArrayList<Account_DTO>();
	    for (TblAccount ac : list) {
			Account_DTO account = account_mapper.account_DTO(ac);
			lstAccount.add(account);
	    }
	    return lstAccount;
	}

	@Override
	public int create(Account_DTO t) {
		TblAccount acount = account_mapper.tblaccount(t);
		int result = dao.create(acount);
		return result;
	}

	@Override
	public int update(Account_DTO t) {
		TblAccount acount = account_mapper.tblaccount(t);
		int result = dao.update(acount);
		return result;
	}

	@Override
	public int delete(Account_DTO t) {
		TblAccount acount = account_mapper.tblaccount(t);
		int result = dao.delete(acount);
		return result;
	}

	@Override
	public Account_DTO find(Integer id) {
		Account_DTO account_DTO = account_mapper.account_DTO(dao.find(id));
		return account_DTO;
	}

	@Override
	public List<Account_DTO> getListPage(Integer page, Integer sum) {
		List<TblAccount> list = dao.getListPage(page, sum);
		List<Account_DTO> lstAccount = new ArrayList<Account_DTO>();
		for(TblAccount ac : list) {
			Account_DTO account =account_mapper.account_DTO(ac);
			lstAccount.add(account);
		}
		return lstAccount;
	}

	@Override
	public List<Account_DTO> search(String keyword) {
		List<TblAccount> list = dao.search(keyword);
		List<Account_DTO> lstAccount = new ArrayList<Account_DTO>();
		for(TblAccount ac : list) {
			Account_DTO account =account_mapper.account_DTO(ac);
			lstAccount.add(account);
		}
		return lstAccount;
	}

}
