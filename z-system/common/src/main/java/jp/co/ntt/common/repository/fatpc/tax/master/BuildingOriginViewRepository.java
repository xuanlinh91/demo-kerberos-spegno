package jp.co.ntt.common.repository.fatpc.tax.master;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jp.co.ntt.common.entity.fatpc.tax.master.BuildingOriginViewEntity;

@Repository
public interface BuildingOriginViewRepository extends JpaRepository<BuildingOriginViewEntity, Integer> {

	@Query(value = "SELECT data_id, building_code_origin, building_name_origin, address"
			+ " FROM TM_BuildingOrigin"
			+ " WHERE"
			+ " delete_datetime IS NULL"
			+ " AND CASE WHEN :isSearchAddMatch THEN address like %:addMatch% ELSE FALSE END"
			+ " UNION"
			+ " SELECT TBL1.data_id, TBL1.building_code_origin, TBL1.building_name_origin, TBL1.address"
			+ " FROM TM_BuildingOrigin AS TBL1" 
			+ " WHERE" 
			+ " TBL1.delete_datetime IS NULL"
			+ " AND TBL1.fiscal_year = :year"
			+ " AND TBL1.fiscal_period = :yearMonth"
			+ " AND TBL1.fiscal_period_type = '3'"
			+ " AND TBL1.building_code_origin like %:buildingCodeOrigin%"
			+ " AND TBL1.building_name_origin like %:buildingNameOrigin%"
			+ " AND TBL1.address like %:address%"
			+ " AND TBL1.version = "
			+ " (SELECT TBL2.version "
			+ " FROM TD_DataVersion AS TBL2"
			+ " WHERE"
			+ " TBL2.delete_datetime IS NULL"
			+ " AND TBL2.report_id = TBL1.report_id"
			+ " AND TBL2.fiscal_year = TBL1.fiscal_year"
			+ " AND TBL2.fiscal_period = TBL1.fiscal_period"
			+ " AND TBL2.fiscal_period_type = TBL1.fiscal_period_type"
			+ " AND TBL2.incremental_flag = TBL1.incremental_flag"
			+ " LIMIT 1)"
			+ " LIMIT :start, :pagesize"
			, nativeQuery = true)
	List<BuildingOriginViewEntity> findBuildingOriginWithPagesize(
			@Param("start") int start, @Param("pagesize") int pagesize, 
			@Param("year") String year, @Param("yearMonth") String yearMonth,
			@Param("buildingCodeOrigin") String buildingCodeOrigin, @Param("buildingNameOrigin") String buildingNameOrigin, @Param("address") String address,
			@Param("isSearchAddMatch") boolean isSearchAddMatch, @Param("addMatch") String addMatch);
	
	@Query(value = "SELECT COUNT(DUM.data_id) as count"
			+ " FROM"
			+ " ("
			+ " SELECT data_id"
			+ " FROM TM_BuildingOrigin"
			+ " WHERE"
			+ " delete_datetime IS NULL"
			+ " AND CASE WHEN :isSearchAddMatch THEN address like %:addMatch% ELSE FALSE END"
			+ " UNION"
			+ " SELECT TBL1.data_id"
			+ " FROM TM_BuildingOrigin AS TBL1" 
			+ " WHERE" 
			+ " TBL1.delete_datetime IS NULL"
			+ " AND TBL1.fiscal_year = :year"
			+ " AND TBL1.fiscal_period = :yearMonth"
			+ " AND TBL1.fiscal_period_type = '3'"
			+ " AND TBL1.building_code_origin like %:buildingCodeOrigin%"
			+ " AND TBL1.building_name_origin like %:buildingNameOrigin%"
			+ " AND TBL1.address like %:address%"
			+ " AND TBL1.version = "
			+ " (SELECT TBL2.version "
			+ " FROM TD_DataVersion AS TBL2"
			+ " WHERE"
			+ " TBL2.delete_datetime IS NULL"
			+ " AND TBL2.report_id = TBL1.report_id"
			+ " AND TBL2.fiscal_year = TBL1.fiscal_year"
			+ " AND TBL2.fiscal_period = TBL1.fiscal_period"
			+ " AND TBL2.fiscal_period_type = TBL1.fiscal_period_type"
			+ " AND TBL2.incremental_flag = TBL1.incremental_flag"
			+ " LIMIT 1)"
			+ " ) AS DUM;"
			, nativeQuery = true)
	Long countBuildingOrigin(@Param("year") String year, @Param("yearMonth") String yearMonth,
			@Param("buildingCodeOrigin") String buildingCodeOrigin, @Param("buildingNameOrigin") String buildingNameOrigin, @Param("address") String address,
			@Param("isSearchAddMatch") boolean isSearchAddMatch, @Param("addMatch") String addMatch);
	
