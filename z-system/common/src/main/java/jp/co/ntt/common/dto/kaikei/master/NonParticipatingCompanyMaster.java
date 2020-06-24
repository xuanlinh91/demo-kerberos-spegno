package jp.co.ntt.common.dto.kaikei.master;

import jp.co.ntt.common.entity.kaikei.master.NonParticipatingCompanyMasterEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Collection;

@Data
@AllArgsConstructor
public class NonParticipatingCompanyMaster {
    Collection<NonParticipatingCompanyMasterEntity> data;
}
