package vietnqv.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import vietnqv.dto.model.User_DTO;
import vietnqv.server.model.TblUser;

@Mapper
public interface User_Mapper {
	@Mapping(target = "tblAccounts" , source = "user_DTO.accounts_DTO")
	@Mapping(target = "tblBills" , source = "user_DTO.bills_DTO")
	@Mapping(target = "tblCarts" , source = "user_DTO.carts_DTO")
	@Mapping(target = "tblStatus" , source = "user_DTO.status_DTO")
	TblUser tblUser (User_DTO user_DTO);
	

	@Mapping(target = "accounts_DTO" , source = "tblUser.tblAccounts")
	@Mapping(target = "bills_DTO" , source = "tblUser.tblBills")
	@Mapping(target = "carts_DTO" , source = "tblUser.tblCarts")
	@Mapping(target = "status_DTO" , source = "tblUser.tblStatus")
	User_DTO user_DTO (TblUser tblUser);
}
