package jp.co.ntt.common.repository.zsystem.master;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jp.co.ntt.common.entity.zsystem.master.DbPurposeEntity;

@Repository
public interface DbPurposeRepository extends JpaRepository<DbPurposeEntity, Integer> {

	@Query(value = "SELECT COUNT(*) FROM TM_DbPurpose WHERE db_purpose_id = :dbPurposeId AND delete_datetime IS NULL", nativeQuery = true)
	int findDbPurpose(@Param("dbPurposeId") int dbPurposeId);
}
