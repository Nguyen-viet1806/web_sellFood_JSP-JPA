package vietnqv.service;

import java.util.ArrayList;
import java.util.List;

import vietnqv.dao.CartDetail_Dao;
import vietnqv.dao.Dao;
import vietnqv.dto.model.CartDetail_DTO;
import vietnqv.mapper.CartDetail_MapperImpl;
import vietnqv.server.model.TblCartDetail;

public class CartDetail_Service implements Service<CartDetail_DTO>{

	Dao<TblCartDetail> dao = new CartDetail_Dao();
	CartDetail_MapperImpl cartdetail_mapper = new CartDetail_MapperImpl();
	
	@Override
	public List<CartDetail_DTO> selectAll() {
		List<TblCartDetail> list = dao.selectAll();
	    List<CartDetail_DTO> lstCartDetail = new ArrayList<CartDetail_DTO>();
	    for (TblCartDetail cd : list) {
			CartDetail_DTO cartDetail = cartdetail_mapper.cartDetail_DTO(cd);
			lstCartDetail.add(cartDetail);
	    }
	    return lstCartDetail;
	}

	@Override
	public int create(CartDetail_DTO t) {
		TblCartDetail cartDetail = cartdetail_mapper.tblCartDetail(t);
		int result = dao.create(cartDetail);
		return result;
	}

	@Override
	public int update(CartDetail_DTO t) {
		TblCartDetail cartDetail = cartdetail_mapper.tblCartDetail(t);
		int result = dao.update(cartDetail);
		return result;
	}

	@Override
	public int delete(CartDetail_DTO t) {
		TblCartDetail cartDetail = cartdetail_mapper.tblCartDetail(t);
		int result = dao.delete(cartDetail);
		return result;
	}

	@Override
	public CartDetail_DTO find(Integer id) {
		CartDetail_DTO cartDetail_DTO = cartdetail_mapper.cartDetail_DTO(dao.find(id));
		return cartDetail_DTO;
	}

	@Override
	public List<CartDetail_DTO> getListPage(Integer page, Integer sum) {
		List<TblCartDetail> list = dao.getListPage(page, sum);
	    List<CartDetail_DTO> lstCartDetail = new ArrayList<CartDetail_DTO>();
	    for (TblCartDetail cd : list) {
			CartDetail_DTO cartDetail = cartdetail_mapper.cartDetail_DTO(cd);
			lstCartDetail.add(cartDetail);
	    }
	    return lstCartDetail;
	}

	@Override
	public List<CartDetail_DTO> search(String keyword) {
		List<TblCartDetail> list = dao.search(keyword);
	    List<CartDetail_DTO> lstCartDetail = new ArrayList<CartDetail_DTO>();
	    for (TblCartDetail cd : list) {
			CartDetail_DTO cartDetail = cartdetail_mapper.cartDetail_DTO(cd);
			lstCartDetail.add(cartDetail);
	    }
	    return lstCartDetail;
	}

}
