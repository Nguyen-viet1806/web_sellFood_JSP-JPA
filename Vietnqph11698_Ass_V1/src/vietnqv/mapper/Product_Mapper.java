package vietnqv.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import vietnqv.dto.model.Product_DTO;
import vietnqv.server.model.TblProduct;


@Mapper
public interface Product_Mapper {

	@Mapping(target = "tblBillDetails" , source = "product_DTO.billDetails_DTO")
	@Mapping(target = "tblCartDetails" , source = "product_DTO.cartDetails_DTO")
	@Mapping(target = "tblCategory" , source = "product_DTO.category_DTO")
	@Mapping(target = "tblStatus" , source = "product_DTO.status_DTO")
	TblProduct tblProduct(Product_DTO product_DTO);
	
	@Mapping(target = "billDetails_DTO" , source = "tblProduct.tblBillDetails")
	@Mapping(target = "cartDetails_DTO" , source = "tblProduct.tblCartDetails")
	@Mapping(target = "category_DTO" , source = "tblProduct.tblCategory")
	@Mapping(target = "status_DTO" , source = "tblProduct.tblStatus")
	Product_DTO product_DTO(TblProduct tblProduct);
}
