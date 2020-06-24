package jp.co.ntt.common.service.master;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.ntt.common.dto.tax.bldg.AccountingPeriodYearMonth;
import jp.co.ntt.common.repository.zsystem.master.AccountingPeriodRepository;
import jp.co.ntt.common.service.BaseService;

@Service
public class AccountingPeriodServiceImpl extends BaseService implements AccountingPeriodService {

	@Autowired()
	private AccountingPeriodRepository accountingPeriodRepository;

	/**
	 * 会計の期首月の取得
	 */
	@Override
	public Integer getAccountingbeginningOfPeriod() {

		return accountingPeriodRepository.findBeginningOfPeriod();

	}

	/**
	 * 会計期間-年度の取得
	 */
	@Override
	public List<Integer> getAccountingPeriodYear(int beginningOfPeriod) {

		var list = new ArrayList<Integer>();

		LocalDate currentDate = LocalDate.now();
		var currentMonth = currentDate.getMonthValue();
		var currentYear = currentDate.getYear();

		// 現在日付の月が期首月の場合
		if ((currentMonth == beginningOfPeriod)) {
			list.add(currentYear - 1);
			list.add(currentYear);
		} else if (currentMonth < beginningOfPeriod) {
			// 現在日付の月 - 期首月 がマイナスの場合
			list.add(currentYear - 1);
		} else {
			list.add(currentYear);
		}

		return list;
	}

	/**
	 * 会計期間-月の取得
	 */
	@Override
	public List<Integer> getAccountingPeriodMonth(int beginningOfPeriod) {

		var list = new ArrayList<Integer>();
		for (var i = 1; i < 13; i++) {
			if (beginningOfPeriod > 12) {
				beginningOfPeriod = 1;
			}
			list.add(beginningOfPeriod++);
		}

		return list;
	}

	/**
	 * 会計期間-年度と月の取得
	 */
	@Override
	public AccountingPeriodYearMonth getAccountingPeriodYearAndMonth() {

		Integer beginningOfPeriod = getAccountingbeginningOfPeriod();
		if (beginningOfPeriod == null) {
			return null;
		}

		var lastMonth = LocalDate.now().plusMonths(-1).getMonthValue();

		var accountingPeriodYear = getAccountingPeriodYear(beginningOfPeriod);
		var accountingPeriodMonth = getAccountingPeriodMonth(beginningOfPeriod);

		return new AccountingPeriodYearMonth(lastMonth, beginningOfPeriod, accountingPeriodYear, accountingPeriodMonth);
	}
}
