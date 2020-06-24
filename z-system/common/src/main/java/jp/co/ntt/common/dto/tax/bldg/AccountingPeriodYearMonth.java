package jp.co.ntt.common.dto.tax.bldg;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 会計期間-年度リスト、会計期間-月リスト
 */

@Data
@AllArgsConstructor
public class AccountingPeriodYearMonth {

	Integer lastMonth; // 現在日付から取得した月の一つ前の項目(前月)
	Integer beginningOfPeriod; // 期首
	List<Integer> accountingPeriodYears;
	List<Integer> accountingPeriodMonths;
}
