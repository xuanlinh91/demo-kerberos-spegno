package jp.co.ntt.common.dto.kaikei.master;

import jp.co.ntt.common.entity.kaikei.master.EmployeeMasterEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Collection;

@Data
@AllArgsConstructor
public class EmployeeMaster {
    Collection<EmployeeMasterEntity> data;
}
