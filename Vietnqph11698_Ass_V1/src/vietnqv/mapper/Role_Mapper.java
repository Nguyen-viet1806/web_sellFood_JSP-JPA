package vietnqv.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import vietnqv.dto.model.Role_DTO;
import vietnqv.server.model.TblRole;



@Mapper
public interface Role_Mapper {
	
	@Mapping(target = "tblAccounts" , source = "role_DTO.accounts_DTO")
	@Mapping(target = "tblStatus" , source = "role_DTO.status_DTO")
	TblRole tblRole(Role_DTO role_DTO);
	
	@Mapping(target = "accounts_DTO" , source = "tblRole.tblAccounts")
	@Mapping(target = "status_DTO" , source = "tblRole.tblStatus")
	Role_DTO role_DTO(TblRole tblRole);
}
