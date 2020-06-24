package jp.co.ntt.common.service.kaikei;

import com.github.dozermapper.core.Mapper;
import jp.co.ntt.common.dto.kaikei.incomplete.*;
import jp.co.ntt.common.dto.kaikei.master.*;
import jp.co.ntt.common.dto.request.datatable.accounting.DataTableCriteria;
import jp.co.ntt.common.entity.kaikei.master.*;
import jp.co.ntt.common.entity.kaikei.report.AccountingReportEntity;
import jp.co.ntt.common.entity.kaikei.incomplete.IncompleteReportDataEntity;
import jp.co.ntt.common.entity.kaikei.report.DataVersionEntity;
import jp.co.ntt.common.repository.fatpc.accounting.report.AccountingReportRepository;
import jp.co.ntt.common.repository.fatpc.accounting.report.AccountingReportVersionRepository;
import jp.co.ntt.common.repository.spectification.AccountingReportSpecs;
import jp.co.ntt.common.repository.zsystem.kaikei.incomplete.IncompleteReportDataRepository;
import jp.co.ntt.common.service.datatable.DataTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

import static jp.co.ntt.common.constant.Constants.*;
import static jp.co.ntt.common.util.SpecUtil.*;
import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

@Service
public class IncompleteServiceImpl implements IncompleteService, DataTableService<IncompleteItem> {
    @Autowired
    AccountingReportRepository accountingReportRepository;

    @Autowired
    KaikeiService kaikeiService;

    @Autowired
    AccountingReportVersionRepository accountingReportVersionRepository;

    @Autowired
    IncompleteReportDataRepository incompleteReportDataRepository;

    @Autowired
    Mapper mapper;

    @Override
    public Page<AccountingReportEntity> searchIncompletePage(DataTableCriteria dataTableCriteria) {
        DataVersionEntity dataVersionEntity = accountingReportVersionRepository.findByReportIdAndDeleteDatetime(INCOMPLETE_REPORT_ID, null);
        Sort sort = andSort(generateSortList(dataTableCriteria)).orElse(Sort.unsorted());
        Pageable pageable = PageRequest.of(dataTableCriteria.getStart() / dataTableCriteria.getLength(), dataTableCriteria.getLength(), sort);

        Specification<AccountingReportEntity> defaultCondition = AccountingReportSpecs.getDefaultSpecs(INCOMPLETE_REPORT_ID, dataTableCriteria.getSubReportNo(),
                dataTableCriteria.getFiscalPeriod(), dataVersionEntity.getVersion());
        Specification<AccountingReportEntity> searchCondition = generateSearchSpec(dataTableCriteria);

        return accountingReportRepository.findAll(Specification.where(defaultCondition).and(searchCondition), pageable);
    }

    @Override
    public List<AccountingReportEntity> getLatestIncompleteList(Integer subReportNo, String fiscalPeriod) {
        return accountingReportRepository.findLatestReportByReportIdAndSubReportNoAndFiscalPeriod(INCOMPLETE_REPORT_ID, subReportNo, fiscalPeriod);
    }

    @Override
    public IncompleteList applyDialAreaMasterData(IncompleteList incompleteList, DialAreaMaster dialAreaMaster) {
        incompleteList.getIncompleteData().forEach(incompleteItem -> applyDialAreaMasterData(incompleteItem, dialAreaMaster));

        return incompleteList;
    }

    @Override
    public IncompleteList applyContactData(IncompleteList incompleteList, ContactInfoReplacementMaster contactInfoReplacementMaster) {
        incompleteList.getIncompleteData().forEach(incompleteItem -> applyContactData(incompleteItem, contactInfoReplacementMaster));

        return incompleteList;
    }

    @Override
    public IncompleteList applyProcessingGuideData(IncompleteList incompleteList, ProcessingGuideMaster processingGuideMaster) {
        incompleteList.getIncompleteData().forEach(incompleteItem -> applyProcessingGuideData(incompleteItem, processingGuideMaster));

        return incompleteList;
    }

    @Override
    public IncompleteList applyOrganizationMasterData(IncompleteList incompleteList, OrganizationMaster organizationMaster) {
        incompleteList.getIncompleteData().forEach(incompleteItem -> applyOrganizationMasterData(incompleteItem, organizationMaster));

        return incompleteList;
    }

