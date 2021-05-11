package vietnqv.service;

import java.util.ArrayList;
import java.util.List;

import vietnqv.dao.Dao;
import vietnqv.dao.Status_Dao;
import vietnqv.dto.model.Status_DTO;
import vietnqv.mapper.Status_MapperImpl;
import vietnqv.server.model.TblStatus;

public class Status_Service implements Service<Status_DTO>{

	Dao<TblStatus> dao = new Status_Dao();
	Status_MapperImpl status_mapper = new Status_MapperImpl();
	@Override
	public List<Status_DTO> selectAll() {
		List<TblStatus> list = dao.selectAll();
	    List<Status_DTO> lstStatus = new ArrayList<Status_DTO>();
	    for (TblStatus s : list) {
			Status_DTO status = status_mapper.status_DTO(s);
			lstStatus.add(status);
	    }
	    return lstStatus;
	}

	@Override
	public int create(Status_DTO t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Status_DTO t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Status_DTO t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Status_DTO find(Integer id) {
		Status_DTO status_DTO = status_mapper.status_DTO(dao.find(id));
		return status_DTO;
	}

	@Override
	public List<Status_DTO> getListPage(Integer page, Integer sum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Status_DTO> search(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

}
