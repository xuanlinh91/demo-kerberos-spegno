package jp.co.ntt.webapp.controller.rest.master;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.co.ntt.common.dto.tax.bldg.AccountingPeriodYearMonth;
import jp.co.ntt.common.service.master.AccountingPeriodService;
import jp.co.ntt.webapp.controller.BaseController;

@RestController
public class AccountingPeriodRestController extends BaseController<AccountingPeriodService> {
	@Autowired()
	AccountingPeriodService accountingPeriodService;

	@GetMapping("/api/master/accounting-period")
	public AccountingPeriodYearMonth getIncompleteListApi() {
		var accountingPeriodYearMonth = accountingPeriodService.getAccountingPeriodYearAndMonth();
		return accountingPeriodYearMonth;
	}

}
