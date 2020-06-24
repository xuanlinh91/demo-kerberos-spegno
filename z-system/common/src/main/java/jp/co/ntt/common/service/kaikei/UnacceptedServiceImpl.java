package jp.co.ntt.common.service.kaikei;

import com.github.dozermapper.core.Mapper;
import jp.co.ntt.common.constant.Constants;
import jp.co.ntt.common.dto.kaikei.master.*;
import jp.co.ntt.common.dto.kaikei.unaccepted.UnacceptedItem;
import jp.co.ntt.common.dto.kaikei.unaccepted.UnacceptedList;
import jp.co.ntt.common.dto.kaikei.unaccepted.UnacceptedReport;
import jp.co.ntt.common.dto.kaikei.unaccepted.UnacceptedProgressData;
import jp.co.ntt.common.dto.request.datatable.accounting.DataTableCriteria;
import jp.co.ntt.common.entity.kaikei.master.*;
import jp.co.ntt.common.entity.kaikei.report.AccountingReportEntity;
import jp.co.ntt.common.entity.kaikei.report.DataVersionEntity;
import jp.co.ntt.common.entity.kaikei.unaccepted.UnacceptedReportDataEntity;
import jp.co.ntt.common.repository.fatpc.accounting.report.AccountingReportRepository;
import jp.co.ntt.common.repository.fatpc.accounting.report.AccountingReportVersionRepository;
import jp.co.ntt.common.repository.spectification.AccountingReportSpecs;
import jp.co.ntt.common.repository.zsystem.kaikei.unaccepted.UnacceptedReportDataRepository;
import jp.co.ntt.common.service.datatable.DataTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

import static jp.co.ntt.common.constant.Constants.*;
import static jp.co.ntt.common.util.SpecUtil.*;
import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

@Service
public class UnacceptedServiceImpl implements UnacceptedService, DataTableService<UnacceptedItem> {
    @Autowired
    Mapper mapper;

    @Autowired
    KaikeiService kaikeiService;

    @Autowired
    AccountingReportRepository accountingReportRepository;

    @Autowired
    AccountingReportVersionRepository accountingReportVersionRepository;

    @Autowired
    UnacceptedReportDataRepository unacceptedReportDataRepository;

    @Override
    public UnacceptedList getCurrentUnacceptedList(String fiscalPeriod) {
        List<AccountingReportEntity> accountingReportEntities = accountingReportRepository.findByReportIdAndSubReportNoAndFiscalPeriod(Constants.UNACCEPTED_REPORT_ID,
                Constants.UNACCEPTED_SUB_REPORT_NO, fiscalPeriod);
        List<UnacceptedItem> unacceptedReports = accountingReportEntities.stream()
                .map(item -> new UnacceptedItem(mapper.map(item, UnacceptedReport.class)))
                .collect(Collectors.toList());

        return new UnacceptedList(unacceptedReports);
    }

    @Override
    public UnacceptedList applyPreviousProcessingData(UnacceptedList unacceptedList) {
        unacceptedList.getUnacceptedData().stream()
                // 伝票番号と会計期間が空白じゃないデータをフィールダーリング
                .filter(item -> isNotBlank(item.getReportData().getSalesSlipNumber()) && isNotBlank(item.getReportData().getFiscalPeriod()))
                .forEach(unacceptedItem -> {

                });

        return unacceptedList;
    }

