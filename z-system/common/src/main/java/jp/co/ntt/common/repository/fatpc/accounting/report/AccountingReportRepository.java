package jp.co.ntt.common.repository.fatpc.accounting.report;

import jp.co.ntt.common.entity.kaikei.report.AccountingReportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AccountingReportRepository extends JpaRepository<AccountingReportEntity, Integer>, JpaSpecificationExecutor<AccountingReportEntity> {
    List<AccountingReportEntity> findByReportIdAndSubReportNoAndFiscalPeriod(int reportId, int subReportNo, String fiscalPeriod);

    long countByReportIdAndSubReportNoAndFiscalPeriod(int reportId, int subReportNo, String fiscalPeriod);

    @Query(value = "SELECT * " +
            "FROM TD_AccountingReportData a " +
            "INNER JOIN TD_DataVersion b ON a.report_id = b.report_id AND a.version = b.version " +
            "WHERE a.report_id = ?1 " +
            "AND a.delete_datetime is NULL " +
            "AND sub_report_no = ?2", nativeQuery = true)
    List<AccountingReportEntity> findLatestReportByReportIdAndSubReportNoAndFiscalPeriod(int reportId, int subReportNo, String fiscalPeriod);
}
