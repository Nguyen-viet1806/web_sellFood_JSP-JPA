package vietnqv.service;

import java.util.ArrayList;
import java.util.List;

import vietnqv.dao.Category_Dao;
import vietnqv.dao.Dao;
import vietnqv.dto.model.Category_DTO;
import vietnqv.mapper.Category_MapperImpl;
import vietnqv.server.model.TblCategory;

public class Category_Service implements Service<Category_DTO>{

	
	Dao<TblCategory> dao = new Category_Dao();
	Category_MapperImpl category_mapper = new Category_MapperImpl();
	@Override
	public List<Category_DTO> selectAll() {
		List<TblCategory> list = dao.selectAll();
	    List<Category_DTO> lstCategory = new ArrayList<Category_DTO>();
	    for (TblCategory c : list) {
			Category_DTO category = category_mapper.category_DTO(c);
			lstCategory.add(category);
	    }
	    return lstCategory;
	}

	@Override
	public int create(Category_DTO t) {
		TblCategory category = category_mapper.tblCategory(t);
		int result = dao.create(category);
		return result;
	}

	@Override
	public int update(Category_DTO t) {
		TblCategory category = category_mapper.tblCategory(t);
		int result = dao.update(category);
		return result;
	}

	@Override
	public int delete(Category_DTO t) {
		TblCategory category = category_mapper.tblCategory(t);
		int result = dao.delete(category);
		return result;
	}
	@Override
	public Category_DTO find(Integer id) {
		Category_DTO category_DTO = category_mapper.category_DTO(dao.find(id));
		return category_DTO;
	}

	@Override
	public List<Category_DTO> getListPage(Integer page, Integer sum) {
		List<TblCategory> list = dao.getListPage(page, sum);
	    List<Category_DTO> lstCategory = new ArrayList<Category_DTO>();
	    for (TblCategory c : list) {
			Category_DTO category = category_mapper.category_DTO(c);
			lstCategory.add(category);
	    }
	    return lstCategory;
	}

	@Override
	public List<Category_DTO> search(String keyword) {
		List<TblCategory> list = dao.search(keyword);
	    List<Category_DTO> lstCategory = new ArrayList<Category_DTO>();
	    for (TblCategory c : list) {
			Category_DTO category = category_mapper.category_DTO(c);
			lstCategory.add(category);
	    }
		return  lstCategory;
	}

}
