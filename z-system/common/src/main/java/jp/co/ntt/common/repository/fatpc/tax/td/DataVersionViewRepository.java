package jp.co.ntt.common.repository.fatpc.tax.td;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jp.co.ntt.common.entity.fatpc.tax.td.TaxDataVersionViewEntity;

@Repository
public interface DataVersionViewRepository extends JpaRepository<TaxDataVersionViewEntity, Long> {

	@Query(value = "SELECT data_version_id, report_id, incremental_flag, version"
			+ " FROM TD_DataVersion" 
			+ " WHERE"
			+ " delete_datetime IS NULL"
			+ " AND fiscal_year = :year"
			+ " AND fiscal_period = :yearMonth"
			+ " AND fiscal_period_type = 3"
			, nativeQuery = true)
	List<TaxDataVersionViewEntity> findDataVersion(@Param("year") String year, @Param("yearMonth") String yearMonth);
	
}
