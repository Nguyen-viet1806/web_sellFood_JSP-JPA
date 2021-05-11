package vietnqv.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


import vietnqv.dto.model.Bill_DTO;
import vietnqv.server.model.TblBill;

@Mapper
public interface Bill_Mapper {
	
	@Mapping(target = "tblStatus" ,source = "bill_DTO.status_DTO")
	@Mapping(target = "tblUser" ,source = "bill_DTO.user_DTO")
	@Mapping(target = "tblBillDetails" ,source = "bill_DTO.billDetails_DTO")
	TblBill tblbill(Bill_DTO bill_DTO);
	
	@Mapping(target = "status_DTO" ,source = "tblbill.tblStatus")
	@Mapping(target = "user_DTO" ,source = "tblbill.tblUser")
	@Mapping(target = "billDetails_DTO" ,source = "tblbill.tblBillDetails")
	Bill_DTO bill_DTO (TblBill tblbill);
}
