package vietnqv.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import vietnqv.dto.model.Status_DTO;
import vietnqv.server.model.TblStatus;



@Mapper
public interface Status_Mapper {
	
	@Mapping(target = "tblAccounts" , source = "status_DTO.accounts_DTO")
	@Mapping(target = "tblBills" , source = "status_DTO.bills_DTO")
	@Mapping(target = "tblCarts" , source = "status_DTO.carts_DTO")
	@Mapping(target = "tblCategories" , source = "status_DTO.categories_DTO")
	@Mapping(target = "tblProducts" , source = "status_DTO.products_DTO")
	@Mapping(target = "tblRoles" , source = "status_DTO.roles_DTO")
	@Mapping(target = "tblUsers" , source = "status_DTO.users_DTO")
	TblStatus tblStatus (Status_DTO status_DTO);
	

	@Mapping(target = "accounts_DTO" , source = "tblStatus.tblAccounts")
	@Mapping(target = "bills_DTO" , source = "tblStatus.tblBills")
	@Mapping(target = "carts_DTO" , source = "tblStatus.tblCarts")
	@Mapping(target = "categories_DTO" , source = "tblStatus.tblCategories")
	@Mapping(target = "products_DTO" , source = "tblStatus.tblProducts")
	@Mapping(target = "roles_DTO" , source = "tblStatus.tblRoles")
	@Mapping(target = "users_DTO" , source = "tblStatus.tblUsers")
	Status_DTO status_DTO (TblStatus tblStatus);
}
