package jp.co.ntt.common.service.master;


import jp.co.ntt.common.dto.kaikei.master.*;
import org.springframework.stereotype.Service;

@Service
public interface MasterDataService {
    /**
     *
     * @return
     */
    OrganizationMaster getOrganizationMaster();

    /**
     *
     * @return
     */
    DialAreaMaster getDialMaster();

    /**
     *
     * @return
     */
    ContactInfoReplacementMaster getContactMaster();

    /**
     *
     * @return
     */
    ProcessingGuideMaster getProcessingGuide();

    /**
     *
     * @return
     */
    NonParticipatingCompanyMaster getNonParticipatingCompanyMaster();

    /**
     *
     * @return
     */
    DepartmentMaster getDepartmentMaster();

    /**
     *
     * @return
     */
    SlipNumberMaster getSlipNumberMaster();

    /**
     *
     * @return
     */
    AddressBitMaster getAddressBitMaster();

    /**
     *
     * @return
     */
    EmployeeMaster getEmployeeMaster();

    /**
     *
     * @return
     */
    DepaDataMaster getDepaDataMaster();

    /**
     *
     * @return
     */
    AccountingOrgMaster getAccountingOrgMaster();
}
