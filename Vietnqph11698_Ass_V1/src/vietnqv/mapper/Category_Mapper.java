package vietnqv.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import vietnqv.dto.model.Category_DTO;
import vietnqv.server.model.TblCategory;


@Mapper
public interface Category_Mapper {

	@Mapping(target = "tblStatus" , source = "category_DTO.status_DTO")
	@Mapping(target = "tblProducts" , source = "category_DTO.products_DTO")
	TblCategory tblCategory(Category_DTO category_DTO);
	
	@Mapping(target = "status_DTO" , source = "tblCategory.tblStatus")
	@Mapping(target = "products_DTO" , source = "tblCategory.tblProducts")
	Category_DTO category_DTO(TblCategory tblCategory);
}
