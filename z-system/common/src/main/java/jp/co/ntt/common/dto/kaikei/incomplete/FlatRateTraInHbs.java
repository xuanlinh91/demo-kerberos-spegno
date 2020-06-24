package jp.co.ntt.common.dto.kaikei.incomplete;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class FlatRateTraInHbs implements IncompleteItem {
    /**
     * 帳票データ
     */
    private FlatRateTraInHbsItem reportData;

    /**
     * 進捗データ
     */
    private IncompleteProgressData progressData;

    @Override
    public AccountingDataReport getReportData(){
        return reportData;
    }

    public FlatRateTraInHbs(FlatRateTraInHbsItem reportData) {
        this.reportData = reportData;
    }
}
