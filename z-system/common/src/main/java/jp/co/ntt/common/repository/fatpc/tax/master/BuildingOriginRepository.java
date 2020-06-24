package jp.co.ntt.common.repository.fatpc.tax.master;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.co.ntt.common.entity.fatpc.tax.master.BuildingOriginEntity;

@Repository
public interface BuildingOriginRepository extends JpaRepository<BuildingOriginEntity, Integer> {

}
