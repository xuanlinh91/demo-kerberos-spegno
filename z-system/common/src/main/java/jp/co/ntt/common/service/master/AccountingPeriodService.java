package jp.co.ntt.common.service.master;

import java.util.List;

import jp.co.ntt.common.dto.tax.bldg.AccountingPeriodYearMonth;

public interface AccountingPeriodService {

	public Integer getAccountingbeginningOfPeriod();

	public List<Integer> getAccountingPeriodYear(int beginningOfPeriod);

	public List<Integer> getAccountingPeriodMonth(int beginningOfPeriod);

	public AccountingPeriodYearMonth getAccountingPeriodYearAndMonth();

}
