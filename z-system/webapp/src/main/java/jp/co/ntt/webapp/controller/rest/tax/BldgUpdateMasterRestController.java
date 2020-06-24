package jp.co.ntt.webapp.controller.rest.tax;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jp.co.ntt.common.datatablespagination.model.PaginationCriteria;
import jp.co.ntt.common.datatablespagination.model.TablePage;
import jp.co.ntt.common.datatablespagination.paginator.SimplePaginator;
import jp.co.ntt.common.dto.tax.bldg.BldgErrBldgListView;
import jp.co.ntt.common.service.tax.BldgUpdateBldgService;
import jp.co.ntt.webapp.controller.BaseController;

@RestController
public class BldgUpdateMasterRestController extends BaseController {

	@Autowired()
	private BldgUpdateBldgService bldgUpdateBldgService;

	@PostMapping(path = "/api/tax/bldg-update-bldg/find-data", consumes = MediaType.APPLICATION_JSON_VALUE)
	public TablePage<BldgErrBldgListView> getBldgErrBldgData(@RequestBody PaginationCriteria treq) {

		var paginator = new SimplePaginator<BldgErrBldgListView>(bldgUpdateBldgService);
		return paginator.getPage(treq);
	}

}
