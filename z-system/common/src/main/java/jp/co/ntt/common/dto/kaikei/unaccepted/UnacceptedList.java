package jp.co.ntt.common.dto.kaikei.unaccepted;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Collection;

/**
 * 未検収・未承認リスト
 */

@Data
@AllArgsConstructor
public class UnacceptedList {
    private Collection<UnacceptedItem> unacceptedData;
}
