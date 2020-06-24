package jp.co.ntt.common.repository.zsystem.master;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import jp.co.ntt.common.entity.zsystem.master.AccountingPeriodEntity;

@Repository
public interface AccountingPeriodRepository extends JpaRepository<AccountingPeriodEntity, Integer> {

	@Query(value = "SELECT beginning_of_period FROM TM_AccountingPeriod WHERE delete_datetime IS NULL LIMIT 1", nativeQuery = true)
	Integer findBeginningOfPeriod();

}
