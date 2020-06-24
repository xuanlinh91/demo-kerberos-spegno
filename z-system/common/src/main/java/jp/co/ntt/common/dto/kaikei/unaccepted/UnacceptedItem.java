package jp.co.ntt.common.dto.kaikei.unaccepted;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 未検収・未放任リスト
 */

@Data
@AllArgsConstructor
public class UnacceptedItem {
    private UnacceptedReport reportData;

    private UnacceptedProgressData progressData;

    public UnacceptedItem(UnacceptedReport reportData) {
        this.reportData = reportData;
    }
}
