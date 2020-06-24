package jp.co.ntt.webapp.controller.rest.tax;

import java.util.ArrayList;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jp.co.ntt.common.constant.TieUpErrWarnTypeDefinition;
import jp.co.ntt.common.datatablespagination.model.PaginationCriteria;
import jp.co.ntt.common.datatablespagination.model.TablePage;
import jp.co.ntt.common.datatablespagination.paginator.SimplePaginator;
import jp.co.ntt.common.dto.tax.bldg.AccountingPeriod;
import jp.co.ntt.common.dto.tax.bldg.BldgErrBldgListView;
import jp.co.ntt.common.dto.tax.bldg.BldgErrListUpdate;
import jp.co.ntt.common.dto.tax.bldg.BldgErrUpdate;
import jp.co.ntt.common.entity.fatpc.tax.master.BuildingOriginViewEntity;
import jp.co.ntt.common.service.tax.BldgErrDispatchService;
import jp.co.ntt.common.service.tax.BldgErrService;
import jp.co.ntt.common.service.tax.BuildingAfterCorrService;
import jp.co.ntt.common.service.tax.BuildingOriginService;
import jp.co.ntt.webapp.controller.BaseController;
import jp.co.ntt.webapp.controller.MessageValidate;

@RestController
public class BldgErrDispatchRestController extends BaseController {

	@Autowired()
	private BldgErrDispatchService bldgErrDispatchService;

	@Autowired()
	private BuildingOriginService buildingOriginService;

	@Autowired()
	private BuildingAfterCorrService buildingOriginAfterCorrService;

	@Autowired()
	private BldgErrService bldgErrService;

	@PostMapping(path = "/api/tax/bldg-err-dispatch/find-data")
	public TablePage<BldgErrBldgListView> getBldgErrBldgData(@RequestBody PaginationCriteria treq) {

		var paginator = new SimplePaginator<BldgErrBldgListView>(bldgErrDispatchService);
		return paginator.getPage(treq);
	}

	@PostMapping(path = "/api/tax/bldg-err-dispatch/find-bldg-origin")
	public TablePage<BuildingOriginViewEntity> getBldgErrBldgOrigin(@RequestBody PaginationCriteria treq) {
		var paginator = new SimplePaginator<BuildingOriginViewEntity>(buildingOriginService);
		return paginator.getPage(treq);
	}

	@PostMapping(path = "/api/tax/bldg-err-dispatch/find-bldg-after-corr")
	public TablePage<BuildingOriginViewEntity> getBldgErrBldgAfterCorr(@RequestBody PaginationCriteria treq) {

		var paginator = new SimplePaginator<BuildingOriginViewEntity>(buildingOriginAfterCorrService);
		return paginator.getPage(treq);
	}

	@PostMapping(path = "/api/tax/bldg-err-dispatch/update", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MessageValidate> updateBldgErrBldg(@Valid @RequestBody BldgErrListUpdate treq) {

		var listErrMsg = new ArrayList<String>();

		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();

		Set<ConstraintViolation<BldgErrListUpdate>> constraintViolations = validator.validate(treq);
		if (constraintViolations.size() > 0) {
			for (ConstraintViolation<BldgErrListUpdate> violation : constraintViolations) {
				listErrMsg.add(violation.getMessage());
			}
			return new ResponseEntity<MessageValidate>(new MessageValidate(listErrMsg), HttpStatus.BAD_REQUEST);
		}

		Set<ConstraintViolation<AccountingPeriod>> accConstraintViolations = validator.validate(treq.accPeriod);
		if (accConstraintViolations.size() > 0) {
			for (ConstraintViolation<AccountingPeriod> violation : accConstraintViolations) {
				listErrMsg.add(violation.getMessage());
			}
			return new ResponseEntity<MessageValidate>(new MessageValidate(listErrMsg), HttpStatus.BAD_REQUEST);

		}

		for (BldgErrUpdate bldg : treq.bldgErrList) {
			Set<ConstraintViolation<BldgErrUpdate>> bldgViolations = validator.validate(bldg);
			if (bldgViolations.size() > 0) {
				for (ConstraintViolation<BldgErrUpdate> violation : bldgViolations) {
					listErrMsg.add(violation.getMessage());
				}
				return new ResponseEntity<MessageValidate>(new MessageValidate(listErrMsg), HttpStatus.BAD_REQUEST);
			}
		}

		bldgErrService.updateBldgErrData(treq, TieUpErrWarnTypeDefinition.OTHER_DISPATCH);

		return ResponseEntity.ok().build();

	}

}