    @Override
    public UnacceptedItem applyPreviousProcessingData(UnacceptedItem unacceptedItem) {
        if (isBlank(unacceptedItem.getReportData().getSalesSlipNumber())) {
//            throw new SalesSlipNumberNullException(unacceptedItem.getReportData().getAccountingReportDataId());
        } else if (isBlank(unacceptedItem.getReportData().getFiscalPeriod())) {
//            throw new FiscalPeriodNullException(unacceptedItem.getReportData().getAccountingReportDataId());
        } else {
            UnacceptedReportDataEntity reportProcessingData = unacceptedReportDataRepository.findById(unacceptedItem.getReportData().getAccountingReportDataId()).orElse(new UnacceptedReportDataEntity());
            List<Pair<LocalDateTime, String>> updatedInfo = new ArrayList<>(Collections.emptyList());
            unacceptedReportDataRepository.findLatestJudgementBySalesSlipNumber(unacceptedItem.getReportData().getSalesSlipNumber(), unacceptedItem.getReportData().getFiscalPeriod()).ifPresent(
                    reportProcessingData::setJudgement
            );
            unacceptedReportDataRepository.findLatestRemarkBySalesSlipNumber(unacceptedItem.getReportData().getSalesSlipNumber(), unacceptedItem.getReportData().getFiscalPeriod()).ifPresent(
                    reportProcessingData::setRemark
            );
            unacceptedReportDataRepository.findLatestReminderExclusionBySalesSlipNumber(unacceptedItem.getReportData().getSalesSlipNumber(), unacceptedItem.getReportData().getFiscalPeriod()).ifPresent(
                    reportProcessingData::setReminderExclusion
            );
            unacceptedReportDataRepository.findLatestBaCommentBySalesSlipNumber(unacceptedItem.getReportData().getSalesSlipNumber(), unacceptedItem.getReportData().getFiscalPeriod()).ifPresent(item ->
                    {
                        reportProcessingData.setBaComment(item.getBaComment());
                        updatedInfo.add(Pair.of(item.getUpdatedAt(), item.getUpdateUser()));
                    }
            );
            unacceptedReportDataRepository.findLatestBaJudgementBySalesSlipNumber(unacceptedItem.getReportData().getSalesSlipNumber(), unacceptedItem.getReportData().getFiscalPeriod()).ifPresent(item ->
                    {
                        reportProcessingData.setBaJudgement(item.getBaJudgement());
                        updatedInfo.add(Pair.of(item.getUpdatedAt(), item.getUpdateUser()));
                    }
            );
            unacceptedReportDataRepository.findLatestBaProcessingStatusById(unacceptedItem.getReportData().getSalesSlipNumber(), unacceptedItem.getReportData().getFiscalPeriod()).ifPresent(item ->
                    {
                        reportProcessingData.setBaProcessingStatus(item.getBaProcessingStatus());
                        updatedInfo.add(Pair.of(item.getUpdatedAt(), item.getUpdateUser()));
                    }
            );

//                    処理状況（BA西担当者利用）がない場合は処理状況（問い合わせBOX）を使う
            if (isBlank(reportProcessingData.getBaProcessingStatus()) && isNotBlank(reportProcessingData.getRemark())) {
                reportProcessingData.setBaProcessingStatus(reportProcessingData.getRemark());
            }

            Pair<LocalDateTime, String> lastUpdateAtInfo = updatedInfo.stream().max(Comparator.comparing(Pair::getFirst)).orElse(Pair.of(LocalDateTime.now(), EMPTY_STRING));
            reportProcessingData.setAccountingReportDataId(unacceptedItem.getReportData().getAccountingReportDataId());
            reportProcessingData.setUpdateUser(lastUpdateAtInfo.getSecond());
            reportProcessingData.setSalesSlipNumber(unacceptedItem.getReportData().getContractRegistrationNumber());
            reportProcessingData.setFiscalPeriod(unacceptedItem.getReportData().getFiscalPeriod());
            unacceptedReportDataRepository.save(reportProcessingData);
            UnacceptedProgressData unacceptedProgressData = mapper.map(reportProcessingData, UnacceptedProgressData.class);
            unacceptedItem.setProgressData(unacceptedProgressData);
        }

        return unacceptedItem;
    }

    @Override
    public UnacceptedList applyEmployeeData(UnacceptedList unacceptedList, EmployeeMaster employeeMaster, DepaDataMaster depaDataMaster,
                                            AccountingOrgMaster accountingOrgMaster) {
        unacceptedList.getUnacceptedData().forEach(unacceptedItem -> applyEmployeeData(unacceptedItem, employeeMaster, depaDataMaster, accountingOrgMaster));

        return unacceptedList;
    }

    @Override
    public UnacceptedList applyAddressBitMasterData(UnacceptedList unacceptedList, AddressBitMaster addressBitMaster) {
        unacceptedList.getUnacceptedData().forEach(unacceptedItem -> applyAddressBitMasterData(unacceptedItem, addressBitMaster));

        return unacceptedList;
    }

