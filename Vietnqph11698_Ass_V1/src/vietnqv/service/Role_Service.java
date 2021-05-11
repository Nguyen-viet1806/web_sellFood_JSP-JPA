package vietnqv.service;

import java.util.ArrayList;
import java.util.List;

import vietnqv.dao.Dao;
import vietnqv.dao.Role_Dao;
import vietnqv.dto.model.Role_DTO;
import vietnqv.mapper.Role_MapperImpl;
import vietnqv.server.model.TblRole;

public class Role_Service implements Service<Role_DTO>{

	Dao<TblRole> dao = new Role_Dao();
	Role_MapperImpl role_mapper = new Role_MapperImpl();
	@Override
	public List<Role_DTO> selectAll() {
		List<TblRole> list = dao.selectAll();
	    List<Role_DTO> lstRole = new ArrayList<Role_DTO>();
	    for (TblRole r : list) {
			Role_DTO role = role_mapper.role_DTO(r);
			lstRole.add(role);
	    }
	    return lstRole;
	}

	@Override
	public int create(Role_DTO t) {
		TblRole role = role_mapper.tblRole(t);
		int result = dao.create(role);
		return result;
	}

	@Override
	public int update(Role_DTO t) {
		TblRole role = role_mapper.tblRole(t);
		int result = dao.update(role);
		return result;
	}

	@Override
	public int delete(Role_DTO t) {
		TblRole role = role_mapper.tblRole(t);
		int result = dao.delete(role);
		return result;
	}

	@Override
	public Role_DTO find(Integer id) {
		Role_DTO role_DTO = role_mapper.role_DTO(dao.find(id));
		return role_DTO;
	}

	@Override
	public List<Role_DTO> getListPage(Integer page, Integer sum) {
		List<TblRole> list = dao.getListPage(page, sum);
	    List<Role_DTO> lstRole = new ArrayList<Role_DTO>();
	    for (TblRole r : list) {
			Role_DTO role = role_mapper.role_DTO(r);
			lstRole.add(role);
	    }
	    return lstRole;
	}

	@Override
	public List<Role_DTO> search(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

}
