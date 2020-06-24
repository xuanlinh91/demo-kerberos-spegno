package jp.co.ntt.common.dto.kaikei.unaccepted;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class UnacceptedReport {

    /**
     * 会計用データID
     */
    private Integer accountingReportDataId;

    /**
     * 帳票ID
     */
    private Integer reportId;

    /**
     * サブ帳票番号
     */
    private Integer subReportNo;

    /**
     * 会計組織名
     */
    private String accountingOrgName;

    /**
     * 会計組織コード
     */
    private String accountingOrgCode;

    /**
     * 部課コード
     */
    private String depaCode;

    /**
     * 部課名
     */
    private String depaName;

    /**
     * 伝票作成者
     */
    private String slipCreator;

    /**
     * 所属
     */
    private String assignment;

    /**
     * 電話番号
     */
    private String phoneNumber;

    /**
     * 検収年月日
     */
    private String inscriptionYearMonthDay;

    /**
     * 	伝票番号
     */
    private String salesSlipNumber;

    /**
     * 伝票摘要
     */
    private String slipDescription;

    /**
     * 取引金額
     */
    private Long traAmt;

    /**
     * データ種別詳細名
     */
    private String dataTypeDetailedName;

    /**
     * 伝票種別
     */
    private String slipType;

    /**
     * 	取引先コード
     */
    private String customerCode;

    /**
     * 取引先名
     */
    private String traName;

    /**
     * メールアドレス
     */
    private String mailAddress;

    /**
     * アドレスビット
     */
    private String addressBit;

    /**
     * 資料年月
     */
    private String referenceDate;

    /**
     * データ種別コード
     */
    private String dataTypeCode;

    /**
     * 	データ種別詳細コード
     */
    private String dataTypeDetailedCode;

    /**
     * キー(管理番号)
     */
    private String managementNumber;

    /**
     * 部課マスタ情報
     */
    private String departmentMasterInfo;

    /**
     * 未検収・未承認データ年月日
     */
    private String unacceptedDataDate;

    /**
     * 契約登録番号
     */
    private String contractRegistrationNumber;

    /**
     * 氏名コード
     */
    @JsonIgnore
    private String nameCode;

    /**
     * 年度
     */
    @JsonIgnore
    private Integer fiscalYear;

    /**
     * 会計期間区分
     */
    @JsonIgnore
    private Integer fiscalPeriodType;

    /**
     * 会計期間
     */
    @JsonIgnore
    private String fiscalPeriod;

    /**
     * 対象組織
     */
    @JsonIgnore
    private String reportOrg;

    /**
     * データ期間
     */
    @JsonIgnore
    private String dataPeriod;

    /**
     * 増分フラグ
     */
    @JsonIgnore
    private Integer incrementalFlag;
}