package jp.co.ntt.common.repository.zsystem.kaikei.incomplete;

import jp.co.ntt.common.entity.kaikei.incomplete.IncompleteReportDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface IncompleteReportDataRepository extends JpaRepository<IncompleteReportDataEntity, Integer> {
    @Query(value = "SELECT judgement " +
            "FROM TD_AcctRptDtaIncomplete " +
            "WHERE judgement IS NOT NULL " +
            "AND fiscal_period = ?2 " +
            "AND contract_registration_number = ?1 " +
            "ORDER BY insert_datetime DESC LIMIT 1", nativeQuery = true)
    Optional<Integer> findLatestJudgementById(String id, String fiscalPeriod);

    @Query(value = "SELECT `accounting_report_data_id`, `area`, `ba_comment`, `ba_judgement`, `ba_processing_status`, `contract_registration_number`, `fiscal_period`, `insert_datetime`, `insert_user`, `judgement`, `no_billing_side_participation_no_amount`, `processing_guide`, `processing_status`, `reminder_exclusion`, `update_datetime`, `update_user` " +
            "FROM TD_AcctRptDtaIncomplete " +
            "WHERE ba_judgement IS NOT NULL " +
            "AND fiscal_period = ?2 " +
            "AND contract_registration_number = ?1 " +
            "ORDER BY insert_datetime DESC LIMIT 1", nativeQuery = true)
    Optional<IncompleteReportDataEntity> findLatestBaJudgementById(String id, String fiscalPeriod);

    @Query(value = "SELECT `accounting_report_data_id`, `area`, `ba_comment`, `ba_judgement`, `ba_processing_status`, `contract_registration_number`, `fiscal_period`, `insert_datetime`, `insert_user`, `judgement`, `no_billing_side_participation_no_amount`, `processing_guide`, `processing_status`, `reminder_exclusion`, `update_datetime`, `update_user` " +
            "FROM TD_AcctRptDtaIncomplete " +
            "WHERE ba_comment IS NOT NULL " +
            "AND ba_comment != \"\" " +
            "AND fiscal_period = ?2 " +
            "AND contract_registration_number = ?1 " +
            "ORDER BY insert_datetime DESC LIMIT 1", nativeQuery = true)
    Optional<IncompleteReportDataEntity> findLatestBaCommentById(String id, String fiscalPeriod);

    @Query(value = "SELECT processing_status " +
            "FROM TD_AcctRptDtaIncomplete " +
            "WHERE processing_status IS NOT NULL " +
            "AND processing_status != \"\" " +
            "AND fiscal_period = ?2 " +
            "AND contract_registration_number = ?1 " +
            "ORDER BY insert_datetime DESC LIMIT 1", nativeQuery = true)
    Optional<String> findLatestProcessingStatusById(String id, String fiscalPeriod);

    @Query(value = "SELECT reminder_exclusion " +
            "FROM TD_AcctRptDtaIncomplete " +
            "WHERE reminder_exclusion IS NOT NULL " +
            "AND fiscal_period = ?2 " +
            "AND contract_registration_number = ?1 " +
            "ORDER BY insert_datetime DESC LIMIT 1", nativeQuery = true)
    Optional<Integer> findLatestReminderExclusionById(String id, String fiscalPeriod);

    @Query(value = "SELECT `accounting_report_data_id`, `area`, `ba_comment`, `ba_judgement`, `ba_processing_status`, `contract_registration_number`, `fiscal_period`, `insert_datetime`, `insert_user`, `judgement`, `no_billing_side_participation_no_amount`, `processing_guide`, `processing_status`, `reminder_exclusion`, `update_datetime`, `update_user` " +
            "FROM TD_AcctRptDtaIncomplete " +
            "WHERE ba_processing_status IS NOT NULL " +
            "AND ba_processing_status != \"\" " +
            "AND fiscal_period = ?2 " +
            "AND contract_registration_number = ?1 " +
            "ORDER BY insert_datetime DESC LIMIT 1", nativeQuery = true)
    Optional<IncompleteReportDataEntity> findLatestBaProcessingGuideById(String id, String fiscalPeriod);
}
