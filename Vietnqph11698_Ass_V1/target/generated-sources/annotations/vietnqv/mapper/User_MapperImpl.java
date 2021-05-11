package vietnqv.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import vietnqv.dto.model.Account_DTO;
import vietnqv.dto.model.Bill_DTO;
import vietnqv.dto.model.Cart_DTO;
import vietnqv.dto.model.Status_DTO;
import vietnqv.dto.model.User_DTO;
import vietnqv.server.model.TblAccount;
import vietnqv.server.model.TblBill;
import vietnqv.server.model.TblCart;
import vietnqv.server.model.TblStatus;
import vietnqv.server.model.TblUser;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-04-30T15:32:16+0700",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 3.22.0.v20200530-2032, environment: Java 1.8.0_261 (Oracle Corporation)"
)
public class User_MapperImpl implements User_Mapper {

    @Override
    public TblUser tblUser(User_DTO user_DTO) {
        if ( user_DTO == null ) {
            return null;
        }

        TblUser tblUser = new TblUser();

        tblUser.setTblAccounts( account_DTOListToTblAccountList( user_DTO.getAccounts_DTO() ) );
        tblUser.setTblCarts( cart_DTOListToTblCartList( user_DTO.getCarts_DTO() ) );
        tblUser.setTblStatus( status_DTOToTblStatus( user_DTO.getStatus_DTO() ) );
        tblUser.setTblBills( bill_DTOListToTblBillList( user_DTO.getBills_DTO() ) );
        tblUser.setIdUser( user_DTO.getIdUser() );
        tblUser.setAddressUser( user_DTO.getAddressUser() );
        tblUser.setBirthDayUser( user_DTO.getBirthDayUser() );
        tblUser.setImgUser( user_DTO.getImgUser() );
        tblUser.setNameUser( user_DTO.getNameUser() );
        tblUser.setNoteUser( user_DTO.getNoteUser() );
        tblUser.setPhoneNumber( user_DTO.getPhoneNumber() );

        return tblUser;
    }

    @Override
    public User_DTO user_DTO(TblUser tblUser) {
        if ( tblUser == null ) {
            return null;
        }

        User_DTO user_DTO = new User_DTO();

        user_DTO.setCarts_DTO( tblCartListToCart_DTOList( tblUser.getTblCarts() ) );
        user_DTO.setAccounts_DTO( tblAccountListToAccount_DTOList( tblUser.getTblAccounts() ) );
        user_DTO.setStatus_DTO( tblStatusToStatus_DTO( tblUser.getTblStatus() ) );
        user_DTO.setBills_DTO( tblBillListToBill_DTOList( tblUser.getTblBills() ) );
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

    protected TblAccount account_DTOToTblAccount(Account_DTO account_DTO) {
        if ( account_DTO == null ) {
            return null;
        }

        TblAccount tblAccount = new TblAccount();

        tblAccount.setIdAccount( account_DTO.getIdAccount() );
        tblAccount.setEmail( account_DTO.getEmail() );
        tblAccount.setPassword( account_DTO.getPassword() );

        return tblAccount;
    }

    protected List<TblAccount> account_DTOListToTblAccountList(List<Account_DTO> list) {
        if ( list == null ) {
            return null;
        }

        List<TblAccount> list1 = new ArrayList<TblAccount>( list.size() );
        for ( Account_DTO account_DTO : list ) {
            list1.add( account_DTOToTblAccount( account_DTO ) );
        }

        return list1;
    }

    protected TblCart cart_DTOToTblCart(Cart_DTO cart_DTO) {
        if ( cart_DTO == null ) {
            return null;
        }

        TblCart tblCart = new TblCart();

        tblCart.setIdCart( cart_DTO.getIdCart() );
        tblCart.setNoteCart( cart_DTO.getNoteCart() );

        return tblCart;
    }

    protected List<TblCart> cart_DTOListToTblCartList(List<Cart_DTO> list) {
        if ( list == null ) {
            return null;
        }

        List<TblCart> list1 = new ArrayList<TblCart>( list.size() );
        for ( Cart_DTO cart_DTO : list ) {
            list1.add( cart_DTOToTblCart( cart_DTO ) );
        }

        return list1;
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

    protected TblBill bill_DTOToTblBill(Bill_DTO bill_DTO) {
        if ( bill_DTO == null ) {
            return null;
        }

        TblBill tblBill = new TblBill();

        tblBill.setIdBill( bill_DTO.getIdBill() );
        tblBill.setDateOrder( bill_DTO.getDateOrder() );
        tblBill.setNoteBill( bill_DTO.getNoteBill() );

        return tblBill;
    }

    protected List<TblBill> bill_DTOListToTblBillList(List<Bill_DTO> list) {
        if ( list == null ) {
            return null;
        }

        List<TblBill> list1 = new ArrayList<TblBill>( list.size() );
        for ( Bill_DTO bill_DTO : list ) {
            list1.add( bill_DTOToTblBill( bill_DTO ) );
        }

        return list1;
    }

    protected Cart_DTO tblCartToCart_DTO(TblCart tblCart) {
        if ( tblCart == null ) {
            return null;
        }

        Cart_DTO cart_DTO = new Cart_DTO();

        if ( tblCart.getIdCart() != null ) {
            cart_DTO.setIdCart( tblCart.getIdCart() );
        }
        cart_DTO.setNoteCart( tblCart.getNoteCart() );

        return cart_DTO;
    }

    protected List<Cart_DTO> tblCartListToCart_DTOList(List<TblCart> list) {
        if ( list == null ) {
            return null;
        }

        List<Cart_DTO> list1 = new ArrayList<Cart_DTO>( list.size() );
        for ( TblCart tblCart : list ) {
            list1.add( tblCartToCart_DTO( tblCart ) );
        }

        return list1;
    }

    protected Account_DTO tblAccountToAccount_DTO(TblAccount tblAccount) {
        if ( tblAccount == null ) {
            return null;
        }

        Account_DTO account_DTO = new Account_DTO();

        if ( tblAccount.getIdAccount() != null ) {
            account_DTO.setIdAccount( tblAccount.getIdAccount() );
        }
        account_DTO.setEmail( tblAccount.getEmail() );
        account_DTO.setPassword( tblAccount.getPassword() );

        return account_DTO;
    }

    protected List<Account_DTO> tblAccountListToAccount_DTOList(List<TblAccount> list) {
        if ( list == null ) {
            return null;
        }

        List<Account_DTO> list1 = new ArrayList<Account_DTO>( list.size() );
        for ( TblAccount tblAccount : list ) {
            list1.add( tblAccountToAccount_DTO( tblAccount ) );
        }

        return list1;
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

    protected Bill_DTO tblBillToBill_DTO(TblBill tblBill) {
        if ( tblBill == null ) {
            return null;
        }

        Bill_DTO bill_DTO = new Bill_DTO();

        if ( tblBill.getIdBill() != null ) {
            bill_DTO.setIdBill( tblBill.getIdBill() );
        }
        bill_DTO.setDateOrder( tblBill.getDateOrder() );
        bill_DTO.setNoteBill( tblBill.getNoteBill() );

        return bill_DTO;
    }

    protected List<Bill_DTO> tblBillListToBill_DTOList(List<TblBill> list) {
        if ( list == null ) {
            return null;
        }

        List<Bill_DTO> list1 = new ArrayList<Bill_DTO>( list.size() );
        for ( TblBill tblBill : list ) {
            list1.add( tblBillToBill_DTO( tblBill ) );
        }

        return list1;
    }
}
