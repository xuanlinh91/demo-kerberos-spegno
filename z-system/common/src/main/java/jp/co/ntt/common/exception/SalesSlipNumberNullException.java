package jp.co.ntt.common.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SalesSlipNumberNullException extends Exception {
    private int accountingReportDataId;
}
