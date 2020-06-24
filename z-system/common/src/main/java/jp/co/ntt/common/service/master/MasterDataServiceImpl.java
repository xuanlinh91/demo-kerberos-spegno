package jp.co.ntt.common.service.master;

import jp.co.ntt.common.dto.kaikei.master.*;
import jp.co.ntt.common.repository.fatpc.accounting.report.AccountingOrgRepository;
import jp.co.ntt.common.repository.fatpc.accounting.report.DepaDataRepository;
import jp.co.ntt.common.repository.fatpc.accounting.report.EmployeeMasterRepository;
import jp.co.ntt.common.repository.zsystem.kaikei.master.*;
import jp.co.ntt.common.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MasterDataServiceImpl extends BaseService implements MasterDataService {
    @Autowired
    OrganizationMasterRepository organizationMasterRepository;
    @Autowired
    DialAreaMasterRepository dialAreaMasterRepository;
    @Autowired
    ContactMasterRepository contactMasterRepository;
    @Autowired
    ProcessingGuideMasterRepository processingGuideMasterRepository;
    @Autowired
    NonParticipatingCompanyMasterRepository nonParticipatingCompanyMasterRepository;
    @Autowired
    DepartmentMasterRepository departmentMasterRepository;
    @Autowired
    SlipNumberMasterRepository slipNumberMasterRepository;
    @Autowired
    AddressBitMasterRepository addressBitMasterRepository;
    @Autowired
    EmployeeMasterRepository employeeMasterRepository;
    @Autowired
    DepaDataRepository depaDataRepository;
    @Autowired
    AccountingOrgRepository accountingOrgRepository;

    @Override
    public OrganizationMaster getOrganizationMaster() {
        return new OrganizationMaster(organizationMasterRepository.findAll());
    }

    @Override
    public DialAreaMaster getDialMaster() {
        return new DialAreaMaster(dialAreaMasterRepository.findAll());
    }

    @Override
    public ContactInfoReplacementMaster getContactMaster() {
        return new ContactInfoReplacementMaster(contactMasterRepository.findAll());
    }

    @Override
    public ProcessingGuideMaster getProcessingGuide() {
        return new ProcessingGuideMaster(processingGuideMasterRepository.findAll());
    }

    @Override
    public NonParticipatingCompanyMaster getNonParticipatingCompanyMaster() {
        return new NonParticipatingCompanyMaster(nonParticipatingCompanyMasterRepository.findAll());
    }

    @Override
    public DepartmentMaster getDepartmentMaster() {
        return new DepartmentMaster(departmentMasterRepository.findAll());
    }

    @Override
    public SlipNumberMaster getSlipNumberMaster() {
        return new SlipNumberMaster(slipNumberMasterRepository.findAll());
    }

    @Override
    public AddressBitMaster getAddressBitMaster() {
        return new AddressBitMaster(addressBitMasterRepository.findAll());
    }

    @Override
    public EmployeeMaster getEmployeeMaster() {
        return new EmployeeMaster(employeeMasterRepository.findAll());
    }

    @Override
    public DepaDataMaster getDepaDataMaster() {
        return new DepaDataMaster(depaDataRepository.findAll());
    }

    @Override
    public AccountingOrgMaster getAccountingOrgMaster() {
        return new AccountingOrgMaster(accountingOrgRepository.findAll());
    }
}
