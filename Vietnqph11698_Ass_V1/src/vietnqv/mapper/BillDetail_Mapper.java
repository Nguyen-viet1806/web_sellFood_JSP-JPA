package vietnqv.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import vietnqv.dto.model.BillDetail_DTO;
import vietnqv.server.model.TblBillDetail;

@Mapper
public interface BillDetail_Mapper {

	@Mapping(target = "tblBill" , source = "billDetail_DTO.bill_DTO")
	@Mapping(target = "tblProduct" , source = "billDetail_DTO.product_DTO")
	TblBillDetail tblBillDetail(BillDetail_DTO billDetail_DTO);
	
	@Mapping(target = "bill_DTO" , source = "tblBillDetail.tblBill")
	@Mapping(target = "product_DTO" , source = "tblBillDetail.tblProduct")
	BillDetail_DTO billDetail_DTO(TblBillDetail tblBillDetail);
}
