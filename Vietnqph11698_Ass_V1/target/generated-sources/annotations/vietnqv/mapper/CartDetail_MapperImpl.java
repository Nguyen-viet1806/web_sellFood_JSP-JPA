package vietnqv.mapper;

import javax.annotation.Generated;
import vietnqv.dto.model.CartDetail_DTO;
import vietnqv.dto.model.Cart_DTO;
import vietnqv.dto.model.Product_DTO;
import vietnqv.server.model.TblCart;
import vietnqv.server.model.TblCartDetail;
import vietnqv.server.model.TblProduct;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-04-30T15:32:16+0700",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 3.22.0.v20200530-2032, environment: Java 1.8.0_261 (Oracle Corporation)"
)
public class CartDetail_MapperImpl implements CartDetail_Mapper {

    @Override
    public TblCartDetail tblCartDetail(CartDetail_DTO cartDetail_DTO) {
        if ( cartDetail_DTO == null ) {
            return null;
        }

        TblCartDetail tblCartDetail = new TblCartDetail();

        tblCartDetail.setTblCart( cart_DTOToTblCart( cartDetail_DTO.getCart_DTO() ) );
        tblCartDetail.setTblProduct( product_DTOToTblProduct( cartDetail_DTO.getProduct_DTO() ) );
        tblCartDetail.setIdCartDetail( cartDetail_DTO.getIdCartDetail() );
        tblCartDetail.setQuantityProduct( cartDetail_DTO.getQuantityProduct() );

        return tblCartDetail;
    }

    @Override
    public CartDetail_DTO cartDetail_DTO(TblCartDetail tblCartDetail) {
        if ( tblCartDetail == null ) {
            return null;
        }

        CartDetail_DTO cartDetail_DTO = new CartDetail_DTO();

        cartDetail_DTO.setProduct_DTO( tblProductToProduct_DTO( tblCartDetail.getTblProduct() ) );
        cartDetail_DTO.setCart_DTO( tblCartToCart_DTO( tblCartDetail.getTblCart() ) );
        if ( tblCartDetail.getIdCartDetail() != null ) {
            cartDetail_DTO.setIdCartDetail( tblCartDetail.getIdCartDetail() );
        }
        if ( tblCartDetail.getQuantityProduct() != null ) {
            cartDetail_DTO.setQuantityProduct( tblCartDetail.getQuantityProduct() );
        }

        return cartDetail_DTO;
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
}
