package vietnqv.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import vietnqv.dto.model.Account_DTO;
import vietnqv.dto.model.Bill_DTO;
import vietnqv.dto.model.Cart_DTO;
import vietnqv.dto.model.Category_DTO;
import vietnqv.dto.model.Product_DTO;
import vietnqv.dto.model.Role_DTO;
import vietnqv.dto.model.Status_DTO;
import vietnqv.dto.model.User_DTO;
import vietnqv.server.model.TblAccount;
import vietnqv.server.model.TblBill;
import vietnqv.server.model.TblCart;
import vietnqv.server.model.TblCategory;
import vietnqv.server.model.TblProduct;
import vietnqv.server.model.TblRole;
import vietnqv.server.model.TblStatus;
import vietnqv.server.model.TblUser;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-04-30T15:32:17+0700",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 3.22.0.v20200530-2032, environment: Java 1.8.0_261 (Oracle Corporation)"
)
public class Status_MapperImpl implements Status_Mapper {

    @Override
    public TblStatus tblStatus(Status_DTO status_DTO) {
        if ( status_DTO == null ) {
            return null;
        }

        TblStatus tblStatus = new TblStatus();

        tblStatus.setTblUsers( user_DTOListToTblUserList( status_DTO.getUsers_DTO() ) );
        tblStatus.setTblAccounts( account_DTOListToTblAccountList( status_DTO.getAccounts_DTO() ) );
        tblStatus.setTblCarts( cart_DTOListToTblCartList( status_DTO.getCarts_DTO() ) );
        tblStatus.setTblProducts( product_DTOListToTblProductList( status_DTO.getProducts_DTO() ) );
        tblStatus.setTblRoles( role_DTOListToTblRoleList( status_DTO.getRoles_DTO() ) );
        tblStatus.setTblBills( bill_DTOListToTblBillList( status_DTO.getBills_DTO() ) );
        tblStatus.setTblCategories( category_DTOListToTblCategoryList( status_DTO.getCategories_DTO() ) );
        tblStatus.setIdStatus( status_DTO.getIdStatus() );
        tblStatus.setNameStatus( status_DTO.getNameStatus() );

        return tblStatus;
    }

