package vietnqv.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import vietnqv.dto.model.Category_DTO;
import vietnqv.dto.model.Product_DTO;
import vietnqv.dto.model.Status_DTO;
import vietnqv.server.model.TblCategory;
import vietnqv.server.model.TblProduct;
import vietnqv.server.model.TblStatus;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-04-30T15:32:15+0700",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 3.22.0.v20200530-2032, environment: Java 1.8.0_261 (Oracle Corporation)"
)
public class Category_MapperImpl implements Category_Mapper {

    @Override
    public TblCategory tblCategory(Category_DTO category_DTO) {
        if ( category_DTO == null ) {
            return null;
        }

        TblCategory tblCategory = new TblCategory();

        tblCategory.setTblProducts( product_DTOListToTblProductList( category_DTO.getProducts_DTO() ) );
        tblCategory.setTblStatus( status_DTOToTblStatus( category_DTO.getStatus_DTO() ) );
        tblCategory.setIdCategory( category_DTO.getIdCategory() );
        tblCategory.setNameCategory( category_DTO.getNameCategory() );

        return tblCategory;
    }

    @Override
    public Category_DTO category_DTO(TblCategory tblCategory) {
        if ( tblCategory == null ) {
            return null;
        }

        Category_DTO category_DTO = new Category_DTO();

        category_DTO.setProducts_DTO( tblProductListToProduct_DTOList( tblCategory.getTblProducts() ) );
        category_DTO.setStatus_DTO( tblStatusToStatus_DTO( tblCategory.getTblStatus() ) );
        if ( tblCategory.getIdCategory() != null ) {
            category_DTO.setIdCategory( tblCategory.getIdCategory() );
        }
        category_DTO.setNameCategory( tblCategory.getNameCategory() );

        return category_DTO;
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

    protected TblStatus status_DTOToTblStatus(Status_DTO status_DTO) {
        if ( status_DTO == null ) {
            return null;
        }

        TblStatus tblStatus = new TblStatus();

        tblStatus.setIdStatus( status_DTO.getIdStatus() );
        tblStatus.setNameStatus( status_DTO.getNameStatus() );

        return tblStatus;
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
