package vietnqv.service;

import java.util.ArrayList;
import java.util.List;

import vietnqv.dao.Dao;
import vietnqv.dao.User_Dao;
import vietnqv.dto.model.User_DTO;
import vietnqv.mapper.User_MapperImpl;
import vietnqv.server.model.TblUser;

public class User_Service implements Service<User_DTO>{

	Dao<TblUser> dao = new User_Dao();
	User_MapperImpl user_mapper = new User_MapperImpl();
	@Override
	public List<User_DTO> selectAll() {
		List<TblUser> list = dao.selectAll();
	    List<User_DTO> lstUser = new ArrayList<User_DTO>();
	    for (TblUser u : list) {
			User_DTO user = user_mapper.user_DTO(u);
			lstUser.add(user);
	    }
	    return lstUser;
	}

	@Override
	public int create(User_DTO t) {
		TblUser user = user_mapper.tblUser(t);
		int result = dao.create(user);
		return result;
	}

	@Override
	public int update(User_DTO t) {
		TblUser user = user_mapper.tblUser(t);
		int result = dao.update(user);
		return result;
	}

	@Override
	public int delete(User_DTO t) {
		TblUser user = user_mapper.tblUser(t);
		int result = dao.delete(user);
		return result;
	}

	@Override
	public User_DTO find(Integer id) {
		User_DTO user_DTO = user_mapper.user_DTO(dao.find(id));
		return user_DTO;
	}

	@Override
	public List<User_DTO> getListPage(Integer page, Integer sum) {
		List<TblUser> list = dao.getListPage(page, sum);
	    List<User_DTO> lstUser = new ArrayList<User_DTO>();
	    for (TblUser u : list) {
			User_DTO user = user_mapper.user_DTO(u);
			lstUser.add(user);
	    }
	    return lstUser;
	}

	@Override
	public List<User_DTO> search(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

}
