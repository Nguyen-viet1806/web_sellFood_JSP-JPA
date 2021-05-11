package vietnqv.mapper;

import javax.annotation.Generated;
import vietnqv.dto.model.BillDetail_DTO;
import vietnqv.dto.model.Bill_DTO;
import vietnqv.dto.model.Product_DTO;
import vietnqv.server.model.TblBill;
import vietnqv.server.model.TblBillDetail;
import vietnqv.server.model.TblProduct;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-04-30T15:32:17+0700",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 3.22.0.v20200530-2032, environment: Java 1.8.0_261 (Oracle Corporation)"
)
public class BillDetail_MapperImpl implements BillDetail_Mapper {

    @Override
    public TblBillDetail tblBillDetail(BillDetail_DTO billDetail_DTO) {
        if ( billDetail_DTO == null ) {
            return null;
        }

        TblBillDetail tblBillDetail = new TblBillDetail();

        tblBillDetail.setTblBill( bill_DTOToTblBill( billDetail_DTO.getBill_DTO() ) );
        tblBillDetail.setTblProduct( product_DTOToTblProduct( billDetail_DTO.getProduct_DTO() ) );
        tblBillDetail.setIdBillDetail( billDetail_DTO.getIdBillDetail() );
        tblBillDetail.setQuantityProduct( billDetail_DTO.getQuantityProduct() );

        return tblBillDetail;
    }

    @Override
    public BillDetail_DTO billDetail_DTO(TblBillDetail tblBillDetail) {
        if ( tblBillDetail == null ) {
            return null;
        }

        BillDetail_DTO billDetail_DTO = new BillDetail_DTO();

        billDetail_DTO.setProduct_DTO( tblProductToProduct_DTO( tblBillDetail.getTblProduct() ) );
        billDetail_DTO.setBill_DTO( tblBillToBill_DTO( tblBillDetail.getTblBill() ) );
        if ( tblBillDetail.getIdBillDetail() != null ) {
            billDetail_DTO.setIdBillDetail( tblBillDetail.getIdBillDetail() );
        }
        if ( tblBillDetail.getQuantityProduct() != null ) {
            billDetail_DTO.setQuantityProduct( tblBillDetail.getQuantityProduct() );
        }

        return billDetail_DTO;
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
}
