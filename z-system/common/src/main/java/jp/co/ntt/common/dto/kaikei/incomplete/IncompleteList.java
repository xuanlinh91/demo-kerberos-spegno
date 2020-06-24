package jp.co.ntt.common.dto.kaikei.incomplete;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * G間未完了リスト
 */

@Data
@AllArgsConstructor
public class IncompleteList {
    private List<IncompleteItem> incompleteData;
}
