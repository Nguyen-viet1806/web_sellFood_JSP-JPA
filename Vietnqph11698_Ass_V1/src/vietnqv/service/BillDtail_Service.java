package vietnqv.service;

import java.util.ArrayList;
import java.util.List;

import vietnqv.dao.BillDetail_Dao;
import vietnqv.dao.Dao;
import vietnqv.dto.model.BillDetail_DTO;
import vietnqv.mapper.BillDetail_MapperImpl;
import vietnqv.server.model.TblBillDetail;

public class BillDtail_Service implements Service<BillDetail_DTO>{

	Dao<TblBillDetail> dao = new BillDetail_Dao();
	BillDetail_MapperImpl billDetail_mapper = new BillDetail_MapperImpl();
	@Override
	public List<BillDetail_DTO> selectAll() {
		List<TblBillDetail> list = dao.selectAll();
	    List<BillDetail_DTO> lstBillDetail = new ArrayList<BillDetail_DTO>();
	    for (TblBillDetail bd : list) {
			BillDetail_DTO billDetail = billDetail_mapper.billDetail_DTO(bd);
			lstBillDetail.add(billDetail);
	    }
	    return lstBillDetail;
	}

	@Override
	public int create(BillDetail_DTO t) {
		TblBillDetail billDetail = billDetail_mapper.tblBillDetail(t);
		int result = dao.create(billDetail);
		return result;
	}

	@Override
	public int update(BillDetail_DTO t) {
		TblBillDetail billDetail = billDetail_mapper.tblBillDetail(t);
		int result = dao.update(billDetail);
		return result;
	}

	@Override
	public int delete(BillDetail_DTO t) {
		TblBillDetail billDetail = billDetail_mapper.tblBillDetail(t);
		int result = dao.delete(billDetail);
		return result;
	}

	@Override
	public BillDetail_DTO find(Integer id) {
		BillDetail_DTO billDetail_DTO = billDetail_mapper.billDetail_DTO(dao.find(id));
		return billDetail_DTO;
	}

	@Override
	public List<BillDetail_DTO> getListPage(Integer page, Integer sum) {
		List<TblBillDetail> list = dao.getListPage(page, sum);
		List<BillDetail_DTO> lstBillDetail = new ArrayList<BillDetail_DTO>();
		for(TblBillDetail bd : list) {
			BillDetail_DTO billDetail =billDetail_mapper.billDetail_DTO(bd);
			lstBillDetail.add(billDetail);
		}
		return lstBillDetail;
	}

	@Override
	public List<BillDetail_DTO> search(String keyword) {
		List<TblBillDetail> list = dao.search(keyword);
	    List<BillDetail_DTO> lstBillDetail = new ArrayList<BillDetail_DTO>();
	    for (TblBillDetail bd : list) {
			BillDetail_DTO billDetail = billDetail_mapper.billDetail_DTO(bd);
			lstBillDetail.add(billDetail);
	    }
	    return lstBillDetail;
	} 

}
