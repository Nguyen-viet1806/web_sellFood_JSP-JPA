package vietnqv.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import vietnqv.dto.model.BillDetail_DTO;
import vietnqv.dto.model.CartDetail_DTO;
import vietnqv.dto.model.Category_DTO;
import vietnqv.dto.model.Product_DTO;
import vietnqv.dto.model.Status_DTO;
import vietnqv.server.model.TblBillDetail;
import vietnqv.server.model.TblCartDetail;
import vietnqv.server.model.TblCategory;
import vietnqv.server.model.TblProduct;
import vietnqv.server.model.TblStatus;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-04-30T15:32:16+0700",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 3.22.0.v20200530-2032, environment: Java 1.8.0_261 (Oracle Corporation)"
)
public class Product_MapperImpl implements Product_Mapper {

    @Override
    public TblProduct tblProduct(Product_DTO product_DTO) {
        if ( product_DTO == null ) {
            return null;
        }

        TblProduct tblProduct = new TblProduct();

        tblProduct.setTblStatus( status_DTOToTblStatus( product_DTO.getStatus_DTO() ) );
        tblProduct.setTblBillDetails( billDetail_DTOListToTblBillDetailList( product_DTO.getBillDetails_DTO() ) );
        tblProduct.setTblCategory( category_DTOToTblCategory( product_DTO.getCategory_DTO() ) );
        tblProduct.setTblCartDetails( cartDetail_DTOListToTblCartDetailList( product_DTO.getCartDetails_DTO() ) );
        tblProduct.setIdProduct( product_DTO.getIdProduct() );
        tblProduct.setImgProduct( product_DTO.getImgProduct() );
        tblProduct.setMoneyProduct( product_DTO.getMoneyProduct() );
        tblProduct.setNameProduct( product_DTO.getNameProduct() );
        tblProduct.setNoteProduct( product_DTO.getNoteProduct() );

        return tblProduct;
    }

    @Override
    public Product_DTO product_DTO(TblProduct tblProduct) {
        if ( tblProduct == null ) {
            return null;
        }

        Product_DTO product_DTO = new Product_DTO();

        product_DTO.setCartDetails_DTO( tblCartDetailListToCartDetail_DTOList( tblProduct.getTblCartDetails() ) );
        product_DTO.setCategory_DTO( tblCategoryToCategory_DTO( tblProduct.getTblCategory() ) );
        product_DTO.setBillDetails_DTO( tblBillDetailListToBillDetail_DTOList( tblProduct.getTblBillDetails() ) );
        product_DTO.setStatus_DTO( tblStatusToStatus_DTO( tblProduct.getTblStatus() ) );
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

    protected TblStatus status_DTOToTblStatus(Status_DTO status_DTO) {
        if ( status_DTO == null ) {
            return null;
        }

        TblStatus tblStatus = new TblStatus();

        tblStatus.setIdStatus( status_DTO.getIdStatus() );
        tblStatus.setNameStatus( status_DTO.getNameStatus() );

        return tblStatus;
    }

    protected TblBillDetail billDetail_DTOToTblBillDetail(BillDetail_DTO billDetail_DTO) {
        if ( billDetail_DTO == null ) {
            return null;
        }

        TblBillDetail tblBillDetail = new TblBillDetail();

        tblBillDetail.setIdBillDetail( billDetail_DTO.getIdBillDetail() );
        tblBillDetail.setQuantityProduct( billDetail_DTO.getQuantityProduct() );

        return tblBillDetail;
    }

    protected List<TblBillDetail> billDetail_DTOListToTblBillDetailList(List<BillDetail_DTO> list) {
        if ( list == null ) {
            return null;
        }

        List<TblBillDetail> list1 = new ArrayList<TblBillDetail>( list.size() );
        for ( BillDetail_DTO billDetail_DTO : list ) {
            list1.add( billDetail_DTOToTblBillDetail( billDetail_DTO ) );
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

    protected BillDetail_DTO tblBillDetailToBillDetail_DTO(TblBillDetail tblBillDetail) {
        if ( tblBillDetail == null ) {
            return null;
        }

        BillDetail_DTO billDetail_DTO = new BillDetail_DTO();

        if ( tblBillDetail.getIdBillDetail() != null ) {
            billDetail_DTO.setIdBillDetail( tblBillDetail.getIdBillDetail() );
        }
        if ( tblBillDetail.getQuantityProduct() != null ) {
            billDetail_DTO.setQuantityProduct( tblBillDetail.getQuantityProduct() );
        }

        return billDetail_DTO;
    }

    protected List<BillDetail_DTO> tblBillDetailListToBillDetail_DTOList(List<TblBillDetail> list) {
        if ( list == null ) {
            return null;
        }

        List<BillDetail_DTO> list1 = new ArrayList<BillDetail_DTO>( list.size() );
        for ( TblBillDetail tblBillDetail : list ) {
            list1.add( tblBillDetailToBillDetail_DTO( tblBillDetail ) );
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
}
