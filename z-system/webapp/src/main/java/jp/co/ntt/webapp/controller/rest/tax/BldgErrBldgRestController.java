package jp.co.ntt.webapp.controller.rest.tax;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jp.co.ntt.common.datatablespagination.model.PaginationCriteria;
import jp.co.ntt.common.datatablespagination.model.TablePage;
import jp.co.ntt.common.datatablespagination.paginator.SimplePaginator;
import jp.co.ntt.common.dto.tax.bldg.BldgErrBldgListView;
import jp.co.ntt.common.service.tax.BldgErrBldgService;
import jp.co.ntt.webapp.controller.BaseController;

@RestController
public class BldgErrBldgRestController extends BaseController {

	@Autowired()
	private BldgErrBldgService bldgErrBldgService;

	@PostMapping(path = "/api/tax/bldg-err-bldg/find-data")
	public TablePage<BldgErrBldgListView> getBldgErrBldgData(@RequestBody PaginationCriteria treq) {

		var paginator = new SimplePaginator<BldgErrBldgListView>(bldgErrBldgService);
		return paginator.getPage(treq);
	}
}
