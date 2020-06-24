package jp.co.ntt.common.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class FiscalPeriodNullException extends Exception {
    private int AccountingReportDataId;
}
