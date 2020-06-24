package jp.co.ntt.common.dto.kaikei.master;

import jp.co.ntt.common.entity.kaikei.master.ContactInfoReplacementEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Collection;

@Data
@AllArgsConstructor
public class ContactInfoReplacementMaster {
    Collection<ContactInfoReplacementEntity> data;
}
