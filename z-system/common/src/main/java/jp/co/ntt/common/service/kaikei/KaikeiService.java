package jp.co.ntt.common.service.kaikei;

import jp.co.ntt.common.dto.kaikei.incomplete.*;
import jp.co.ntt.common.dto.kaikei.unaccepted.UnacceptedItem;
import jp.co.ntt.common.dto.request.datatable.accounting.DataTableCriteria;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface KaikeiService {
    /**
     * 定額取引（自社請求側）フィールダーリング
     * @param dataTableCriteria 絞り込み
     * @return Page<IncompleteItem> 未完了ページ
     */
    Page<IncompleteItem> searchIncompleteFlatRateTraInHbsList(DataTableCriteria dataTableCriteria);

    /**
     * 定額取引（自社支払い側）フィールダーリング
     * @param dataTableCriteria 絞り込み
     * @return Page<IncompleteItem> 未完了ページ
     */
    Page<IncompleteItem> searchIncompleteFlatRateTraOwnList(DataTableCriteria dataTableCriteria);

    /**
     * 個別取引（自社請求側）フィールダーリング
     * @param dataTableCriteria 絞り込み
     * @return Page<IncompleteItem> 未完了ページ
     */
    Page<IncompleteItem> searchIncompleteIdvRateTraInHbsList(DataTableCriteria dataTableCriteria);

    /**
     * 個別取引（自社支払い側）フィールダーリング
     * @param dataTableCriteria 絞り込み
     * @return Page<IncompleteItem> 未完了ページ
     */
    Page<IncompleteItem> searchIncompleteIdvRateTraOwnPsList(DataTableCriteria dataTableCriteria);

    /**
     * 未検収未承認フィールダーリング
     * @param dataTableCriteria 絞り込み
     * @return Page<UnacceptedItem> 未検収未承認ページ
     */
    Page<UnacceptedItem> searchUnacceptedList(DataTableCriteria dataTableCriteria);
}
