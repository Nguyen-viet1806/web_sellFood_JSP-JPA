package vietnqv.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import vietnqv.dto.model.Account_DTO;
import vietnqv.server.model.TblAccount;

@Mapper
public interface Account_Mapper {

	@Mapping(target = "tblRole" ,source = "account_DTO.role_DTO")
	@Mapping(target = "tblStatus" ,source = "account_DTO.status_DTO")
	@Mapping(target = "tblUser" ,source = "account_DTO.user_DTO")
	TblAccount tblaccount(Account_DTO account_DTO );
	
	@Mapping(target = "role_DTO" ,source = "tblaccount.tblRole")
	@Mapping(target = "status_DTO" ,source = "tblaccount.tblStatus")
	@Mapping(target = "user_DTO" ,source = "tblaccount.tblUser")
	Account_DTO account_DTO(TblAccount tblaccount);
}