    @Override
    public IncompleteItem applyDialAreaMasterData(IncompleteItem incompleteItem, DialAreaMaster dialAreaMaster) {
        String phoneNumber = incompleteItem.getReportData().getContactTel().replace("-", EMPTY_STRING);
        String regionalCode = dialAreaMaster.getData()
                .stream()
                .filter(item -> phoneNumber.contains(item.getDialAreaCode()))
                .max(Comparator.comparingInt(item -> item.getDialAreaCode().length()))
                .map(DialAreaMasterEntity::getRegionalCode)
                .orElse(EMPTY_STRING);

//                    Todo test to make sure that it return the longest phone number item
        incompleteItem.getProgressData().setArea(regionalCode);

        return incompleteItem;
    }

    @Override
    public IncompleteItem applyContactData(IncompleteItem incompleteItem, ContactInfoReplacementMaster contactInfoReplacementMaster) {
        String contactEmail = incompleteItem.getReportData().getContactMailAddress();
        Optional<ContactInfoReplacementEntity> contactMasterItem = contactInfoReplacementMaster.getData()
                .stream()
                .filter(item -> item.getMatchingEmail().equals(contactEmail))
                .findFirst();

        contactMasterItem.ifPresent(organizationMasterEntity -> {
            incompleteItem.getReportData().setPartnerPicName(contactMasterItem.get().getReplacePicName());
            incompleteItem.getReportData().setPartnerPicTel(contactMasterItem.get().getReplacePicTel());
            incompleteItem.getReportData().setPartnerPicEmail(contactMasterItem.get().getReplacePicEmail());
        });

        return incompleteItem;
    }

    @Override
    public IncompleteItem applyProcessingGuideData(IncompleteItem incompleteItem, ProcessingGuideMaster processingGuideMaster) {
        String status = incompleteItem.getReportData().getStatus();
        String bldgingSideAcptCntStatus = incompleteItem.getReportData().getBldgingSideAcptCntStatus();
        String paymentSideAcptCntStatus = incompleteItem.getReportData().getPaymentSideAcptCntStatus();
        Optional<ProcessingGuideMasterEntity> processingGuideMasterItem = processingGuideMaster.getData()
                .stream()
                .filter(item -> item.getStatus().equals(status)
                        && incompleteItem.getReportData().getReportId().equals(item.getReportId())
                        && incompleteItem.getReportData().getSubReportNo().equals(item.getSubReportId())
                        && item.getBillingFirstTimeAccConnStatus().equals(bldgingSideAcptCntStatus)
                        && item.getPaymentFirstTimeAccConnStatus().equals(paymentSideAcptCntStatus)
                )
                .findFirst();

        processingGuideMasterItem.ifPresent(item -> incompleteItem.getProgressData().setProcessingGuide(item.getProcessingGuide()));

        return incompleteItem;
    }

    @Override
    public IncompleteItem applyOrganizationMasterData(IncompleteItem incompleteItem, OrganizationMaster organizationMaster) {
        String orgCode = incompleteItem.getReportData().getAccountingOrgCode();
        Optional<OrganizationMasterEntity> organizationMasterItem = organizationMaster.getData()
                .stream()
                .filter(item -> item.getOrgCode().equals(orgCode))
                .findFirst();

        organizationMasterItem.ifPresent(organizationMasterEntity -> incompleteItem.getProgressData().setArea(organizationMasterEntity.getRegional().getRegionalCode()));

        return incompleteItem;
    }

    @Override
    public IncompleteItem applyNonParticipatingCompanyData(IncompleteItem incompleteItem, NonParticipatingCompanyMaster nonParticipatingCompanyMaster) {
        String companyName = incompleteItem.getReportData().getPartnerCompanyName();
        Optional<NonParticipatingCompanyMasterEntity> nonParticipatingCompanyItem = nonParticipatingCompanyMaster.getData()
                .stream()
                .filter(item -> item.getCompanyName().equals(companyName))
                .findFirst();

        nonParticipatingCompanyItem.ifPresent(organizationMasterEntity -> incompleteItem.getProgressData().setNoBillingSideParticipationNoAmount(NO_BILLING_SIDE_PARTICIPANT_NO_AMOUNT));

        return incompleteItem;
    }

