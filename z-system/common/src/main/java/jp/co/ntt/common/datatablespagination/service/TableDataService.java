package jp.co.ntt.common.datatablespagination.service;

import java.util.List;

import jp.co.ntt.common.datatablespagination.model.PaginationCriteria;

public interface TableDataService {

	public long countTotalEntries(PaginationCriteria paginationCriteria);

	public long countFilteredEntries(PaginationCriteria paginationCriteria);

	public <T> List<T> getPageEntries(PaginationCriteria paginationCriteria);

}
