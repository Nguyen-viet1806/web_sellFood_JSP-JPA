package vietnqv.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import vietnqv.dto.model.Cart_DTO;
import vietnqv.server.model.TblCart;



@Mapper
public interface Cart_Mapper {

	@Mapping(target = "tblStatus" , source = "cart_DTO.status_DTO")
	@Mapping(target = "tblUser" , source = "cart_DTO.user_DTO")
	@Mapping(target = "tblCartDetails" , source = "cart_DTO.cartDetails_DTO")
	TblCart tblCart(Cart_DTO cart_DTO);
	
	@Mapping(target = "status_DTO" , source = "tblCart.tblStatus")
	@Mapping(target = "user_DTO" , source = "tblCart.tblUser")
	@Mapping(target = "cartDetails_DTO" , source = "tblCart.tblCartDetails")
	Cart_DTO cart_DTO(TblCart tblCart);
}
