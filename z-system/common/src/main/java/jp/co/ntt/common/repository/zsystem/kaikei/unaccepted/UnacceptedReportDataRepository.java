package jp.co.ntt.common.repository.zsystem.kaikei.unaccepted;

import jp.co.ntt.common.entity.kaikei.unaccepted.UnacceptedReportDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UnacceptedReportDataRepository extends JpaRepository<UnacceptedReportDataEntity, Integer> {
    /**
     *
     * @return
     */
    @Query(value = "SELECT judgement " +
            "FROM TD_AcctRptDtaUnapproved " +
            "WHERE judgement IS NOT NULL " +
            "AND fiscal_period = ?2 " +
            "AND sales_slip_number = ?1 " +
            "ORDER BY insert_datetime DESC LIMIT 1", nativeQuery = true)
    Optional<Integer> findLatestJudgementBySalesSlipNumber(String id, String fiscalPeriod);

    /**
     *
     * @return
     */
    @Query(value = "SELECT remark " +
            "FROM TD_AcctRptDtaUnapproved " +
            "WHERE remark IS NOT NULL " +
            "AND remark != \"\"" +
            "AND fiscal_period = ?2 " +
            "AND sales_slip_number = ?1 " +
            "ORDER BY insert_datetime DESC LIMIT 1", nativeQuery = true)
    Optional<String> findLatestRemarkBySalesSlipNumber(String id, String fiscalPeriod);

    /**
     *
     * @return
     */
    @Query(value = "SELECT reminder_exclusion " +
            "FROM TD_AcctRptDtaUnapproved " +
            "WHERE reminder_exclusion IS NOT NULL " +
            "AND fiscal_period = ?2 " +
            "AND sales_slip_number = ?1 " +
            "ORDER BY insert_datetime DESC LIMIT 1", nativeQuery = true)
    Optional<Integer> findLatestReminderExclusionBySalesSlipNumber(String id, String fiscalPeriod);

    /**
     *
     * @return
     */
    @Query(value = "SELECT * " +
            "FROM TD_AcctRptDtaUnapproved " +
            "WHERE ba_judgement IS NOT NULL " +
            "AND fiscal_period = ?2 " +
            "AND sales_slip_number = ?1 " +
            "ORDER BY insert_datetime DESC LIMIT 1", nativeQuery = true)
    Optional<UnacceptedReportDataEntity> findLatestBaJudgementBySalesSlipNumber(String id, String fiscalPeriod);

    /**
     *
     * @return
     */
    @Query(value = "SELECT * " +
            "FROM TD_AcctRptDtaUnapproved " +
            "WHERE ba_comment IS NOT NULL " +
            "AND ba_comment != \"\"" +
            "AND fiscal_period = ?2 " +
            "AND sales_slip_number = ?1 " +
            "ORDER BY insert_datetime DESC LIMIT 1", nativeQuery = true)
    Optional<UnacceptedReportDataEntity> findLatestBaCommentBySalesSlipNumber(String id, String fiscalPeriod);

    @Query(value = "SELECT * " +
            "FROM TD_AcctRptDtaIncomplete " +
            "WHERE ba_processing_status IS NOT NULL " +
            "AND ba_processing_status != \"\"" +
            "AND fiscal_period = ?2 " +
            "AND contract_registration_number = ?1 " +
            "ORDER BY insert_datetime DESC LIMIT 1", nativeQuery = true)
    Optional<UnacceptedReportDataEntity> findLatestBaProcessingStatusById(String id, String fiscalPeriod);
}