    @Override
    public Status_DTO status_DTO(TblStatus tblStatus) {
        if ( tblStatus == null ) {
            return null;
        }

        Status_DTO status_DTO = new Status_DTO();

        status_DTO.setCarts_DTO( tblCartListToCart_DTOList( tblStatus.getTblCarts() ) );
        status_DTO.setUsers_DTO( tblUserListToUser_DTOList( tblStatus.getTblUsers() ) );
        status_DTO.setBills_DTO( tblBillListToBill_DTOList( tblStatus.getTblBills() ) );
        status_DTO.setCategories_DTO( tblCategoryListToCategory_DTOList( tblStatus.getTblCategories() ) );
        status_DTO.setRoles_DTO( tblRoleListToRole_DTOList( tblStatus.getTblRoles() ) );
        status_DTO.setAccounts_DTO( tblAccountListToAccount_DTOList( tblStatus.getTblAccounts() ) );
        status_DTO.setProducts_DTO( tblProductListToProduct_DTOList( tblStatus.getTblProducts() ) );
        if ( tblStatus.getIdStatus() != null ) {
            status_DTO.setIdStatus( tblStatus.getIdStatus() );
        }
        status_DTO.setNameStatus( tblStatus.getNameStatus() );

        return status_DTO;
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

    protected List<TblUser> user_DTOListToTblUserList(List<User_DTO> list) {
        if ( list == null ) {
            return null;
        }

        List<TblUser> list1 = new ArrayList<TblUser>( list.size() );
        for ( User_DTO user_DTO : list ) {
            list1.add( user_DTOToTblUser( user_DTO ) );
        }

        return list1;
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

    protected TblProduct product_DTOToTblProduct(Product_DTO product_DTO) {
        if ( product_DTO == null ) {
            return null;
        }

        TblProduct tblProduct = new TblProduct();

        tblProduct.setIdProduct( product_DTO.getIdProduct() );
        tblProduct.setImgProduct( product_DTO.getImgProduct() );
        tblProduct.setMoneyProduct( product_DTO.getMoneyProduct() );
        tblProduct.setNameProduct( product_DTO.getNameProduct() );
        tblProduct.setNoteProduct( product_DTO.getNoteProduct() );

        return tblProduct;
    }

    protected List<TblProduct> product_DTOListToTblProductList(List<Product_DTO> list) {
        if ( list == null ) {
            return null;
        }

        List<TblProduct> list1 = new ArrayList<TblProduct>( list.size() );
        for ( Product_DTO product_DTO : list ) {
            list1.add( product_DTOToTblProduct( product_DTO ) );
        }

        return list1;
    }

    protected TblRole role_DTOToTblRole(Role_DTO role_DTO) {
        if ( role_DTO == null ) {
            return null;
        }

        TblRole tblRole = new TblRole();

        tblRole.setIdRole( role_DTO.getIdRole() );
        tblRole.setNameRole( role_DTO.getNameRole() );

        return tblRole;
    }

    protected List<TblRole> role_DTOListToTblRoleList(List<Role_DTO> list) {
        if ( list == null ) {
            return null;
        }

        List<TblRole> list1 = new ArrayList<TblRole>( list.size() );
        for ( Role_DTO role_DTO : list ) {
            list1.add( role_DTOToTblRole( role_DTO ) );
        }

        return list1;
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

    protected TblCategory category_DTOToTblCategory(Category_DTO category_DTO) {
        if ( category_DTO == null ) {
            return null;
        }

        TblCategory tblCategory = new TblCategory();

        tblCategory.setIdCategory( category_DTO.getIdCategory() );
        tblCategory.setNameCategory( category_DTO.getNameCategory() );

        return tblCategory;
    }

    protected List<TblCategory> category_DTOListToTblCategoryList(List<Category_DTO> list) {
        if ( list == null ) {
            return null;
        }

        List<TblCategory> list1 = new ArrayList<TblCategory>( list.size() );
        for ( Category_DTO category_DTO : list ) {
            list1.add( category_DTOToTblCategory( category_DTO ) );
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

    protected List<User_DTO> tblUserListToUser_DTOList(List<TblUser> list) {
        if ( list == null ) {
            return null;
        }

        List<User_DTO> list1 = new ArrayList<User_DTO>( list.size() );
        for ( TblUser tblUser : list ) {
            list1.add( tblUserToUser_DTO( tblUser ) );
        }

        return list1;
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

    protected Category_DTO tblCategoryToCategory_DTO(TblCategory tblCategory) {
        if ( tblCategory == null ) {
            return null;
        }

        Category_DTO category_DTO = new Category_DTO();

        if ( tblCategory.getIdCategory() != null ) {
            category_DTO.setIdCategory( tblCategory.getIdCategory() );
        }
        category_DTO.setNameCategory( tblCategory.getNameCategory() );

        return category_DTO;
    }

    protected List<Category_DTO> tblCategoryListToCategory_DTOList(List<TblCategory> list) {
        if ( list == null ) {
            return null;
        }

        List<Category_DTO> list1 = new ArrayList<Category_DTO>( list.size() );
        for ( TblCategory tblCategory : list ) {
            list1.add( tblCategoryToCategory_DTO( tblCategory ) );
        }

        return list1;
    }

    protected Role_DTO tblRoleToRole_DTO(TblRole tblRole) {
        if ( tblRole == null ) {
            return null;
        }

        Role_DTO role_DTO = new Role_DTO();

        if ( tblRole.getIdRole() != null ) {
            role_DTO.setIdRole( tblRole.getIdRole() );
        }
        role_DTO.setNameRole( tblRole.getNameRole() );

        return role_DTO;
    }

    protected List<Role_DTO> tblRoleListToRole_DTOList(List<TblRole> list) {
        if ( list == null ) {
            return null;
        }

        List<Role_DTO> list1 = new ArrayList<Role_DTO>( list.size() );
        for ( TblRole tblRole : list ) {
            list1.add( tblRoleToRole_DTO( tblRole ) );
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

    protected Product_DTO tblProductToProduct_DTO(TblProduct tblProduct) {
        if ( tblProduct == null ) {
            return null;
        }

        Product_DTO product_DTO = new Product_DTO();

        if ( tblProduct.getIdProduct() != null ) {
            product_DTO.setIdProduct( tblProduct.getIdProduct() );
        }
        product_DTO.setImgProduct( tblProduct.getImgProduct() );
        if ( tblProduct.getMoneyProduct() != null ) {
            product_DTO.setMoneyProduct( tblProduct.getMoneyProduct() );
        }
        product_DTO.setNameProduct( tblProduct.getNameProduct() );
        product_DTO.setNoteProduct( tblProduct.getNoteProduct() );

        return product_DTO;
    }

    protected List<Product_DTO> tblProductListToProduct_DTOList(List<TblProduct> list) {
        if ( list == null ) {
            return null;
        }

        List<Product_DTO> list1 = new ArrayList<Product_DTO>( list.size() );
        for ( TblProduct tblProduct : list ) {
            list1.add( tblProductToProduct_DTO( tblProduct ) );
        }

        return list1;
    }
}
