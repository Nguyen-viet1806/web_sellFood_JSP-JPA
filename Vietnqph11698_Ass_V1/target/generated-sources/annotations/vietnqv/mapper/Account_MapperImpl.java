package vietnqv.mapper;

import javax.annotation.Generated;
import vietnqv.dto.model.Account_DTO;
import vietnqv.dto.model.Role_DTO;
import vietnqv.dto.model.Status_DTO;
import vietnqv.dto.model.User_DTO;
import vietnqv.server.model.TblAccount;
import vietnqv.server.model.TblRole;
import vietnqv.server.model.TblStatus;
import vietnqv.server.model.TblUser;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-04-30T15:32:15+0700",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 3.22.0.v20200530-2032, environment: Java 1.8.0_261 (Oracle Corporation)"
)
public class Account_MapperImpl implements Account_Mapper {

    @Override
    public TblAccount tblaccount(Account_DTO account_DTO) {
        if ( account_DTO == null ) {
            return null;
        }

        TblAccount tblAccount = new TblAccount();

        tblAccount.setTblUser( user_DTOToTblUser( account_DTO.getUser_DTO() ) );
        tblAccount.setTblStatus( status_DTOToTblStatus( account_DTO.getStatus_DTO() ) );
        tblAccount.setTblRole( role_DTOToTblRole( account_DTO.getRole_DTO() ) );
        tblAccount.setIdAccount( account_DTO.getIdAccount() );
        tblAccount.setEmail( account_DTO.getEmail() );
        tblAccount.setPassword( account_DTO.getPassword() );

        return tblAccount;
    }

    @Override
    public Account_DTO account_DTO(TblAccount tblaccount) {
        if ( tblaccount == null ) {
            return null;
        }

        Account_DTO account_DTO = new Account_DTO();

        account_DTO.setUser_DTO( tblUserToUser_DTO( tblaccount.getTblUser() ) );
        account_DTO.setRole_DTO( tblRoleToRole_DTO( tblaccount.getTblRole() ) );
        account_DTO.setStatus_DTO( tblStatusToStatus_DTO( tblaccount.getTblStatus() ) );
        if ( tblaccount.getIdAccount() != null ) {
            account_DTO.setIdAccount( tblaccount.getIdAccount() );
        }
        account_DTO.setEmail( tblaccount.getEmail() );
        account_DTO.setPassword( tblaccount.getPassword() );

        return account_DTO;
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

    protected TblRole role_DTOToTblRole(Role_DTO role_DTO) {
        if ( role_DTO == null ) {
            return null;
        }

        TblRole tblRole = new TblRole();

        tblRole.setIdRole( role_DTO.getIdRole() );
        tblRole.setNameRole( role_DTO.getNameRole() );

        return tblRole;
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
