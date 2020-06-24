package jp.co.ntt.common.datatablespagination.paginator;

import jp.co.ntt.common.datatablespagination.model.PaginationCriteria;
import jp.co.ntt.common.datatablespagination.model.TablePage;
import jp.co.ntt.common.datatablespagination.service.TableDataService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SimplePaginator<T> implements TablePaginator<T> {

	private TableDataService dataService;

	public SimplePaginator(TableDataService dataService) {
		this.dataService = dataService;
	}

	@Override
	public TablePage<T> getPage(PaginationCriteria paginationCriteria) {
		var page = new TablePage<T>();

		page = generatePage(paginationCriteria);

		return page;
	}

	protected TablePage<T> generatePage(PaginationCriteria paginationCriteria) {
		var page = new TablePage<T>();

		page.setDraw(paginationCriteria.getDraw());
		log.debug("Draw set...");

		page.setRecordsTotal(dataService.countTotalEntries(paginationCriteria));
		log.debug("RecordsTotal set...");

		page.setRecordsFiltered(dataService.countFilteredEntries(paginationCriteria));
		log.debug("RecordsFiltered set...");

		page.setData(dataService.getPageEntries(paginationCriteria));
		log.debug("Data set...");

		return page;
	}
}