    @Override
    public IncompleteItem applyPreviousProcessingData(IncompleteItem incompleteItem) {
        IncompleteReportDataEntity incompleteProgressDataEntity = incompleteReportDataRepository.findById(incompleteItem.getReportData().getAccountingReportDataId()).orElse(new IncompleteReportDataEntity());
        // 契約登録番号と会計期間が空白じゃないデータをフィールダーリング
        List<Pair<LocalDateTime, String>> updatedInfo = new ArrayList<>(Collections.emptyList());
        if (isNotBlank(incompleteItem.getReportData().getContractRegistrationNumber()) && isNotBlank(incompleteItem.getReportData().getFiscalPeriod())) {
            incompleteReportDataRepository.findLatestJudgementById(incompleteItem.getReportData().getContractRegistrationNumber(), incompleteItem.getReportData().getFiscalPeriod()).ifPresent(
                    incompleteProgressDataEntity::setJudgement
            );
            incompleteReportDataRepository.findLatestProcessingStatusById(incompleteItem.getReportData().getContractRegistrationNumber(), incompleteItem.getReportData().getFiscalPeriod()).ifPresent(
                    incompleteProgressDataEntity::setProcessingStatus
            );
            incompleteReportDataRepository.findLatestReminderExclusionById(incompleteItem.getReportData().getContractRegistrationNumber(), incompleteItem.getReportData().getFiscalPeriod()).ifPresent(
                    incompleteProgressDataEntity::setReminderExclusion
            );
            incompleteReportDataRepository.findLatestBaJudgementById(incompleteItem.getReportData().getContractRegistrationNumber(), incompleteItem.getReportData().getFiscalPeriod()).ifPresent(item ->
                    {
                        incompleteProgressDataEntity.setBaJudgement(item.getBaJudgement());
                        updatedInfo.add(Pair.of(item.getUpdatedAt(), item.getUpdateUser()));
                    }
            );
            incompleteReportDataRepository.findLatestBaCommentById(incompleteItem.getReportData().getContractRegistrationNumber(), incompleteItem.getReportData().getFiscalPeriod()).ifPresent(item ->
                    {
                        incompleteProgressDataEntity.setBaComment(item.getBaComment());
                        updatedInfo.add(Pair.of(item.getUpdatedAt(), item.getUpdateUser()));
                    }

            );
            incompleteReportDataRepository.findLatestBaProcessingGuideById(incompleteItem.getReportData().getContractRegistrationNumber(), incompleteItem.getReportData().getFiscalPeriod()).ifPresent(item ->
                    {
                        incompleteProgressDataEntity.setBaProcessingStatus(item.getBaProcessingStatus());
                        updatedInfo.add(Pair.of(item.getUpdatedAt(), item.getUpdateUser()));
                    }
            );

            //処理状況（BA西担当者利用）がない場合は処理状況（問い合わせBOX）を使う
            if (isBlank(incompleteProgressDataEntity.getBaProcessingStatus()) && isNotBlank(incompleteProgressDataEntity.getBaProcessingStatus())) {
                incompleteProgressDataEntity.setBaProcessingStatus(incompleteProgressDataEntity.getBaProcessingStatus());
            }

            Pair<LocalDateTime, String> lastUpdateAtInfo = updatedInfo.stream().max(Comparator.comparing(Pair::getFirst)).orElse(Pair.of(LocalDateTime.now(), EMPTY_STRING));
            incompleteProgressDataEntity.setAccountingReportDataId(incompleteItem.getReportData().getAccountingReportDataId());
            incompleteProgressDataEntity.setUpdateUser(lastUpdateAtInfo.getSecond());
            incompleteProgressDataEntity.setContractRegistrationNumber(incompleteItem.getReportData().getContractRegistrationNumber());
            incompleteProgressDataEntity.setFiscalPeriod(incompleteItem.getReportData().getFiscalPeriod());
            incompleteReportDataRepository.save(incompleteProgressDataEntity);
            IncompleteProgressData incompleteProgressData = mapper.map(incompleteProgressDataEntity, IncompleteProgressData.class);
            incompleteItem.setProgressData(incompleteProgressData);
        }


        return incompleteItem;
    }

