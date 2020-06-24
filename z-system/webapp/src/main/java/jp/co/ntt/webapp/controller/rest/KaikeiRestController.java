package jp.co.ntt.webapp.controller.rest;

import jp.co.ntt.common.datatablespagination.paginator.accounting.SimplePaginator;
import jp.co.ntt.common.dto.kaikei.incomplete.*;
import jp.co.ntt.common.dto.kaikei.unaccepted.UnacceptedItem;
import jp.co.ntt.common.dto.kaikei.unaccepted.UnacceptedProgressData;
import jp.co.ntt.common.dto.request.datatable.accounting.DataTableCriteria;
import jp.co.ntt.common.dto.response.datatable.DataTableResponse;
import jp.co.ntt.common.dto.response.CommonResponse;
import jp.co.ntt.common.service.kaikei.*;
import jp.co.ntt.webapp.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.security.Principal;
import java.time.LocalDateTime;

import static jp.co.ntt.common.constant.Constants.*;

@RestController
public class KaikeiRestController extends BaseController<KaikeiService> {
    @Autowired
    KaikeiService kaikeiService;

    @Autowired
    IncompleteService incompleteService;

    @Autowired
    IncompleteServiceImpl incompleteServiceImpl;

    @Autowired
    UnacceptedService unacceptedService;

    @Autowired
    UnacceptedServiceImpl unacceptedServiceImpl;

    @PostMapping(path = "/api/incomplete/FlatRateTraInHbs")
    public DataTableResponse<IncompleteItem> getIncompleteFlatRateTraInHbs(@RequestBody DataTableCriteria datatableCriteria) {
        SimplePaginator<IncompleteItem> simplePaginator = new SimplePaginator<>(incompleteServiceImpl);

        return simplePaginator.getPage(datatableCriteria);
    }

    @PostMapping("/api/incomplete/FlatRateTraOwn")
    public DataTableResponse<IncompleteItem> getIncompleteFlatRateTraOwn(@RequestBody DataTableCriteria datatableCriteria) {
        SimplePaginator<IncompleteItem> simplePaginator = new SimplePaginator<>(incompleteServiceImpl);

        return simplePaginator.getPage(datatableCriteria);
    }

    @PostMapping("/api/incomplete/IdvRateTraInHbs")
    public DataTableResponse<IncompleteItem> getIncompleteListIdvRateTraInHbs(@RequestBody DataTableCriteria datatableCriteria) {
        SimplePaginator<IncompleteItem> simplePaginator = new SimplePaginator<>(incompleteServiceImpl);

        return simplePaginator.getPage(datatableCriteria);
    }

    @PostMapping("/api/incomplete/IdvRateTraOwnPs")
    public DataTableResponse<IncompleteItem> getIncompleteIdvRateTraOwnPsList(@RequestBody DataTableCriteria datatableCriteria) {
        SimplePaginator<IncompleteItem> simplePaginator = new SimplePaginator<>(incompleteServiceImpl);

        return simplePaginator.getPage(datatableCriteria);
    }

    @PutMapping("/api/incomplete/{id}")
    public ResponseEntity<CommonResponse<String>> saveIncompleteProgressData(@Valid @RequestBody IncompleteProgressData progressData,
                                                                       @PathVariable("id") Integer id, Principal principal) {
        progressData.setAccountingReportDataId(id);
        progressData.setUpdateUser(principal.getName());
        incompleteService.saveIncompleteProgressData(progressData);

//        Todo update response message here
        return response(EMPTY_STRING);
    }

    @PostMapping(path = "/api/unaccepted")
    public DataTableResponse<UnacceptedItem> getUnaccepted(@RequestBody DataTableCriteria datatableCriteria) {
        SimplePaginator<UnacceptedItem> simplePaginator = new SimplePaginator<>(unacceptedServiceImpl);

        return simplePaginator.getPage(datatableCriteria);
    }

    @PutMapping("/api/unaccepted/{id}")
    public ResponseEntity<CommonResponse<String>> saveUnacceptedProgressData(@Valid @RequestBody UnacceptedProgressData progressData,
                                                                             @PathVariable("id") Integer id) {
        progressData.setAccountingReportDataId(id);
        unacceptedService.saveUnacceptedProgressData(progressData);

        return response(EMPTY_STRING);
    }
}
