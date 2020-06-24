package jp.co.ntt.common.service.kaikei;

import jp.co.ntt.common.dto.kaikei.master.*;
import jp.co.ntt.common.dto.kaikei.unaccepted.UnacceptedItem;
import jp.co.ntt.common.dto.kaikei.unaccepted.UnacceptedList;
import jp.co.ntt.common.dto.kaikei.unaccepted.UnacceptedProgressData;
import jp.co.ntt.common.dto.request.datatable.accounting.DataTableCriteria;
import jp.co.ntt.common.entity.kaikei.report.AccountingReportEntity;
import jp.co.ntt.common.entity.kaikei.unaccepted.UnacceptedReportDataEntity;
import jp.co.ntt.common.exception.ContractRegistrationNumberNullException;
import jp.co.ntt.common.exception.FiscalPeriodNullException;
import jp.co.ntt.common.exception.SalesSlipNumberNullException;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface UnacceptedService {
    /**
     *
     * @return 未検収・未承認リスト
     */
    UnacceptedList getCurrentUnacceptedList(String fiscalPeriod);

    /**
     *
     * @return 未検収・未承認リスト
     */
    Page<AccountingReportEntity> searchUnacceptedList(DataTableCriteria dataTableCriteria);

    /**
     * 前日の個別管理用データを反映
     *
     * @param
     * @param
     * @return 未検収・未承認リスト
     */
    UnacceptedList applyPreviousProcessingData(UnacceptedList unacceptedList);
    UnacceptedItem applyPreviousProcessingData(UnacceptedItem unacceptedItem);

    /**
     * 
     * @param '未検収・未承認リスト
     * @return 未検収・未承認リスト
     */
    UnacceptedList applyEmployeeData(UnacceptedList unacceptedList, EmployeeMaster employeeMaster, DepaDataMaster depaDataMaster, AccountingOrgMaster accountingOrgMaster);

    UnacceptedItem applyEmployeeData(UnacceptedItem unacceptedItem, EmployeeMaster employeeMaster, DepaDataMaster depaDataMaster, AccountingOrgMaster accountingOrgMaster);

    /**
     *
     * @param '未検収・未承認リスト
     * @return 未検収・未承認リスト
     */
    UnacceptedList applyAddressBitMasterData(UnacceptedList unacceptedList, AddressBitMaster addressBitMaster);
    UnacceptedItem applyAddressBitMasterData(UnacceptedItem unacceptedItem, AddressBitMaster addressBitMaster);

    /**
     *
     * @param '未検収・未承認リスト
     * @return 未検収・未承認リスト
     */
    UnacceptedList applyDepartmentMasterData(UnacceptedList unacceptedList, DepartmentMaster departmentMaster);
    UnacceptedItem applyDepartmentMasterData(UnacceptedItem unacceptedItem, DepartmentMaster departmentMaster);

    /**
     * 伝票番号データ付与
     * @param '未検収・未承認リスト
     * @return 未検収・未承認リスト 未検収・未承認リスト
     */
    UnacceptedList applySlipNumberMasterData(UnacceptedList unacceptedList, SlipNumberMaster slipNumberMaster);
    UnacceptedItem applySlipNumberMasterData(UnacceptedItem unacceptedItem, SlipNumberMaster slipNumberMaster);

    /**
     * 
     * @param '未検収・未承認リスト
     * @return 未検収・未承認リスト
     */
    UnacceptedList updateSuppliersData(UnacceptedList unacceptedList);
    UnacceptedItem updateSuppliersData(UnacceptedItem unacceptedItem);

    /**
     *
     * @param progressData
     */
    UnacceptedReportDataEntity saveUnacceptedProgressData(UnacceptedProgressData progressData);

}