    @Override
    public IncompleteList applyNonParticipatingCompanyData(IncompleteList incompleteList, NonParticipatingCompanyMaster nonParticipatingCompanyMaster) {
        incompleteList.getIncompleteData().forEach(incompleteItem -> applyNonParticipatingCompanyData(incompleteItem, nonParticipatingCompanyMaster));

        return incompleteList;
    }

    @Override
    public IncompleteList applyPreviousProcessingData(IncompleteList incompleteList) {
        incompleteList.getIncompleteData().forEach(this::applyPreviousProcessingData);

        return incompleteList;
    }

    @Override
    public Map<String, IncompleteList> divideByMailAddress(IncompleteList incompleteList) {
        Map<String, IncompleteList> mailAddressDividedIncompleteListMap = new HashMap<>();
        // メールアドレスを取得
//        Set<String> emailSet = incompleteList.getIncompleteData().stream().map(incompleteItem -> {
//            switch (incompleteItem.getReportData().getSubReportNo()) {
//                case FLAT_RATE_TRA_IN_HBS_SUBREPORT_ID:
//                    //定額取引（自社請求側）_自社担当者
//                    return incompleteItem.getReportData().getFlatRateTraInHbsEmailAddress();
//                case FLAT_RATE_TRA_OWN_PS_SUBREPORT_ID:
//                    //定額取引（自社支払側）_自社担当者
//                    return incompleteItem.getReportData().getFlatRateTraOwnPaymentOwnContactPersonTelMailAddress();
//                case IDV_RATE_TRA_IN_HBS_SUBREPORT_ID:
//                    //個別取引（自社請求側）_自社担当者
//                    return incompleteItem.getReportData().getIdvRateTraInHbsEmailAddress();
//                case IDV_RATE_TRA_OWN_PS_SUBREPORT_ID:
//                    //定額取引（自社支払側）_自社担当者
//                    return incompleteItem.getReportData().getIdvRateTraOwnPsEmailAddress();
//                default:
//                    return null;
//            }
//        }).collect(Collectors.toSet());
//
////        空メールアドレスを除く
//        emailSet.removeIf(item -> item == null || item.isBlank());
//
//        for (String emailAddress : emailSet) {
//            List<IncompleteItem> emailIncompleteList = incompleteList.getIncompleteData().stream()
//                    .filter(incompleteItem -> {
//                                switch (incompleteItem.getReportData().getSubReportNo()) {
//                                    case FLAT_RATE_TRA_IN_HBS_SUBREPORT_ID:
//                                        //定額取引（自社請求側）_自社担当者DataVersionEntity
//                                        return incompleteItem.getReportData().getFlatRateTraInHbsEmailAddress().equals(emailAddress);
//                                    case FLAT_RATE_TRA_OWN_PS_SUBREPORT_ID:
//                                        //定額取引（自社支払側）_自社担当者
//                                        return incompleteItem.getReportData().getFlatRateTraOwnPaymentOwnContactPersonTelMailAddress().equals(emailAddress);
//                                    case IDV_RATE_TRA_IN_HBS_SUBREPORT_ID:
//                                        //個別取引（自社請求側）_自社担当者
//                                        return incompleteItem.getReportData().getIdvRateTraInHbsEmailAddress().equals(emailAddress);
//                                    case IDV_RATE_TRA_OWN_PS_SUBREPORT_ID:
//                                        //定額取引（自社支払側）_自社担当者
//                                        return incompleteItem.getReportData().getIdvRateTraOwnPsEmailAddress().equals(emailAddress);
//                                    default:
//                                        return false;
//                                }
//                            }
//                    ).collect(Collectors.toList());
//
//            mailAddressDividedIncompleteListMap.put(emailAddress, new IncompleteList(emailIncompleteList));
//        }

        return mailAddressDividedIncompleteListMap;
    }

