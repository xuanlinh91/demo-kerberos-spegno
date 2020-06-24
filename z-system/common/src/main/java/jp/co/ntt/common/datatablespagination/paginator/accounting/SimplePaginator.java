package jp.co.ntt.common.datatablespagination.paginator.accounting;

import jp.co.ntt.common.dto.request.datatable.accounting.DataTableCriteria;
import jp.co.ntt.common.dto.response.datatable.DataTableResponse;
import jp.co.ntt.common.service.datatable.DataTableService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;

@Slf4j
public class SimplePaginator<T> implements TablePaginator<T> {

	private DataTableService<T> dataService;

	public SimplePaginator(DataTableService<T> dataService) {
		this.dataService = dataService;
	}

	@Override
	public DataTableResponse<T> getPage(DataTableCriteria datatableCriteria) {
		return generatePage(datatableCriteria);
	}

	protected DataTableResponse<T> generatePage(DataTableCriteria datatableCriteria) {
		DataTableResponse<T> page = new DataTableResponse<>();
		Page<T> entries = dataService.getPageEntries(datatableCriteria);

		page.setDraw(datatableCriteria.getDraw());
		page.setRecordsTotal(dataService.countTotalEntries(datatableCriteria));
		page.setRecordsFiltered(entries.getTotalElements());
		page.setData(entries.getContent());

		return page;
	}
}
