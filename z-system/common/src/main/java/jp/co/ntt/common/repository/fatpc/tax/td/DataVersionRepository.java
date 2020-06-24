package jp.co.ntt.common.repository.fatpc.tax.td;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.co.ntt.common.entity.fatpc.tax.td.TaxDataVersionEntity;

@Repository
public interface DataVersionRepository extends JpaRepository<TaxDataVersionEntity, Long> {

}
