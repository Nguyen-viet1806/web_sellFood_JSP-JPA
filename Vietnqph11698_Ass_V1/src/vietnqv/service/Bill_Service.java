package vietnqv.service;

import java.util.ArrayList;
import java.util.List;

import vietnqv.dao.Bill_Dao;
import vietnqv.dao.Dao;
import vietnqv.dto.model.Bill_DTO;
import vietnqv.mapper.Bill_MapperImpl;
import vietnqv.server.model.TblBill;

public class Bill_Service implements Service<Bill_DTO>{

	Dao<TblBill> dao = new Bill_Dao();
	Bill_MapperImpl bill_mapper = new Bill_MapperImpl();
	@Override
	public List<Bill_DTO> selectAll() {
		List<TblBill> list = dao.selectAll();
	    List<Bill_DTO> lstBill = new ArrayList<Bill_DTO>();
	    for (TblBill bl : list) {
			Bill_DTO bill = bill_mapper.bill_DTO(bl);
			lstBill.add(bill);
	    }
	    return lstBill;
	}

	@Override
	public int create(Bill_DTO t) {
		TblBill bill = bill_mapper.tblbill(t);
		int result = dao.create(bill);
		return result;
	}

	@Override
	public int update(Bill_DTO t) {
		TblBill bill = bill_mapper.tblbill(t);
		int result = dao.update(bill);
		return result;
	}

	@Override
	public int delete(Bill_DTO t) {
		TblBill bill = bill_mapper.tblbill(t);
		int result = dao.delete(bill);
		return result;
	}

	@Override
	public Bill_DTO find(Integer id) {
		Bill_DTO Bill_DTO = bill_mapper.bill_DTO(dao.find(id));
		return Bill_DTO;
	}

	@Override
	public List<Bill_DTO> getListPage(Integer page, Integer sum) {
		List<TblBill> list = dao.getListPage(page, sum);
		List<Bill_DTO> lstBill = new ArrayList<Bill_DTO>();
		for(TblBill bl : list) {
			Bill_DTO bill =bill_mapper.bill_DTO(bl);
			lstBill.add(bill);
		}
		return lstBill;
	}

	@Override
	public List<Bill_DTO> search(String keyword) {
		List<TblBill> list = dao.search(keyword);
	    List<Bill_DTO> lstBill = new ArrayList<Bill_DTO>();
	    for (TblBill bl : list) {
			Bill_DTO bill = bill_mapper.bill_DTO(bl);
			lstBill.add(bill);
	    }
	    return lstBill;
	}
}
