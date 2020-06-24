package jp.co.ntt.common.dto.kaikei.incomplete;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class IdvRateTraInHbs implements IncompleteItem {
    /**
     * 個別取引（自社請求側）_備考
     */
    private IdvRateTraInHbsItem reportData;

    /**
     * 進捗データ
     */
    private IncompleteProgressData progressData;

    @Override
    public AccountingDataReport getReportData(){
        return reportData;
    }

    public IdvRateTraInHbs(IdvRateTraInHbsItem reportData) {
        this.reportData = reportData;
    }
}