    @Override
    public IncompleteReportDataEntity saveIncompleteProgressData(IncompleteProgressData progressData) {
        IncompleteReportDataEntity incompleteProgressDataEntity = incompleteReportDataRepository.findById(progressData.getAccountingReportDataId())
                .orElse(new IncompleteReportDataEntity());

        incompleteProgressDataEntity.setBaJudgement(progressData.getBaJudgement());
        incompleteProgressDataEntity.setBaProcessingStatus(progressData.getBaProcessingStatus());
        incompleteProgressDataEntity.setBaComment(progressData.getBaComment());
        incompleteProgressDataEntity.setReminderExclusion(progressData.getReminderExclusion());
        incompleteProgressDataEntity.setUpdateUser(progressData.getUpdateUser());
//        incompleteProgressDataEntity.setUpdatedAt(progressData.getUpdatedAt());
        if (incompleteProgressDataEntity.getAccountingReportDataId() == null) {
            incompleteProgressDataEntity.setAccountingReportDataId(progressData.getAccountingReportDataId());
        }

        return incompleteReportDataRepository.save(incompleteProgressDataEntity);
    }

    @Override
    public long countTotalEntries(DataTableCriteria datatableCriteria) {
        return accountingReportRepository.countByReportIdAndSubReportNoAndFiscalPeriod(INCOMPLETE_REPORT_ID, datatableCriteria.getSubReportNo(), datatableCriteria.getFiscalPeriod());
    }

    @Override
    public Page<IncompleteItem> getPageEntries(DataTableCriteria datatableCriteria) {
        switch (datatableCriteria.getSubReportNo()) {
            case FLAT_RATE_TRA_IN_HBS:
                return kaikeiService.searchIncompleteFlatRateTraInHbsList(datatableCriteria);
            case FLAT_RATE_TRA_OWN_PS:
                return kaikeiService.searchIncompleteFlatRateTraOwnList(datatableCriteria);
            case IDV_RATE_TRA_IN_HBS:
                return kaikeiService.searchIncompleteIdvRateTraInHbsList(datatableCriteria);
            case IDV_RATE_TRA_OWN_PS:
                return kaikeiService.searchIncompleteIdvRateTraOwnPsList(datatableCriteria);
            default:
                return Page.empty();
        }
    }

    @Override
    public IncompleteList getIncompleteFlatRateTraInHbsList(String fiscalPeriod) {
        List<AccountingReportEntity> accountingReportEntities = getLatestIncompleteList(FLAT_RATE_TRA_IN_HBS, fiscalPeriod);

        return new IncompleteList(accountingReportEntities.stream()
                .map(item -> new FlatRateTraInHbs(mapper.map(item, FlatRateTraInHbsItem.class)))
                .collect(Collectors.toList()));
    }

    @Override
    public IncompleteList getIncompleteFlatRateTraOwnList(String fiscalPeriod) {
        //        定額取引（自社請求側）
        List<AccountingReportEntity> accountingReportEntities = getLatestIncompleteList(FLAT_RATE_TRA_OWN_PS, fiscalPeriod);

        return new IncompleteList(accountingReportEntities.stream()
                .map(item -> new FlatRateTraOwn(mapper.map(item, FlatRateTraOwnItem.class)))
                .collect(Collectors.toList()));
    }

    @Override
    public IncompleteList getIncompleteIdvRateTraInHbsList(String fiscalPeriod) {
        //        個別取引（自社請求側）
        List<AccountingReportEntity> accountingReportEntities = getLatestIncompleteList(IDV_RATE_TRA_IN_HBS, fiscalPeriod);

        return new IncompleteList(accountingReportEntities.stream()
                .map(item -> new IdvRateTraInHbs(mapper.map(item, IdvRateTraInHbsItem.class)))
                .collect(Collectors.toList()));
    }

    @Override
    public IncompleteList getIncompleteIdvRateTraOwnPsList(String fiscalPeriod) {
        //        個別取引（自社請求側）
        List<AccountingReportEntity> accountingReportEntities = getLatestIncompleteList(IDV_RATE_TRA_OWN_PS, fiscalPeriod);

        return new IncompleteList(accountingReportEntities.stream()
                .map(item -> new IdvRateTraOwnPs(mapper.map(item, IdvRateTraOwnPsItem.class)))
                .collect(Collectors.toList()));
    }
}
