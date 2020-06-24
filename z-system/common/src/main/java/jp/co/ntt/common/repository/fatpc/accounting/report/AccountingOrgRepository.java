package jp.co.ntt.common.repository.fatpc.accounting.report;

import jp.co.ntt.common.entity.kaikei.master.AccountingOrgMasterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountingOrgRepository extends JpaRepository<AccountingOrgMasterEntity, Integer> {

}
