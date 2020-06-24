package jp.co.ntt.common.repository.zsystem.master;

import jp.co.ntt.common.dto.tax.master.BldgErrBldgErrorWarning;
import jp.co.ntt.common.entity.zsystem.master.ErrorWarningEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface ErrorWarningRepository extends JpaRepository<ErrorWarningEntity, Long> {
	
	@Query(value = "SELECT T1.version, T1.error_warning_id, T1.error_warning_content, T1.correspondence, T1.report_id, T1.incremental_flag"
			+ " FROM TM_ErrorWarning T1" 
			+ " WHERE"
			+ " T1.delete_datetime IS NULL"
			+ " AND T1.report_id = :reportId"
			+ " AND T1.fiscal_year = :year"
			+ " AND T1.fiscal_period = :yearMonth"
			+ " AND T1.fiscal_period_type = 3"
			+ " AND T1.incremental_flag = :incrementalFlag"
			+ " AND T1.version = :version"
			+ " AND T1.error_warning_id IN :errorWarningIdList"
			, nativeQuery = true)
	List<BldgErrBldgErrorWarning> findErrorWarning(@Param("year") String year, @Param("yearMonth") String yearMonth, 
			@Param("reportId") short reportId, @Param("incrementalFlag") byte incrementalFlag, @Param("version") int version,
			@Param("errorWarningIdList") Collection<Short> errorWarningIdList);
	
}
