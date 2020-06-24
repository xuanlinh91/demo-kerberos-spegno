package jp.co.ntt.common.dto.kaikei.master;

import jp.co.ntt.common.entity.kaikei.master.DialAreaMasterEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Collection;

@Data
@AllArgsConstructor
public class DialAreaMaster {
    Collection<DialAreaMasterEntity> data;
}
