package jp.co.ntt.common.service.kaikei;

import com.github.dozermapper.core.Mapper;
import jp.co.ntt.common.dto.kaikei.incomplete.*;
import jp.co.ntt.common.dto.kaikei.master.*;
import jp.co.ntt.common.dto.kaikei.unaccepted.UnacceptedItem;
import jp.co.ntt.common.dto.kaikei.unaccepted.UnacceptedList;
import jp.co.ntt.common.dto.kaikei.unaccepted.UnacceptedReport;
import jp.co.ntt.common.dto.request.datatable.accounting.DataTableCriteria;
import jp.co.ntt.common.entity.kaikei.report.AccountingReportEntity;
import jp.co.ntt.common.service.BaseService;
import jp.co.ntt.common.service.master.MasterDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static jp.co.ntt.common.constant.Constants.*;

@Service
public class KaikeiServiceImpl extends BaseService implements KaikeiService {
    @Autowired
    MasterDataService masterDataService;

    @Autowired
    IncompleteService incompleteService;

    @Autowired
    Mapper mapper;

    @Autowired
    UnacceptedService unacceptedService;

    // Step 3 メールアドレスリストの作成
    public Map<String, IncompleteList> getMailDividedIncompleteLists() {
//        IncompleteList currentIncompleteList = this.getIncompleteList();
//
//        return incompleteService.divideByMailAddress(currentIncompleteList);
        return null;
    }

    @Override
    public Page<IncompleteItem> searchIncompleteFlatRateTraInHbsList(DataTableCriteria dataTableCriteria) {
        Page<AccountingReportEntity> accountingReportEntities = incompleteService.searchIncompletePage(dataTableCriteria);
        OrganizationMaster organizationMaster = masterDataService.getOrganizationMaster();
        ContactInfoReplacementMaster contactMaster = masterDataService.getContactMaster();
        ProcessingGuideMaster processingGuideMaster = masterDataService.getProcessingGuide();

        return accountingReportEntities
                .map(item -> new FlatRateTraInHbs(mapper.map(item, FlatRateTraInHbsItem.class)))
                .map(item -> incompleteService.applyPreviousProcessingData(item))
                .map(item -> incompleteService.applyOrganizationMasterData(item, organizationMaster))
                .map(item -> incompleteService.applyContactData(item, contactMaster))
                .map(item -> incompleteService.applyProcessingGuideData(item, processingGuideMaster));
    }

    @Override
    public Page<IncompleteItem> searchIncompleteFlatRateTraOwnList(DataTableCriteria dataTableCriteria) {
        Page<AccountingReportEntity> accountingReportEntities = incompleteService.searchIncompletePage(dataTableCriteria);
        DialAreaMaster dialAreaMaster = masterDataService.getDialMaster();
        ContactInfoReplacementMaster contactMaster = masterDataService.getContactMaster();
        ProcessingGuideMaster processingGuideMaster = masterDataService.getProcessingGuide();

        return accountingReportEntities
                .map(item -> new FlatRateTraOwn(mapper.map(item, FlatRateTraOwnItem.class)))
                .map(item -> incompleteService.applyPreviousProcessingData(item))
                .map(item -> incompleteService.applyDialAreaMasterData(item, dialAreaMaster))
                .map(item -> incompleteService.applyContactData(item, contactMaster))
                .map(item -> incompleteService.applyProcessingGuideData(item, processingGuideMaster));
    }

    @Override
    public Page<IncompleteItem> searchIncompleteIdvRateTraInHbsList(DataTableCriteria dataTableCriteria) {
        Page<AccountingReportEntity> accountingReportEntities = incompleteService.searchIncompletePage(dataTableCriteria);
        OrganizationMaster organizationMaster = masterDataService.getOrganizationMaster();
        ContactInfoReplacementMaster contactMaster = masterDataService.getContactMaster();
        ProcessingGuideMaster processingGuideMaster = masterDataService.getProcessingGuide();

        return accountingReportEntities
                .map(item -> new IdvRateTraInHbs(mapper.map(item, IdvRateTraInHbsItem.class)))
                .map(item -> incompleteService.applyPreviousProcessingData(item))
                .map(item -> incompleteService.applyOrganizationMasterData(item, organizationMaster))
                .map(item -> incompleteService.applyContactData(item, contactMaster))
                .map(item -> incompleteService.applyProcessingGuideData(item, processingGuideMaster));
    }

    @Override
    public Page<IncompleteItem> searchIncompleteIdvRateTraOwnPsList(DataTableCriteria dataTableCriteria) {
        Page<AccountingReportEntity> accountingReportEntities = incompleteService.searchIncompletePage(dataTableCriteria);
        DialAreaMaster dialAreaMaster = masterDataService.getDialMaster();
        ContactInfoReplacementMaster contactMaster = masterDataService.getContactMaster();
        NonParticipatingCompanyMaster nonParticipatingCompanyMaster = masterDataService.getNonParticipatingCompanyMaster();
        ProcessingGuideMaster processingGuideMaster = masterDataService.getProcessingGuide();

        return accountingReportEntities
                .map(item -> new IdvRateTraOwnPs(mapper.map(item, IdvRateTraOwnPsItem.class)))
                .map(item -> incompleteService.applyPreviousProcessingData(item))
                .map(item -> incompleteService.applyDialAreaMasterData(item, dialAreaMaster))
                .map(item -> incompleteService.applyContactData(item, contactMaster))
                .map(item -> incompleteService.applyProcessingGuideData(item, processingGuideMaster))
                .map(item -> incompleteService.applyNonParticipatingCompanyData(item, nonParticipatingCompanyMaster));
    }

    @Override
    public Page<UnacceptedItem> searchUnacceptedList(DataTableCriteria dataTableCriteria){
        Page<AccountingReportEntity> accountingReportEntities = unacceptedService.searchUnacceptedList(dataTableCriteria);
        EmployeeMaster employeeMaster = masterDataService.getEmployeeMaster();
        DepaDataMaster depaDataMaster = masterDataService.getDepaDataMaster();
        AccountingOrgMaster accountingOrgMaster = masterDataService.getAccountingOrgMaster();
        DepartmentMaster departmentMaster = masterDataService.getDepartmentMaster();
        SlipNumberMaster slipNumberMaster = masterDataService.getSlipNumberMaster();
//        AddressBitMaster addressBitMaster = masterDataService.getAddressBitMaster();

        return accountingReportEntities
                .map(item -> new UnacceptedItem(mapper.map(item, UnacceptedReport.class)))
                .map(item -> unacceptedService.applyPreviousProcessingData(item))
                .map(item -> unacceptedService.applyEmployeeData(item, employeeMaster, depaDataMaster, accountingOrgMaster))
//                .map(item -> unacceptedService.applyAddressBitMasterData(item, addressBitMaster))
                .map(item -> unacceptedService.applyDepartmentMasterData(item, departmentMaster))
                .map(item -> unacceptedService.applySlipNumberMasterData(item, slipNumberMaster))
                .map(item -> unacceptedService.updateSuppliersData(item));
    }
}
