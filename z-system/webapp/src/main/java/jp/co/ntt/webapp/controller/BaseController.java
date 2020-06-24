package jp.co.ntt.webapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

//import jp.co.ntt.common.service.BaseService;
import jp.co.ntt.common.dto.response.CommonResponse;

public abstract class BaseController<T> {
//    @Autowired
//    BaseService<T> baseService;

	public Logger logger = LoggerFactory.getLogger(this.getClass());

	public <Y> ResponseEntity<CommonResponse<Y>> response(Y data) {
		CommonResponse<Y> response = new CommonResponse<>("success", data);

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
