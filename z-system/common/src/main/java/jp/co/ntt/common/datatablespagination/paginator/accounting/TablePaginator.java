package jp.co.ntt.common.datatablespagination.paginator.accounting;

import jp.co.ntt.common.dto.request.datatable.accounting.DataTableCriteria;
import jp.co.ntt.common.dto.response.datatable.DataTableResponse;

public interface TablePaginator<T> {
	DataTableResponse<T> getPage(DataTableCriteria datatableCriteria);
}