    @Override
    public UnacceptedList applyDepartmentMasterData(UnacceptedList unacceptedList, DepartmentMaster departmentMaster) {
        unacceptedList.getUnacceptedData().forEach(unacceptedItem -> applyDepartmentMasterData(unacceptedItem, departmentMaster));

        return unacceptedList;
    }

    @Override
    public UnacceptedList applySlipNumberMasterData(UnacceptedList unacceptedList, SlipNumberMaster slipNumberMaster) {
        unacceptedList.getUnacceptedData().forEach(unacceptedItem -> applySlipNumberMasterData(unacceptedItem, slipNumberMaster));

        return unacceptedList;
    }

    @Override
    public UnacceptedList updateSuppliersData(UnacceptedList unacceptedList) {
        unacceptedList.getUnacceptedData().forEach(this::updateSuppliersData);

        return unacceptedList;
    }

    @Override
    @Transactional
    public UnacceptedReportDataEntity saveUnacceptedProgressData(UnacceptedProgressData progressData) {
        UnacceptedReportDataEntity unacceptedReportDataEntity = unacceptedReportDataRepository.findById(progressData.getAccountingReportDataId())
                .orElse(new UnacceptedReportDataEntity());

        unacceptedReportDataEntity.setBaJudgement(progressData.getBaJudgement());
        unacceptedReportDataEntity.setBaComment(progressData.getBaComment());
        unacceptedReportDataEntity.setBaProcessingStatus(progressData.getBaProcessingStatus());
        unacceptedReportDataEntity.setReminderExclusion(progressData.getReminderExclusion());
        unacceptedReportDataEntity.setUpdateUser(progressData.getUpdateUser());
        unacceptedReportDataEntity.setUpdatedAt(LocalDateTime.now());

        if (unacceptedReportDataEntity.getAccountingReportDataId() == null) {
            unacceptedReportDataEntity.setAccountingReportDataId(progressData.getAccountingReportDataId());
        }

        return unacceptedReportDataRepository.save(unacceptedReportDataEntity);
    }

    @Override
    public UnacceptedItem applyEmployeeData(UnacceptedItem unacceptedItem, EmployeeMaster employeeMaster, DepaDataMaster depaDataMaster, AccountingOrgMaster accountingOrgMaster) {
        //      1. 管理番号(キー)を付与する
        String managementNumber = unacceptedItem.getReportData().getAccountingOrgCode() + "-" + unacceptedItem.getReportData().getSalesSlipNumber();
        unacceptedItem.getReportData().setManagementNumber(managementNumber);


        String nameCode = unacceptedItem.getReportData().getNameCode();
        Optional<EmployeeMasterEntity> employeeMasterInfo = employeeMaster.getData().stream()
                .filter(item -> item.getEmployeeCode().equals(nameCode))
                .findFirst();

        //      2. ユーザ情報データを付与する
        employeeMasterInfo.ifPresent(firstInfo -> {
            unacceptedItem.getReportData().setMailAddress(firstInfo.getEmailAddress());
            unacceptedItem.getReportData().setPhoneNumber(firstInfo.getContactInformationTel());

            if (firstInfo.getMainBizIdentification().equals(MAIN_BIZ_IDENTIFICATION)) {
                String orgCode = firstInfo.getDepartmentCode().substring(0, 8);
                Optional<DepaDataMasterEntity> departmentData = depaDataMaster.getData().stream()
                        .filter(depaItem -> orgCode.equals(depaItem.getAccountingOrgCode()))
                        .findFirst();
                Optional<AccountingOrgMasterEntity> orgData = accountingOrgMaster.getData().stream()
                        .filter(orgItem -> orgCode.equals(orgItem.getAccountingOrgCode()))
                        .findFirst();

                String companyName = EMPTY_STRING;
                String depaname = EMPTY_STRING;
                String orgDivisionName = EMPTY_STRING;
                if (departmentData.isPresent()) {
                    // 会社名
                    companyName = departmentData.get().getCompanyName();
                    // 部課名
                    depaname = departmentData.get().getDepaName();
                }
                if (orgData.isPresent()) {
                    // 組織（事業部）名
                    orgDivisionName = orgData.get().getDescription();
                }

                // 所属
                unacceptedItem.getReportData().setAssignment(firstInfo.getDepartmentCode() + "_" + companyName + "_" + orgDivisionName + "_" + depaname);
            }
        });

        return unacceptedItem;
    }

