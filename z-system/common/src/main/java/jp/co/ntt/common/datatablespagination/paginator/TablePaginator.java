package jp.co.ntt.common.datatablespagination.paginator;

import jp.co.ntt.common.datatablespagination.model.PaginationCriteria;
import jp.co.ntt.common.datatablespagination.model.TablePage;

public interface TablePaginator<T> {
	public TablePage<T> getPage(PaginationCriteria paginationCriteria);
}
