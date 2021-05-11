package vietnqv.service;

import java.util.ArrayList;
import java.util.List;

import vietnqv.dao.Dao;
import vietnqv.dao.Product_Dao;
import vietnqv.dto.model.Product_DTO;
import vietnqv.mapper.Product_MapperImpl;
import vietnqv.server.model.TblProduct;

public class Product_Service implements Service<Product_DTO>{

	
	Dao<TblProduct> dao = new Product_Dao();
	Product_MapperImpl product_mapper = new Product_MapperImpl();
	@Override
	public List<Product_DTO> selectAll() {
		List<TblProduct> list = dao.selectAll();
	    List<Product_DTO> lstProduct = new ArrayList<Product_DTO>();
	    for (TblProduct p : list) {
			Product_DTO product = product_mapper.product_DTO(p);
			lstProduct.add(product);
	    }
	    return lstProduct;
	}

	@Override
	public int create(Product_DTO t) {
		TblProduct product = product_mapper.tblProduct(t);
		int result = dao.create(product);
		return result;
	}

	@Override
	public int update(Product_DTO t) {
		TblProduct product = product_mapper.tblProduct(t);
		int result = dao.update(product);
		return result;
	}

	@Override
	public int delete(Product_DTO t) {
		TblProduct product = product_mapper.tblProduct(t);
		int result = dao.delete(product);
		return result;
	}

	@Override
	public Product_DTO find(Integer id) {
		Product_DTO product_DTO = product_mapper.product_DTO(dao.find(id));
		return product_DTO;
	}

	@Override
	public List<Product_DTO> getListPage(Integer page, Integer sum) {
		List<TblProduct> list = dao.getListPage(page, sum);
	    List<Product_DTO> lstProduct = new ArrayList<Product_DTO>();
	    for (TblProduct p : list) {
			Product_DTO product = product_mapper.product_DTO(p);
			lstProduct.add(product);
	    }
	    return lstProduct;
	}

	@Override
	public List<Product_DTO> search(String keyword) {
		List<TblProduct> list = dao.search(keyword);
	    List<Product_DTO> lstProduct = new ArrayList<Product_DTO>();
	    for (TblProduct p : list) {
			Product_DTO product = product_mapper.product_DTO(p);
			lstProduct.add(product);
	    }
	    return lstProduct;
	}

}
