package jp.co.ntt.common.service.datatable;

import jp.co.ntt.common.dto.request.datatable.accounting.DataTableCriteria;
import jp.co.ntt.common.exception.FiscalPeriodNullException;
import org.springframework.data.domain.Page;

public interface DataTableService<T> {
	long countTotalEntries(DataTableCriteria datatableCriteria);
	Page<T> getPageEntries(DataTableCriteria datatableCriteria);
}
