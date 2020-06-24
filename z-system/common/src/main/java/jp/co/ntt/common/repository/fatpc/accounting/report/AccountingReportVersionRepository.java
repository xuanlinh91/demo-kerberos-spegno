package jp.co.ntt.common.repository.fatpc.accounting.report;

import jp.co.ntt.common.entity.kaikei.report.DataVersionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface AccountingReportVersionRepository extends JpaRepository<DataVersionEntity, Integer> {
    DataVersionEntity findByReportIdAndDeleteDatetime(Integer id, LocalDateTime deleteDatetime);
}
