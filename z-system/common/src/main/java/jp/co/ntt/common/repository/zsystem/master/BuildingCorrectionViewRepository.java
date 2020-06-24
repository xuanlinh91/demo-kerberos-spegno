package jp.co.ntt.common.repository.zsystem.master;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jp.co.ntt.common.entity.zsystem.master.BuildingCorrectionViewEntity;

@Repository
public interface BuildingCorrectionViewRepository extends JpaRepository<BuildingCorrectionViewEntity, Integer> {
	
	@Query(value = "SELECT *"
			+ " FROM TM_BuildingCorrection"
			+ " WHERE"
			+ " delete_datetime IS NULL"
			+ " AND account_period_year = :year"
			+ " AND account_period_month = :month"
			+ " ORDER BY"
			+ " (CASE WHEN :od = 0 THEN CONCAT(account_period_year, ',', account_period_month) END) ASC,"
			+ " (CASE WHEN :od = 1 THEN company_code END) ASC,"
			+ " (CASE WHEN :od = 2 THEN company_code END) DESC,"
			+ " (CASE WHEN :od = 3 THEN company_name END) ASC,"
			+ " (CASE WHEN :od = 4 THEN company_name END) DESC,"
			+ " (CASE WHEN :od = 5 THEN company_buiding_code END) ASC,"
			+ " (CASE WHEN :od = 6 THEN company_buiding_code END) DESC,"
			+ " (CASE WHEN :od = 7 THEN building_code END) ASC,"
			+ " (CASE WHEN :od = 8 THEN building_code END) DESC,"
			+ " (CASE WHEN :od = 9 THEN building_name END) ASC,"
			+ " (CASE WHEN :od = 10 THEN building_name END) DESC,"
			+ " (CASE WHEN :od = 11 THEN address END) ASC,"
			+ " (CASE WHEN :od = 12 THEN address END) DESC,"
			+ " (CASE WHEN :od = 13 THEN changed_month END) ASC,"
			+ " (CASE WHEN :od = 14 THEN changed_month END) DESC,"
			+ " (CASE WHEN :od = 15 THEN changed_reason END) ASC,"
			+ " (CASE WHEN :od = 16 THEN changed_reason END) DESC"
			+ " LIMIT :start, :pagesize"
			, nativeQuery = true)
	List<BuildingCorrectionViewEntity> findBuildingCorrectionWithPagesize(
			@Param("start") int start, @Param("pagesize") int pagesize, 
			@Param("year") String year, @Param("month") String month,
			@Param("od") int order);
	
	@Query(value = "SELECT COUNT(*) as count"
			+ " FROM TM_BuildingCorrection"
			+ " WHERE"
			+ " delete_datetime IS NULL"
			+ " AND account_period_year = :year"
			+ " AND account_period_month = :month"
			, nativeQuery = true)
	Long countBuildingCorrection(@Param("year") String year, @Param("month") String month);


}
