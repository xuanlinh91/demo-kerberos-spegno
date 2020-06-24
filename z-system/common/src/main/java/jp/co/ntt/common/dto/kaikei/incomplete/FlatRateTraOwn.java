package jp.co.ntt.common.dto.kaikei.incomplete;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class FlatRateTraOwn implements IncompleteItem {
    /**
     * 定額取引（自社支払側）_接続日からの経過日数
     */
    private FlatRateTraOwnItem reportData;

    /**
     * 進捗データ
     */
    private IncompleteProgressData progressData;

    @Override
    public AccountingDataReport getReportData(){
        return reportData;
    }

    public FlatRateTraOwn(FlatRateTraOwnItem reportData) {
        this.reportData = reportData;
    }
}
