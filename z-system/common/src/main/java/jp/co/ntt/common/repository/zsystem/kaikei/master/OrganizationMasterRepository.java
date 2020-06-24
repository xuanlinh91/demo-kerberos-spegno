package jp.co.ntt.common.repository.zsystem.kaikei.master;

import jp.co.ntt.common.entity.kaikei.master.OrganizationMasterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationMasterRepository extends JpaRepository<OrganizationMasterEntity, Integer> {

}
