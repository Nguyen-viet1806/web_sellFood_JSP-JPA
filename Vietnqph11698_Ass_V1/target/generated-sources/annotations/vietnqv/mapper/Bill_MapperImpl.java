package vietnqv.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import vietnqv.dto.model.BillDetail_DTO;
import vietnqv.dto.model.Bill_DTO;
import vietnqv.dto.model.Status_DTO;
import vietnqv.dto.model.User_DTO;
import vietnqv.server.model.TblBill;
import vietnqv.server.model.TblBillDetail;
import vietnqv.server.model.TblStatus;
import vietnqv.server.model.TblUser;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-04-30T15:32:17+0700",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 3.22.0.v20200530-2032, environment: Java 1.8.0_261 (Oracle Corporation)"
)
public class Bill_MapperImpl implements Bill_Mapper {

    @Override
    public TblBill tblbill(Bill_DTO bill_DTO) {
        if ( bill_DTO == null ) {
            return null;
        }

        TblBill tblBill = new TblBill();

        tblBill.setTblUser( user_DTOToTblUser( bill_DTO.getUser_DTO() ) );
        tblBill.setTblStatus( status_DTOToTblStatus( bill_DTO.getStatus_DTO() ) );
        tblBill.setTblBillDetails( billDetail_DTOListToTblBillDetailList( bill_DTO.getBillDetails_DTO() ) );
        tblBill.setIdBill( bill_DTO.getIdBill() );
        tblBill.setDateOrder( bill_DTO.getDateOrder() );
        tblBill.setNoteBill( bill_DTO.getNoteBill() );

        return tblBill;
    }

    @Override
    public Bill_DTO bill_DTO(TblBill tblbill) {
        if ( tblbill == null ) {
            return null;
        }

        Bill_DTO bill_DTO = new Bill_DTO();

        bill_DTO.setUser_DTO( tblUserToUser_DTO( tblbill.getTblUser() ) );
        bill_DTO.setBillDetails_DTO( tblBillDetailListToBillDetail_DTOList( tblbill.getTblBillDetails() ) );
        bill_DTO.setStatus_DTO( tblStatusToStatus_DTO( tblbill.getTblStatus() ) );
        if ( tblbill.getIdBill() != null ) {
            bill_DTO.setIdBill( tblbill.getIdBill() );
        }
        bill_DTO.setDateOrder( tblbill.getDateOrder() );
        bill_DTO.setNoteBill( tblbill.getNoteBill() );

        return bill_DTO;
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
