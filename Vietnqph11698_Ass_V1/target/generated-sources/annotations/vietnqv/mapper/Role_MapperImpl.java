package vietnqv.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import vietnqv.dto.model.Account_DTO;
import vietnqv.dto.model.Role_DTO;
import vietnqv.dto.model.Status_DTO;
import vietnqv.server.model.TblAccount;
import vietnqv.server.model.TblRole;
import vietnqv.server.model.TblStatus;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-04-30T15:32:16+0700",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 3.22.0.v20200530-2032, environment: Java 1.8.0_261 (Oracle Corporation)"
)
public class Role_MapperImpl implements Role_Mapper {

    @Override
    public TblRole tblRole(Role_DTO role_DTO) {
        if ( role_DTO == null ) {
            return null;
        }

        TblRole tblRole = new TblRole();

        tblRole.setTblAccounts( account_DTOListToTblAccountList( role_DTO.getAccounts_DTO() ) );
        tblRole.setTblStatus( status_DTOToTblStatus( role_DTO.getStatus_DTO() ) );
        tblRole.setIdRole( role_DTO.getIdRole() );
        tblRole.setNameRole( role_DTO.getNameRole() );

        return tblRole;
    }

    @Override
    public Role_DTO role_DTO(TblRole tblRole) {
        if ( tblRole == null ) {
            return null;
        }

        Role_DTO role_DTO = new Role_DTO();

        role_DTO.setStatus_DTO( tblStatusToStatus_DTO( tblRole.getTblStatus() ) );
        role_DTO.setAccounts_DTO( tblAccountListToAccount_DTOList( tblRole.getTblAccounts() ) );
        if ( tblRole.getIdRole() != null ) {
            role_DTO.setIdRole( tblRole.getIdRole() );
        }
        role_DTO.setNameRole( tblRole.getNameRole() );

        return role_DTO;
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

    protected TblStatus status_DTOToTblStatus(Status_DTO status_DTO) {
        if ( status_DTO == null ) {
            return null;
        }

        TblStatus tblStatus = new TblStatus();

        tblStatus.setIdStatus( status_DTO.getIdStatus() );
        tblStatus.setNameStatus( status_DTO.getNameStatus() );

        return tblStatus;
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
}
