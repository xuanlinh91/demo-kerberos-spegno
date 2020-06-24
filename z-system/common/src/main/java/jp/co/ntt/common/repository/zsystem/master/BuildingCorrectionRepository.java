package jp.co.ntt.common.repository.zsystem.master;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.co.ntt.common.entity.zsystem.master.BuildingCorrectionEntity;

@Repository
public interface BuildingCorrectionRepository extends JpaRepository<BuildingCorrectionEntity, Integer> {

}
