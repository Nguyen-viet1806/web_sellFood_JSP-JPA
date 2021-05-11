package vietnqv.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import vietnqv.dto.model.CartDetail_DTO;
import vietnqv.server.model.TblCartDetail;



@Mapper
public interface CartDetail_Mapper {

	
	@Mapping(target = "tblCart" , source = "cartDetail_DTO.cart_DTO")
	@Mapping(target = "tblProduct" , source = "cartDetail_DTO.product_DTO")
	TblCartDetail tblCartDetail(CartDetail_DTO cartDetail_DTO);
	
	@Mapping(target = "cart_DTO" , source = "tblCartDetail.tblCart")
	@Mapping(target = "product_DTO" , source = "tblCartDetail.tblProduct")
	CartDetail_DTO cartDetail_DTO(TblCartDetail tblCartDetail);
}