	@Query(value = "SELECT TBL1.data_id, TBL1.building_code_origin, TBL1.building_name_origin, TBL1.address"
			+ " FROM TM_BuildingOrigin AS TBL1" 
			+ " WHERE" 
			+ " TBL1.delete_datetime IS NULL"
			+ " AND TBL1.fiscal_year = :year"
			+ " AND TBL1.fiscal_period = :yearMonth"
			+ " AND TBL1.fiscal_period_type = '3'"
			+ " AND TBL1.building_code_origin like %:buildingCodeOrigin%"
			+ " AND TBL1.building_name_origin like %:buildingNameOrigin%"
			+ " AND TBL1.address like %:address%"
			+ " AND TBL1.version = "
			+ " (SELECT TBL2.version "
			+ " FROM TD_DataVersion AS TBL2"
			+ " WHERE"
			+ " TBL2.delete_datetime IS NULL"
			+ " AND TBL2.report_id = TBL1.report_id"
			+ " AND TBL2.fiscal_year = TBL1.fiscal_year"
			+ " AND TBL2.fiscal_period = TBL1.fiscal_period"
			+ " AND TBL2.fiscal_period_type = TBL1.fiscal_period_type"
			+ " AND TBL2.incremental_flag = TBL1.incremental_flag"
			+ " LIMIT 1)"
			+ " LIMIT :start, :pagesize"
			, nativeQuery = true)
	List<BuildingOriginViewEntity> findBuildingOriginAfterCorrWithPagesize(
			@Param("start") int start, @Param("pagesize") int pagesize, 
			@Param("year") String year, @Param("yearMonth") String yearMonth,
			@Param("buildingCodeOrigin") String buildingCodeOrigin, @Param("buildingNameOrigin") String buildingNameOrigin, @Param("address") String address);
	
	@Query(value = "SELECT COUNT(*) as count"
			+ " FROM TM_BuildingOrigin AS TBL1" 
			+ " WHERE" 
			+ " TBL1.delete_datetime IS NULL"
			+ " AND TBL1.fiscal_year = :year"
			+ " AND TBL1.fiscal_period = :yearMonth"
			+ " AND TBL1.fiscal_period_type = '3'"
			+ " AND TBL1.building_code_origin like %:buildingCodeOrigin%"
			+ " AND TBL1.building_name_origin like %:buildingNameOrigin%"
			+ " AND TBL1.address like %:address%"
			+ " AND TBL1.version = "
			+ " (SELECT TBL2.version "
			+ " FROM TD_DataVersion AS TBL2"
			+ " WHERE"
			+ " TBL2.delete_datetime IS NULL"
			+ " AND TBL2.report_id = TBL1.report_id"
			+ " AND TBL2.fiscal_year = TBL1.fiscal_year"
			+ " AND TBL2.fiscal_period = TBL1.fiscal_period"
			+ " AND TBL2.fiscal_period_type = TBL1.fiscal_period_type"
			+ " AND TBL2.incremental_flag = TBL1.incremental_flag"
			+ " LIMIT 1)"
			, nativeQuery = true)
	Long countBuildingOriginAfterCorr(@Param("year") String year, @Param("yearMonth") String yearMonth,
			@Param("buildingCodeOrigin") String buildingCodeOrigin, @Param("buildingNameOrigin") String buildingNameOrigin, @Param("address") String address);
}
