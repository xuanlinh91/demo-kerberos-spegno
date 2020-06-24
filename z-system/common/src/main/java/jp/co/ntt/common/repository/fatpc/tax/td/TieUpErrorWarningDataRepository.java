package jp.co.ntt.common.repository.fatpc.tax.td;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jp.co.ntt.common.dto.tax.td.BldgErrBldgTieUpErrorWarningData;
import jp.co.ntt.common.entity.fatpc.tax.td.TieUpErrorWarningDataEntity;

@Repository
public interface TieUpErrorWarningDataRepository extends JpaRepository<TieUpErrorWarningDataEntity, Integer> {

	@Query(value = "SELECT DISTINCT error_warning_id, status, building_code, building_name, building_address, GROUP_CONCAT(error_warning_data_id) error_warning_data_ids"
			+ " FROM TD_TieUpErrorWarningData" 
			+ " WHERE" 
			+ " db_purpose_id = 3" 
			+ " AND tieup_type = :tieupType"
			+ " AND delete_datetime IS NULL" 
			+ " AND account_period_year = :year" 
			+ " AND account_period_month = :month"
			+ " GROUP BY error_warning_id, status , building_code, building_name, building_address"
			+ " ORDER BY"
			+ " (CASE WHEN :od = 0 THEN error_warning_id END) ASC,"
			+ " (CASE WHEN :od = 1 THEN status END) ASC,"
			+ " (CASE WHEN :od = 2 THEN status END) DESC,"
			+ " (CASE WHEN :od = 3 THEN building_code END) ASC,"
			+ " (CASE WHEN :od = 4 THEN building_code END) DESC,"
			+ " (CASE WHEN :od = 5 THEN building_name END) ASC,"
			+ " (CASE WHEN :od = 6 THEN building_name END) DESC,"
			+ " (CASE WHEN :od = 7 THEN building_address END) ASC,"
			+ " (CASE WHEN :od = 8 THEN building_address END) DESC"
			+ " LIMIT :start, :pagesize"
			, nativeQuery = true)
	List<BldgErrBldgTieUpErrorWarningData> findTieUpErrorWarningDataWithPagesize(@Param("tieupType") int tieupType,
			@Param("start") int start, @Param("pagesize") int pagesize, 
			@Param("year") String year, @Param("month") String month,  @Param("od") int order);
	
	@Query(value = "SELECT COUNT(DISTINCT error_warning_id, status , building_code, building_name, building_address)"
			+ " FROM TD_TieUpErrorWarningData" 
			+ " WHERE" 
			+ " db_purpose_id = 3" 
			+ " AND tieup_type = :tieupType"
			+ " AND delete_datetime IS NULL" 
			+ " AND account_period_year = :year" 
			+ " AND account_period_month = :month"
			, nativeQuery = true)
	Long countTieUpErrorWarningData(@Param("tieupType") int tieupType, @Param("year") String year, @Param("month") String month);
}
