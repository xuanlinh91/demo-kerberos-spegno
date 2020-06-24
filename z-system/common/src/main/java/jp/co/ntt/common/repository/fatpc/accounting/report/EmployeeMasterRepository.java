package jp.co.ntt.common.repository.fatpc.accounting.report;

import jp.co.ntt.common.entity.kaikei.master.EmployeeMasterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeMasterRepository extends JpaRepository<EmployeeMasterEntity, Integer> {

}
