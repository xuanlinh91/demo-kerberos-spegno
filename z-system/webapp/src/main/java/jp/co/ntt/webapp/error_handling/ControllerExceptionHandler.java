package jp.co.ntt.webapp.error_handling;

import jp.co.ntt.common.dto.response.CommonResponse;
import jp.co.ntt.common.exception.ContractRegistrationNumberNullException;
import jp.co.ntt.common.exception.FiscalPeriodNullException;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.io.UnsupportedEncodingException;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler({UnsupportedEncodingException.class})
    public ResponseEntity<CommonResponse<String>> UnsupportedEncodingExceptionHandler(Exception e) {
        logger.debug(e.toString());
        e.printStackTrace();
        CommonResponse<String> response = new CommonResponse<>("error", "Invalid parameter");
        return new ResponseEntity<>(response, HttpStatus.SERVICE_UNAVAILABLE);
    }

    @ExceptionHandler({IllegalArgumentException.class})
    public ResponseEntity<CommonResponse<String>> IllegalArgumentExceptionHandler(Exception e) {
        logger.debug(e.toString());
        e.printStackTrace();
        CommonResponse<String> response = new CommonResponse<>("error", "Invalid parameter");
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({ConstraintViolationException.class})
    public ResponseEntity<CommonResponse<String>> ConstraintViolationExceptionHandler(Exception e) {
        logger.debug(e.toString());
        e.printStackTrace();
        CommonResponse<String> response = new CommonResponse<>("error", "Invalid parameter");
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConversionFailedException.class)
    public ResponseEntity<CommonResponse<String>> ConversionFailedExceptionHander(Exception e) {
        logger.debug(e.toString());
        e.printStackTrace();
        CommonResponse<String> response = new CommonResponse<>("error", "Invalid parameter");
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NumberFormatException.class)
    public ResponseEntity<CommonResponse<String>> NumberFormatExceptionHander(Exception e) {
        logger.debug(e.toString());
        e.printStackTrace();
        CommonResponse<String> response = new CommonResponse<>("error", "Invalid parameter");
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ContractRegistrationNumberNullException.class)
    public ResponseEntity<CommonResponse<String>> ContractRegistrationNumberNullExceptionHandler(ContractRegistrationNumberNullException e) {
        logger.debug(e.toString());
        e.printStackTrace();
        CommonResponse<String> response = new CommonResponse<>("error", "帳票は契約登録番号ありません。帳票ID: "
                + e.getAccountingReportDataId());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(FiscalPeriodNullException.class)
    public ResponseEntity<CommonResponse<String>> FiscalPeriodNullExceptionHandler(FiscalPeriodNullException e) {
        logger.debug(e.toString());
        e.printStackTrace();
        CommonResponse<String> response = new CommonResponse<>("error", "帳票は会計期間ありません。帳票ID: "
                + e.getAccountingReportDataId());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
