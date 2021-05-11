package vietnqv.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import vietnqv.dto.model.CartDetail_DTO;
import vietnqv.dto.model.Cart_DTO;
import vietnqv.dto.model.Status_DTO;
import vietnqv.dto.model.User_DTO;
import vietnqv.server.model.TblCart;
import vietnqv.server.model.TblCartDetail;
import vietnqv.server.model.TblStatus;
import vietnqv.server.model.TblUser;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-04-30T15:32:18+0700",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 3.22.0.v20200530-2032, environment: Java 1.8.0_261 (Oracle Corporation)"
)
public class Cart_MapperImpl implements Cart_Mapper {

    @Override
    public TblCart tblCart(Cart_DTO cart_DTO) {
        if ( cart_DTO == null ) {
            return null;
        }

        TblCart tblCart = new TblCart();

        tblCart.setTblUser( user_DTOToTblUser( cart_DTO.getUser_DTO() ) );
        tblCart.setTblStatus( status_DTOToTblStatus( cart_DTO.getStatus_DTO() ) );
        tblCart.setTblCartDetails( cartDetail_DTOListToTblCartDetailList( cart_DTO.getCartDetails_DTO() ) );
        tblCart.setIdCart( cart_DTO.getIdCart() );
        tblCart.setNoteCart( cart_DTO.getNoteCart() );

        return tblCart;
    }

    @Override
    public Cart_DTO cart_DTO(TblCart tblCart) {
        if ( tblCart == null ) {
            return null;
        }

        Cart_DTO cart_DTO = new Cart_DTO();

        cart_DTO.setCartDetails_DTO( tblCartDetailListToCartDetail_DTOList( tblCart.getTblCartDetails() ) );
        cart_DTO.setUser_DTO( tblUserToUser_DTO( tblCart.getTblUser() ) );
        cart_DTO.setStatus_DTO( tblStatusToStatus_DTO( tblCart.getTblStatus() ) );
        if ( tblCart.getIdCart() != null ) {
            cart_DTO.setIdCart( tblCart.getIdCart() );
        }
        cart_DTO.setNoteCart( tblCart.getNoteCart() );

        return cart_DTO;
    }

    protected TblUser user_DTOToTblUser(User_DTO user_DTO) {
        if ( user_DTO == null ) {
            return null;
        }

        TblUser tblUser = new TblUser();

        tblUser.setIdUser( user_DTO.getIdUser() );
        tblUser.setAddressUser( user_DTO.getAddressUser() );
        tblUser.setBirthDayUser( user_DTO.getBirthDayUser() );
        tblUser.setImgUser( user_DTO.getImgUser() );
        tblUser.setNameUser( user_DTO.getNameUser() );
        tblUser.setNoteUser( user_DTO.getNoteUser() );
        tblUser.setPhoneNumber( user_DTO.getPhoneNumber() );

        return tblUser;
    }

    protected TblStatus status_DTOToTblStatus(Status_DTO status_DTO) {
        if ( status_DTO == null ) {
            return null;
        }

        TblStatus tblStatus = new TblStatus();

        tblStatus.setIdStatus( status_DTO.getIdStatus() );
        tblStatus.setNameStatus( status_DTO.getNameStatus() );

        return tblStatus;
    }

    protected TblCartDetail cartDetail_DTOToTblCartDetail(CartDetail_DTO cartDetail_DTO) {
        if ( cartDetail_DTO == null ) {
            return null;
        }

        TblCartDetail tblCartDetail = new TblCartDetail();

        tblCartDetail.setIdCartDetail( cartDetail_DTO.getIdCartDetail() );
        tblCartDetail.setQuantityProduct( cartDetail_DTO.getQuantityProduct() );

        return tblCartDetail;
    }

    protected List<TblCartDetail> cartDetail_DTOListToTblCartDetailList(List<CartDetail_DTO> list) {
        if ( list == null ) {
            return null;
        }

        List<TblCartDetail> list1 = new ArrayList<TblCartDetail>( list.size() );
        for ( CartDetail_DTO cartDetail_DTO : list ) {
            list1.add( cartDetail_DTOToTblCartDetail( cartDetail_DTO ) );
        }

        return list1;
    }

    protected CartDetail_DTO tblCartDetailToCartDetail_DTO(TblCartDetail tblCartDetail) {
        if ( tblCartDetail == null ) {
            return null;
        }

        CartDetail_DTO cartDetail_DTO = new CartDetail_DTO();

        if ( tblCartDetail.getIdCartDetail() != null ) {
            cartDetail_DTO.setIdCartDetail( tblCartDetail.getIdCartDetail() );
        }
        if ( tblCartDetail.getQuantityProduct() != null ) {
            cartDetail_DTO.setQuantityProduct( tblCartDetail.getQuantityProduct() );
        }

        return cartDetail_DTO;
    }

    protected List<CartDetail_DTO> tblCartDetailListToCartDetail_DTOList(List<TblCartDetail> list) {
        if ( list == null ) {
            return null;
        }

        List<CartDetail_DTO> list1 = new ArrayList<CartDetail_DTO>( list.size() );
        for ( TblCartDetail tblCartDetail : list ) {
            list1.add( tblCartDetailToCartDetail_DTO( tblCartDetail ) );
        }

        return list1;
    }

    protected User_DTO tblUserToUser_DTO(TblUser tblUser) {
        if ( tblUser == null ) {
            return null;
        }

        User_DTO user_DTO = new User_DTO();

        if ( tblUser.getIdUser() != null ) {
            user_DTO.setIdUser( tblUser.getIdUser() );
        }
        user_DTO.setAddressUser( tblUser.getAddressUser() );
        user_DTO.setBirthDayUser( tblUser.getBirthDayUser() );
        user_DTO.setImgUser( tblUser.getImgUser() );
        user_DTO.setNameUser( tblUser.getNameUser() );
        user_DTO.setNoteUser( tblUser.getNoteUser() );
        user_DTO.setPhoneNumber( tblUser.getPhoneNumber() );

        return user_DTO;
    }

    protected Status_DTO tblStatusToStatus_DTO(TblStatus tblStatus) {
        if ( tblStatus == null ) {
            return null;
        }

        Status_DTO status_DTO = new Status_DTO();

        if ( tblStatus.getIdStatus() != null ) {
            status_DTO.setIdStatus( tblStatus.getIdStatus() );
        }
        status_DTO.setNameStatus( tblStatus.getNameStatus() );

        return status_DTO;
    }
}
