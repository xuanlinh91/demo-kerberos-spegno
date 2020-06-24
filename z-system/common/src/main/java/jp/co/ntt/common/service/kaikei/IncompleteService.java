package jp.co.ntt.common.service.kaikei;

import jp.co.ntt.common.dto.kaikei.incomplete.*;
import jp.co.ntt.common.dto.kaikei.master.*;
import jp.co.ntt.common.dto.request.datatable.accounting.DataTableCriteria;
import jp.co.ntt.common.entity.kaikei.incomplete.IncompleteReportDataEntity;
import jp.co.ntt.common.entity.kaikei.report.AccountingReportEntity;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface IncompleteService {
    /**
     * G間リスト絞り込む
     * @param dataTableCriteria 絞り込み
     * @return 帳票ページ
     */
    Page<AccountingReportEntity> searchIncompletePage(DataTableCriteria dataTableCriteria);

    /**
     * G間リスト取得
     * @param subReportNo サブ帳票ID
     * @return 帳票リスト
     */
    List<AccountingReportEntity> getLatestIncompleteList(Integer subReportNo, String fiscalPeriod);

    /**
     * 一般敵にエリア別マスタ(会計組織)を反映
     * @param incompleteList G間リスト
     * @param dialAreaMaster エリアマスタ
     * @return G間リスト取得
     */
    IncompleteList applyDialAreaMasterData(IncompleteList incompleteList, DialAreaMaster dialAreaMaster);

    /**
     * アイテムにエリアマスタデータを反映
     * @param incompleteItem G間リスト
     * @param dialAreaMaster エリアマスタ
     * @return G間リスト取得
     */
    IncompleteItem applyDialAreaMasterData(IncompleteItem incompleteItem, DialAreaMaster dialAreaMaster);

    /**
     * 連絡先マスタを反映
     *
     * @param incompleteList G間リスト
     * @param contactInfoReplacementMaster 担当者情報置き換えマスタ
     * @return G間リスト取得
     */
    IncompleteList applyContactData(IncompleteList incompleteList, ContactInfoReplacementMaster contactInfoReplacementMaster);

    /**
     * アイテムにエリアマスタデータを反映
     * @param incompleteItem G間リスト
     * @param contactInfoReplacementMaster 担当者情報置き換えマスタ
     * @return
     */
    IncompleteItem applyContactData(IncompleteItem incompleteItem, ContactInfoReplacementMaster contactInfoReplacementMaster);

    /**
     * 処理案内マスタを反映
     *
     * @param incompleteList G間リスト
     * @param processingGuideMaster 処理案内マスタ
     * @return G間リスト取得
     */
    IncompleteList applyProcessingGuideData(IncompleteList incompleteList, ProcessingGuideMaster processingGuideMaster);

    /**
     * アイテムにエリアマスタデータを反映
     * @param incompleteItem G間リスト
     * @param processingGuideMaster 処理案内マスタ
     * @return G間リスト取得
     */
    IncompleteItem applyProcessingGuideData(IncompleteItem incompleteItem, ProcessingGuideMaster processingGuideMaster);

    /**
     * エリア別マスタ(電話番号)を反映
     *
     * @param incompleteList G間リスト
     * @param organizationMaster 組織マスタ尾
     * @return G間リスト取得
     */
    IncompleteList applyOrganizationMasterData(IncompleteList incompleteList, OrganizationMaster organizationMaster);

    /**
     * アイテムにエリアマスタデータを反映
     * @param incompleteItem G間リスト取得
     * @param organizationMaster エリア別マスタ
     * @return G間リスト取得
     */
    IncompleteItem applyOrganizationMasterData(IncompleteItem incompleteItem, OrganizationMaster organizationMaster);

    /**
     * エリア別マスタ(電話番号)を反映
     *
     * @param incompleteList G間リスト
     * @param nonParticipatingCompanyMaster 非参画会社マスタデータ
     * @return G間リスト取得
     */
    IncompleteList applyNonParticipatingCompanyData(IncompleteList incompleteList, NonParticipatingCompanyMaster nonParticipatingCompanyMaster);

    /**
     * アイテムにエリアマスタデータを反映
     * @param incompleteItem G間リスト
     * @param nonParticipatingCompanyMaster 非参画会社マスタデータ
     * @return G間リスト取得
     */
    IncompleteItem applyNonParticipatingCompanyData(IncompleteItem incompleteItem, NonParticipatingCompanyMaster nonParticipatingCompanyMaster);

    /**
     * 前日の個別管理用データを反映
     *
     * @param incompleteList G間リスト取得
     * @return G間リスト取得
     */
    IncompleteList applyPreviousProcessingData(IncompleteList incompleteList);

    /**
     *　進捗データ付与
     * @param incompleteItem G間リスト
     * @return G間リスト取得
     */
    IncompleteItem applyPreviousProcessingData(IncompleteItem incompleteItem);

    /**
     * データを自社担当者メールアドレスに分ける
     *
     * @param incompleteList G間リスト
     * @return G間リスト取得
     */
    Map<String, IncompleteList> divideByMailAddress(IncompleteList incompleteList);

    /**
     * 進捗データ保存
     * @param progressData 進捗データ
     * @return G間リスト取得
     */
    IncompleteReportDataEntity saveIncompleteProgressData(IncompleteProgressData progressData);

    /**
     * 定額取引（自社請求側）報告書作成用
     * @param fiscalPeriod 会計期間
     * @return IncompleteList G間未完了
     */
    IncompleteList getIncompleteFlatRateTraInHbsList(String fiscalPeriod);

    /**
     * 定額取引（自社支払い側）報告書作成用
     * @param fiscalPeriod 会計期間
     * @return IncompleteList G間未完了
     */
    IncompleteList getIncompleteFlatRateTraOwnList(String fiscalPeriod);

    /**
     * 個別取引（自社請求側）報告書作成用
     * @param fiscalPeriod 会計期間
     * @return IncompleteList G間未完了
     */
    IncompleteList getIncompleteIdvRateTraInHbsList(String fiscalPeriod);

    /**
     * 個別取引（自社支払い側）報告書作成用
     * @param fiscalPeriod 会計期間
     * @return IncompleteList G間未完了
     */
    IncompleteList getIncompleteIdvRateTraOwnPsList(String fiscalPeriod);
}
