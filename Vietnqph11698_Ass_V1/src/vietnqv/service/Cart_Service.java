package vietnqv.service;

import java.util.ArrayList;
import java.util.List;

import vietnqv.dao.Cart_Dao;
import vietnqv.dao.Dao;
import vietnqv.dto.model.Cart_DTO;
import vietnqv.mapper.Cart_MapperImpl;
import vietnqv.server.model.TblCart;

public class Cart_Service implements Service<Cart_DTO>{

	Dao<TblCart> dao = new Cart_Dao();
	Cart_MapperImpl cart_mapper = new Cart_MapperImpl();
	
	@Override
	public List<Cart_DTO> selectAll() {
		List<TblCart> list = dao.selectAll();
	    List<Cart_DTO> lstCart = new ArrayList<Cart_DTO>();
	    for (TblCart ct : list) {
			Cart_DTO cart = cart_mapper.cart_DTO(ct);
			lstCart.add(cart);
	    }
	    return lstCart;
	}

	@Override
	public int create(Cart_DTO t) {
		TblCart cart = cart_mapper.tblCart(t);
		int result = dao.create(cart);
		return result;
	}

	@Override
	public int update(Cart_DTO t) {
		TblCart cart = cart_mapper.tblCart(t);
		int result = dao.update(cart);
		return result;
	}

	@Override
	public int delete(Cart_DTO t) {
		TblCart cart = cart_mapper.tblCart(t);
		int result = dao.delete(cart);
		return result;
	}

	@Override
	public Cart_DTO find(Integer id) {
		Cart_DTO cart_DTO = cart_mapper.cart_DTO(dao.find(id));
		return cart_DTO;
	}

	@Override
	public List<Cart_DTO> getListPage(Integer page, Integer sum) {
		List<TblCart> list = dao.getListPage(page, sum);
	    List<Cart_DTO> lstCart = new ArrayList<Cart_DTO>();
	    for (TblCart ct : list) {
			Cart_DTO cart = cart_mapper.cart_DTO(ct);
			lstCart.add(cart);
	    }
	    return lstCart;
	}

	@Override
	public List<Cart_DTO> search(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

}
