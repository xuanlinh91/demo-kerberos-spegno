package jp.co.ntt.common.repository.fatpc.tax.master;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jp.co.ntt.common.entity.fatpc.tax.master.CompanyListNTTWMissionEntity;

@Repository
public interface CompanyListNTTWMissionRepository extends JpaRepository<CompanyListNTTWMissionEntity, Long> {
	
	@Query(value = "SELECT C.company_name"
			+ " FROM TM_CompanyListNTTWMission C"
			+ " INNER JOIN TD_DataVersion V"
			+ " ON C.report_id = V.report_id"
			+ " AND C.fiscal_year = V.fiscal_year"
			+ " AND C.fiscal_period = V.fiscal_period"
			+ " AND C.fiscal_period_type = V.fiscal_period_type"
			+ " AND C.incremental_flag = V.incremental_flag"
			+ " AND C.version = V.version"
			+ " WHERE"
			+ " C.fiscal_year = :year"
			+ " AND C.fiscal_period = :yearMonth"
			+ " AND C.fiscal_period_type = 3"
			+ " AND C.company_code = :companyCode"
			+ " LIMIT 1"
			, nativeQuery = true)
	String findCompanyName(@Param("year") int year, @Param("yearMonth") String yearMonth,
			@Param("companyCode") String companyCode);

}
