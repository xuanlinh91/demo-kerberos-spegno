package jp.co.ntt.common.dto.kaikei.incomplete;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class IdvRateTraOwnPs implements IncompleteItem {
    /**
     * 個別取引（自社支払側）_備考
     */
    private IdvRateTraOwnPsItem reportData;

    /**
     * 進捗データ
     */
    private IncompleteProgressData progressData;

    @Override
    public AccountingDataReport getReportData(){
        return reportData;
    }

    public IdvRateTraOwnPs(IdvRateTraOwnPsItem reportData) {
        this.reportData = reportData;
    }
}