    @Override
    public UnacceptedItem applyAddressBitMasterData(UnacceptedItem unacceptedItem, AddressBitMaster addressBitMaster) {
        String nameCode = unacceptedItem.getReportData().getNameCode();
        Optional<AddressBitMasterEntity> addressBitMasterItem = addressBitMaster.getData().stream()
                .filter(item -> item.getEmployeeCode().equals(nameCode))
                .findFirst();

        addressBitMasterItem.ifPresent(item -> unacceptedItem.getReportData().setAddressBit(item.getEmployeeCode()));

        return unacceptedItem;
    }

    @Override
    public UnacceptedItem applyDepartmentMasterData(UnacceptedItem unacceptedItem, DepartmentMaster departmentMaster) {
        String depaCode = unacceptedItem.getReportData().getDepaCode();
        Optional<DepartmentMasterEntity> departmentMasterItem = departmentMaster.getData().stream()
                .filter(item -> item.getDepartmentCode().equals(depaCode))
                .findFirst();

        departmentMasterItem.ifPresent(item -> unacceptedItem.getReportData().setDepartmentMasterInfo(item.getTaskName()));

        return unacceptedItem;
    }

    @Override
    public UnacceptedItem applySlipNumberMasterData(UnacceptedItem unacceptedItem, SlipNumberMaster slipNumberMaster) {
        String slipNumber = unacceptedItem.getReportData().getSalesSlipNumber();
        Optional<SlipNumberMasterEntity> departmentMasterItem = slipNumberMaster.getData().stream()
                .filter(item -> item.getSlipNumber().equals(slipNumber))
                .findFirst();

        departmentMasterItem.ifPresent(item -> unacceptedItem.getReportData().setContractRegistrationNumber(item.getContractNumber()));

        return unacceptedItem;
    }

    @Override
    public UnacceptedItem updateSuppliersData(UnacceptedItem unacceptedItem) {
        if (unacceptedItem.getReportData().getTraName().startsWith(UNACCEPTED_SUPPLIER_NAME_PATTERN)) {
            unacceptedItem.getReportData().setTraName(EMPTY_STRING);
        }

        return unacceptedItem;
    }

    @Override
    public Page<AccountingReportEntity> searchUnacceptedList(DataTableCriteria dataTableCriteria) {
        DataVersionEntity dataVersionEntity = accountingReportVersionRepository.findByReportIdAndDeleteDatetime(UNACCEPTED_REPORT_ID, null);
        Sort sort = andSort(generateSortList(dataTableCriteria)).orElse(Sort.unsorted());
        Pageable pageable = PageRequest.of(dataTableCriteria.getStart() / dataTableCriteria.getLength(), dataTableCriteria.getLength(), sort);
        Specification<AccountingReportEntity> defaultCondition = AccountingReportSpecs.getDefaultSpecs(UNACCEPTED_REPORT_ID, UNACCEPTED_SUB_REPORT_NO,
                dataTableCriteria.getFiscalPeriod(), dataVersionEntity.getVersion());
        Specification<AccountingReportEntity> searchCondition = generateSearchSpec(dataTableCriteria);

        return accountingReportRepository.findAll(Specification.where(defaultCondition).and(searchCondition), pageable);
    }

    @Override
    public long countTotalEntries(DataTableCriteria datatableCriteria) {
        return accountingReportRepository.countByReportIdAndSubReportNoAndFiscalPeriod(UNACCEPTED_REPORT_ID, datatableCriteria.getSubReportNo(), datatableCriteria.getFiscalPeriod());
    }

    @Override
    public Page<UnacceptedItem> getPageEntries(DataTableCriteria datatableCriteria) {
        return kaikeiService.searchUnacceptedList(datatableCriteria);
    }
}
