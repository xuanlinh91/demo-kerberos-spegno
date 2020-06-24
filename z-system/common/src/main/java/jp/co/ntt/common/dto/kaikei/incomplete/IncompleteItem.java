package jp.co.ntt.common.dto.kaikei.incomplete;

/**
 * G間未完了リスト
 */
public interface IncompleteItem {
    AccountingDataReport getReportData();
    IncompleteProgressData getProgressData();
    void setProgressData(IncompleteProgressData progressData);
}
