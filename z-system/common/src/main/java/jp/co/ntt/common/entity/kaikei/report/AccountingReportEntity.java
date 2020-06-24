package jp.co.ntt.common.entity.kaikei.report;

import lombok.Data;
import org.springframework.data.annotation.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Entity
@Immutable
@Table(name = "TD_AccountingReportData")
public class AccountingReportEntity {

    /**
     * 会計用データID
     */
    @Id
    @NotNull
    @Column(name = "accounting_report_data_id")
    private Integer accountingReportDataId;

    /**
     * 帳票ID
     */
    @Column(name = "report_id")
    @NotNull
    private Integer reportId;

    /**
     * サブ帳票番号
     */
    @Column(name = "sub_report_no")
    @NotNull
    private Integer subReportNo;

    /**
     * 年度
     */
    @Column(name = "fiscal_year")
    private Integer fiscalYear;

    /**
     * 会計期間区分
     */
    @Column(name = "fiscal_period_type")
    private Integer fiscalPeriodType;

    /**
     * 会計期間
     */
    @Column(name = "fiscal_period")
    private String fiscalPeriod;

    /**
     * 対象組織
     */
    @Column(name = "report_org")
    private String reportOrg;

    /**
     * データ期間
     */
    @Column(name = "data_period")
    private String dataPeriod;

    /**
     * 増分フラグ
     */
    @Column(name = "incremental_flag")
    @NotNull
    private Integer incrementalFlag;

    /**
     * バージョン
     */
    @Column(name = "version")
    @NotNull
    private Integer version;

    /**
     * ファイル作成日時
     */
    @Column(name = "file_created_datetime")
    private LocalDateTime fileCreatedDatetime;

    /**
     * ファイル更新日時
     */
    @Column(name = "file_lastmodified_datetime")
    private LocalDateTime fileLastModifiedDatetime;

    /**
     * 資料年月
     */
    @Column(name = "reference_date")
    private String referenceDate;

    /**
     * 会計組織コード
     */
    @Column(name = "accounting_org_code")
    private String accountingOrgCode;

    /**
     * 会計組織名
     */
    @Column(name = "accounting_org_name")
    private String accountingOrgName;

    /**
     * 部課コード
     */
    @Column(name = "depa_code")
    private String depaCode;

    /**
     * 部課名
     */
    @Column(name = "depa_name")
    private String depaName;

    /**
     * データ種別コード
     */
    @Column(name = "data_type_code")
    private String dataTypeCode;

    /**
     * データ種別名
     */
    @Column(name = "data_type_name")
    private String dataTypeName;

    /**
     * 	データ種別詳細コード
     */
    @Column(name = "data_type_detailed_code")
    private String dataTypeDetailedCode;

    /**
     * データ種別詳細名
     */
    @Column(name = "data_type_detailed_name")
    private String dataTypeDetailedName;

    /**
     * 	伝票番号
     */
    @Column(name = "sales_slip_number")
    private String salesSlipNumber;

    /**
     * 伝票摘要
     */
    @Column(name = "slip_description")
    private String slipDescription;

    /**
     * 検収年月日
     */
    @Column(name = "inspection_year_month_day")
    private String inscriptionYearMonthDay;

    /**
     * 	取引先コード
     */
    @Column(name = "customer_code")
    private String customerCode;

    /**
     * 取引先名
     */
    @Column(name = "tra_name")
    private String traName;


    /**
     * 取引金額
     */
    @Column(name = "tra_amt")
    private Long traAmt;

    /**
     * 処理年月日
     */
    @Column(name = "proc_year_month_day")
    private String procYearMonthDay;

    /**
     * 備考1
     */
    @Column(name = "remarks_1")
    private String remarks1;

    /**
     * 備考2
     */
    @Column(name = "remarks_2")
    private String remarks2;

    /**
     * 備考3
     */
    @Column(name = "remarks_3")
    private String remarks3;

    /**
     * 備考4
     */
    @Column(name = "remarks_4")
    private String remarks4;

    /**
     * 備考5
     */
    @Column(name = "remarks_5")
    private String remarks5;

    /**
     * 備考6
     */
    @Column(name = "remarks_6")
    private String remarks6;

    /**
     * 備考7
     */
    @Column(name = "remarks_7")
    private String remarks7;

    /**
     * 備考8
     */
    @Column(name = "remarks_8")
    private String remarks8;

    /**
     * 備考9
     */
    @Column(name = "remarks_9")
    private String remarks9;

    /**
     * 備考10
     */
    @Column(name = "remarks_10")
    private String remarks10;

    /**
     * 定額取引（自社請求側）_ステータス
     */
    @Column(name = "flat_rate_tra_in_h_b_s_status")
    private String flatRateTraInHbsStatus;

    /**
     * 定額取引（自社請求側）_自会社名※請求側
     */
    @Column(name = "flat_rate_tra_in_h_b_s_own_company_name_bldging")
    private String flatRateTraInHbsOwnCompanyNameBldging;

    /**
     * 定額取引（自社請求側）_相手会社名
     */
    @Column(name = "flat_rate_tra_in_h_b_s_other_company_name")
    private String flatRateTraInHbsOtherCompanyName;

    /**
     * 定額取引（自社請求側）_契約登録番号
     */
    @Column(name = "flat_rate_tra_in_h_b_s_contract_registration_number")
    private String flatRateTraInHbsContractRegistrationNumber;

    /**
     * 定額取引（自社請求側）_契約件名
     */
    @Column(name = "flat_rate_tra_in_h_b_s_contract_sbj")
    private String flatRateTraInHbsContractSbj;

    /**
     * 定額取引（自社請求側）_請求側組織コード
     */
    @Column(name = "flat_rate_tra_in_h_b_s_bldging_side_org_code")
    private String flatRateTraInHbsBldgingSideOrgCode;

    /**
     * 定額取引（自社請求側）_請求側組織名
     */
    @Column(name = "flat_rate_tra_in_h_b_s_bldging_side_org_name")
    private String flatRateTraInHbsBldgingSideOrgName;

    /**
     * 定額取引（自社請求側）_請求側部課コード
     */
    @Column(name = "flat_rate_tra_in_h_b_s_bldging_side_section_code")
    private String flatRateTraInHbsBldgingSideSectionCode;

    /**
     * 定額取引（自社請求側）_請求側部課名
     */
    @Column(name = "flat_rate_tra_in_h_b_s_bldging_side_section_name")
    private String flatRateTraInHbsBldgingSideSectionName;

    /**
     * 定額取引（自社請求側）_支払側組織コード
     */
    @Column(name = "flat_rate_tra_in_h_b_s_paying_side_org_code")
    private String flatRateTraInHbsPayingSideOrgCode;

    /**
     * 定額取引（自社請求側）_支払側組織名
     */
    @Column(name = "flat_rate_tra_in_h_b_s_paying_org_name")
    private String flatRateTraInHbsPayingOrgName;

    /**
     * 定額取引（自社請求側）_支払側部課コード
     */
    @Column(name = "flat_rate_tra_in_h_b_s_payment_section_code")
    private String flatRateTraInHbsPaymentSectionCode;

    /**
     * 定額取引（自社請求側）_支払側部課名
     */
    @Column(name = "flat_rate_tra_in_h_b_s_paying_side_section_name")
    private String flatRateTraInHbsPayingSideSectionName;

    /**
     * 定額取引（自社請求側）_接続日
     */
    @Column(name = "flat_rate_tra_in_h_b_s_cnt_date")
    private String flatRateTraInHbsCntDate;

    /**
     * 定額取引（自社請求側）_初回請求金額
     */
    @Column(name = "flat_rate_tra_in_h_b_s_first_bldging_amt")
    private Long flatRateTraInHbsFirstBldgingAmt;

    /**
     * 定額取引（自社請求側）_例月請求金額
     */
    @Column(name = "flat_rate_tra_in_h_b_s_monthly_bldging_amt")
    private Long flatRateTraInHbsMonthlyBldgingAmt;

    /**
     * 定額取引（自社請求側）_終回請求金額
     */
    @Column(name = "flat_rate_tra_in_h_b_s_last_bldging_amt")
    private Long flatRateTraInHbsLastBldgingAmt;

    /**
     * 定額取引（自社請求側）_相手担当者
     */
    @Column(name = "flat_rate_tra_in_h_b_s_contact_person")
    private String flatRateTraInHbsContactPerson;

    /**
     * 定額取引（自社請求側）_相手担当者電話番号
     */
    @Column(name = "flat_rate_tra_in_h_b_s_tel")
    private String flatRateTraInHbsTel;

    /**
     * 定額取引（自社請求側）_相手担当者メールアドレス
     */
    @Column(name = "flat_rate_tra_in_h_b_s_contact_person_email_address")
    private String flatRateTraInHbsContactPersonEmailAddress;

    /**
     * 定額取引（自社請求側）_自社担当者
     */
    @Column(name = "flat_rate_tra_in_h_b_s_in_house_contact")
    private String flatRateTraInHbsInHouseContact;

    /**
     * 定額取引（自社請求側）_自社担当者電話番号
     */
    @Column(name = "flat_rate_tra_in_h_b_s_in_house_contact_tel")
    private String flatRateTraInHbsInHouseContactTel;

    /**
     * 定額取引（自社請求側）_自社担当者メールアドレス
     */
    @Column(name = "flat_rate_tra_in_h_b_s_e_mail_address")
    private String flatRateTraInHbsEmailAddress;

    /**
     * 定額取引（自社請求側）_請求側初回検収接続状態
     */
    @Column(name = "flat_rate_tra_in_h_b_s_bldging_side_acpt_cnt_status")
    private String flatRateTraInHbsBldgingSideAcptCntStatus;

    /**
     * 定額取引（自社請求側）_支払側初回検収接続状態
     */
    @Column(name = "flat_rate_tra_in_h_b_s_payment_side_acpt_cnt_status")
    private String flatRateTraInHbsPaymentSideAcptCntStatus;

    /**
     * 定額取引（自社請求側）_接続日からの経過日数
     */
    @Column(name = "flat_rate_tra_in_h_b_s_days_since_cnt_date")
    private String flatRateTraInHbsDaysSinceCntDate;

    /**
     * 定額取引（自社支払側）_ステータス
     */
    @Column(name = "flat_rate_tra_own_p_s_status")
    private String flatRateTraOwnPsStatus;

    /**
     * 定額取引（自社支払側）_自会社名※支払側
     */
    @Column(name = "flat_rate_tra_own_p_s_own_company_name_payment_side")
    private String flatRateTraOwnPsOwnComanyNamePaymentSide;

    /**
     * 定額取引（自社支払側）_相手会社名
     */
    @Column(name = "flat_rate_tra_own_p_s_other_company_name")
    private String flatRateTraOwnPsOtherCompanyName;

    /**
     * 定額取引（自社支払側）_契約登録番号
     */
    @Column(name = "flat_rate_tra_own_p_s_contract_registration_number")
    private String flatRateTraOwnPsContractRegistrationNumber;

    /**
     * 定額取引（自社支払側）_契約件名
     */
    @Column(name = "flat_rate_tra_own_p_s_contract_sbj")
    private String flatRateTraOwnPsContractSbj;

    /**
     * 定額取引（自社支払側）_請求側組織コード
     */
    @Column(name = "flat_rate_tra_own_p_s_bldging_side_org_code")
    private String flatRateTraOwnPsBldgingSideOrgCode;

    /**
     * 定額取引（自社支払側）_請求側組織名
     */
    @Column(name = "flat_rate_tra_own_p_s_bldging_side_org_name")
    private String flatRateTraOwnPsBldgingSideOrgName;

    /**
     * 定額取引（自社支払側）_請求側部課コード
     */
    @Column(name = "flat_rate_tra_own_p_s_bldging_side_section_code")
    private String flatRateTraOwnPsBldgingSideSectionCode;

    /**
     * 定額取引（自社支払側）_請求側部課名
     */
    @Column(name = "flat_rate_tra_own_p_s_bldging_section_name")
    private String flatRateTraOwnPsBldgingSectionName;

    /**
     * 定額取引（自社支払側）_支払側組織コード
     */
    @Column(name = "flat_rate_tra_own_p_s_payer_org_code")
    private String flatRateTraOwnPsPayerOrgCode;

    /**
     * 定額取引（自社支払側）_支払側組織名
     */
    @Column(name = "flat_rate_tra_own_p_s_paying_org_name")
    private String flatRateTraOwnPsPayingOrgName;

    /**
     * 定額取引（自社支払側）_支払側部課コード
     */
    @Column(name = "flat_rate_tra_own_p_s_payment_depa_code")
    private String flatRateTraOwnPsPaymentDepaCode;

    /**
     * 定額取引（自社支払側）_支払側部課名
     */
    @Column(name = "flat_rate_tra_own_p_s_payment_depa_name")
    private String flatRateTraOwnPsPaymentDepaName;

    /**
     * 定額取引（自社支払側）_接続日
     */
    @Column(name = "flat_rate_tra_own_p_s_cnt_date")
    private String flatRateTraOwnPsCntDate;

    /**
     * 定額取引（自社支払側）_初回請求金額
     */
    @Column(name = "flat_rate_tra_own_p_s_initial_billing_amt")
    private Long flatRateTraOwnPsInitialBillingAmt;

    /**
     * 定額取引（自社支払側）_例月請求金額
     */
    @Column(name = "flat_rate_tra_own_p_s_monthly_billing_amt")
    private Long flatRateTraOwnPsMonthlyBillingAmt;

    /**
     * 定額取引（自社支払側）_終回請求金額
     */
    @Column(name = "flat_rate_tra_own_p_s_final_charge_amt")
    private Long flatRateTraOwnPsFinalChargeAmt;

    /**
     * 定額取引（自社支払側）_相手担当者
     */
    @Column(name = "flat_rate_tra_own_p_s_contact_person")
    private String flatRateTraOwnPsContactPerson;

    /**
     * 定額取引（自社支払側）_相手担当者電話番号
     */
    @Column(name = "flat_rate_tra_own_p_s_contact_person_tel")
    private String flatRateTraOwnPsContactPersonTel;

    /**
     * 定額取引（自社支払側）_相手担当者メールアドレス
     */
    @Column(name = "flat_rate_tra_own_p_s_contact_person_tel_mail_address")
    private String flatRateTraOwnPsContactPersonTelMailAddress;

    /**
     * 定額取引（自社支払側）_自社担当者
     */
    @Column(name = "flat_rate_tra_own_p_s_own_contact_person")
    private String flatRateTraOwnPsOwnContactPerson;

    /**
     * 定額取引（自社支払側）_自社担当者電話番号
     */
    @Column(name = "flat_rate_tra_own_p_s_own_contact_person_tel")
    private String flatRateTraOwnPsOwnContactPersonTel;

    /**
     * 定額取引（自社支払側）_自社担当者メールアドレス
     */
    @Column(name = "flat_rate_tra_own_payment_own_contact_person_tel_mail_address")
    private String flatRateTraOwnPaymentOwnContactPersonTelMailAddress;

    /**
     * 定額取引（自社支払側）_請求側初回検収接続状態
     */
    @Column(name = "flat_rate_tra_own_p_s_billing_initial_acpt_cnt_status")
    private String flatRateTraOwnPsBillingInitialAcptCntStatus;

    /**
     * 定額取引（自社支払側）_支払側初回検収接続状態
     */
    @Column(name = "flat_rate_tra_own_p_s_payment_side_first_chk_cnt_state")
    private String flatRateTraOwnPsPaymentSideFirstChkCntState;

    /**
     * 定額取引（自社支払側）_接続日からの経過日数
     */
    @Column(name = "flat_rate_tra_own_p_s_payment_side_cnt_day_progress_days")
    private String flatRateTraOwnPsPaymentSideCntDayProgressDay;

    /**
     * 個別取引（自社請求側）_ステータス
     */
    @Column(name = "idv_rate_tra_in_h_b_s_status")
    private String idvRateTraInHbsStatus;

    /**
     * 個別取引（自社請求側）_突合候補
     */
    @Column(name = "idv_rate_tra_in_h_b_s_synapse")
    private String idvRateTraInHbsSynapse;

    /**
     * 個別取引（自社請求側）_自会社名※請求側
     */
    @Column(name = "idv_rate_tra_in_h_b_s_own_company_name_bldging_side")
    private String idvRateTraInHbsOwnCompanyNameBldgingSide;

    /**
     * 個別取引（自社請求側）_相手会社名
     */
    @Column(name = "idv_rate_tra_in_h_b_s_other_company_name")
    private String idvRateTraInHbsOtherCompanyName;

    /**
     * 個別取引（自社請求側）_契約登録番号
     */
    @Column(name = "idv_rate_tra_in_h_b_s_contract_registration_number")
    private String idvRateTraInHbsContractRegistrationNumber;

    /**
     * 個別取引（自社請求側）_契約件名
     */
    @Column(name = "idv_rate_tra_in_h_b_s_contract_sbj")
    private String idvRateTraInHbsContractSbj;

    /**
     * 個別取引（自社請求側）_請求側組織コード
     */
    @Column(name = "idv_rate_tra_in_h_b_s_bldging_side_org_code")
    private String idvRateTraInHbsBldgingSideOrgCode;

    /**
     * 個別取引（自社請求側）_請求側組織名
     */
    @Column(name = "idv_rate_tra_in_h_b_s_bldging_side_org_name")
    private String idvRateTraInHbsBlgingSideOrgName;

    /**
     * 個別取引（自社請求側）_請求側部課コード
     */
    @Column(name = "idv_rate_tra_in_h_b_s_bldging_side_section_code")
    private String idvRateTraInHbsBldgingSideSectionCode;

    /**
     * 個別取引（自社請求側）_請求側部課名
     */
    @Column(name = "idv_rate_tra_in_h_b_s_bldging_side_section_name")
    private String idvRateTraInHbsBlgingSideSectionName;

    /**
     * 個別取引（自社請求側）_支払側組織コード
     */
    @Column(name = "idv_rate_tra_in_h_b_s_paying_side_org_code")
    private String idvRateTraInHbsPayingSideOrgCode;

    /**
     * 個別取引（自社請求側）_支払側組織名
     */
    @Column(name = "idv_rate_tra_in_h_b_s_paying_org_name")
    private String idvRateTraInHbsPayingOrgName;

    /**
     * 個別取引（自社請求側）_支払側部課コード
     */
    @Column(name = "idv_rate_tra_in_h_b_s_payment_section_code")
    private String idvRateTraInHbsPaymentSectionCode;

    /**
     * 個別取引（自社請求側）_支払側部課名
     */
    @Column(name = "idv_rate_tra_in_h_b_s_paying_side_section_name")
    private String idvRateTraInHbsPayingSideSectionName;

    /**
     * 個別取引（自社請求側）_取引種別
     */
    @Column(name = "idv_rate_tra_in_h_b_s_tra_type")
    private String idvRateTraInHbsTraType;

    /**
     * 個別取引（自社請求側）_概算識別
     */
    @Column(name = "idv_rate_tra_in_h_b_s_rough_identification")
    private String idvRateTraInHbsRoughIdentification;

    /**
     * 個別取引（自社請求側）_接続日
     */
    @Column(name = "idv_rate_tra_in_h_b_s_cnt_date")
    private String idvRateTraInHbsCntDate;

    /**
     * 個別取引（自社請求側）_役務提供開始日
     */
    @Column(name = "idv_rate_tra_in_h_b_s_service_start_date")
    private String idvRateTraInHbsServiceStartDate;

    /**
     * 個別取引（自社請求側）_役務提供終了日
     */
    @Column(name = "idv_rate_tra_in_h_b_s_service_close_date")
    private String idvRateTraInHbsServiceCloseDate;

    /**
     * 個別取引（自社請求側）_取引日
     */
    @Column(name = "idv_rate_tra_in_h_b_s_trading_day")
    private String idvRateTraInHbsTradingDay;

    /**
     * 個別取引（自社請求側）_請求番号
     */
    @Column(name = "idv_rate_tra_in_h_b_s_billing_number")
    private String idvRateTraInHbsBillingNumber;

    /**
     * 個別取引（自社請求側）_支払番号
     */
    @Column(name = "idv_rate_tra_in_h_b_s_payment_number")
    private String idvRateTraInHbsPaymentNumber;

    /**
     * 個別取引（自社請求側）_金額
     */
    @Column(name = "idv_rate_tra_in_h_b_s_amt")
    private Long idvRateTraInHbsAmt;

    /**
     * 個別取引（自社請求側）_相手担当者
     */
    @Column(name = "idv_rate_tra_in_h_b_s_contact_person")
    private String idvRateTraInHbsContactPerson;

    /**
     * 個別取引（自社請求側）_相手担当者電話番号
     */
    @Column(name = "idv_rate_tra_in_h_b_s_contact_person_tel")
    private String idvRateTraInHbsContactPersonTel;

    /**
     * 個別取引（自社請求側）_相手担当者メールアドレス
     */
    @Column(name = "idv_rate_tra_in_h_b_s_contact_person_email_address")
    private String idvRateTraInHbsContactPersonEmailAddress;

    /**
     * 個別取引（自社請求側）_自社担当者
     */
    @Column(name = "idv_rate_tra_in_h_b_s_in_house_contact")
    private String idvRateTraInHbsInHouseContact;

    /**
     * 個別取引（自社請求側）_自社担当者電話番号
     */
    @Column(name = "idv_rate_tra_in_h_b_s_in_house_contact_tel")
    private String idvRateTraInHbsInHouseContactTel;

    /**
     * 	個別取引（自社請求側）_自社担当者メールアドレス
     */
    @Column(name = "idv_rate_tra_in_h_b_s_e_mail_address")
    private String idvRateTraInHbsEmailAddress;

    /**
     * 個別取引（自社請求側）_接続日からの経過日数
     */
    @Column(name = "idv_rate_tra_in_h_b_s_days_since_cnt_date")
    private String idvRateTraInHbsDaysSinceCntDate;

    /**
     * 個別取引（自社請求側）_備考
     */
    @Column(name = "idv_rate_tra_in_h_b_s_remarks")
    private String idvRateTraInHbsRemarks;

    /**
     * 個別取引（自社支払側）_ステータス
     */
    @Column(name = "idv_rate_tra_own_p_s_status")
    private String idvRateTraOwnPsStatus;

    /**
     * 個別取引（自社支払側）_突合候補
     */
    @Column(name = "idv_rate_tra_own_p_s_synapse")
    private String idvRateTraOwnPsSynapse;

    /**
     * 個別取引（自社支払側）_自会社名※支払側
     */
    @Column(name = "idv_rate_tra_own_p_s_own_company_name_payment_side")
    private String idvRateTraOwnPsOwnCompanyNamePaymentSide;

    /**
     * 個別取引（自社支払側）_相手会社名
     */
    @Column(name = "idv_rate_tra_own_p_s_other_company_name")
    private String idvRateTraOwnPsOtherCompanyName;

    /**
     * 個別取引（自社支払側）_契約登録番号
     */
    @Column(name = "idv_rate_tra_own_p_s_contract_registration_number")
    private String idvRateTraOwnPsContractRegistrationNumber;

    /**
     * 個別取引（自社支払側）_契約件名
     */
    @Column(name = "idv_rate_tra_own_p_s_contract_sbj")
    private String idvRateTraOwnPsContractSbj;

    /**
     * 個別取引（自社支払側）_請求側組織コード
     */
    @Column(name = "idv_rate_tra_own_p_s_bldging_side_org_code")
    private String idvRateTraOwnPsBldgingSideOrgCode;

    /**
     * 個別取引（自社支払側）_請求側組織名
     */
    @Column(name = "idv_rate_tra_own_p_s_bldging_side_org_name")
    private String idvRateTraOwnPsBldgingSideOrgName;

    /**
     * 個別取引（自社支払側）_請求側部課コード
     */
    @Column(name = "idv_rate_tra_own_p_s_bldging_side_section_code")
    private String idvRateTraOwnPsBldgingSideSectionCode;

    /**
     * 個別取引（自社支払側）_請求側部課名
     */
    @Column(name = "idv_rate_tra_own_company_payment_side_bldging_section_name")
    private String idvRateTraOwnCompanyPaymentSideBldgingSectionName;

    /**
     * 個別取引（自社支払側）_支払側組織コード
     */
    @Column(name = "idv_rate_tra_own_p_s_payer_org_code")
    private String idvRateTraOwnPsPayerOrgCode;

    /**
     * 個別取引（自社支払側）_支払側組織名
     */
    @Column(name = "idv_rate_tra_own_p_s_paying_org_name")
    private String idvRateTraOwnPsPayingOrgName;

    /**
     * 個別取引（自社支払側）_支払側部課コード
     */
    @Column(name = "idv_rate_tra_own_p_s_payment_depa_code")
    private String idvRateTraOwnPsPaymentDepaCode;

    /**
     * 個別取引（自社支払側）_支払側部課名
     */
    @Column(name = "idv_rate_tra_own_p_s_payment_depa_name")
    private String idvRateTraOwnPsPaymentDepaName;

    /**
     * 個別取引（自社支払側）_取引種別
     */
    @Column(name = "idv_rate_tra_own_p_s_tra_type")
    private String idvRateTraOwnPsTraType;

    /**
     * 個別取引（自社支払側）_概算識別
     */
    @Column(name = "idv_rate_tra_own_p_s_rough_identification")
    private String idvRateTraOwnPsRoughIdentification;

    /**
     * 個別取引（自社支払側）_接続日
     */
    @Column(name = "idv_rate_tra_own_p_s_cnt_date")
    private String idvRateTraOwnPsCntDate;

    /**
     * 個別取引（自社支払側）_役務提供開始日
     */
    @Column(name = "idv_rate_tra_own_p_s_service_start_date")
    private String idvRateTraOwnPsServiceStartDate;

    /**
     * 個別取引（自社支払側）_取引日
     */
    @Column(name = "idv_rate_tra_own_p_s_trading_day")
    private String idvRateTraOwnPsTradingDay;

    /**
     * 個別取引（自社支払側）_請求番号
     */
    @Column(name = "idv_rate_tra_own_p_s_billing_number")
    private String idvRateTraOwnPsBillingNumber;

    /**
     * 個別取引（自社支払側）_支払番号
     */
    @Column(name = "idv_rate_tra_own_p_s_payment_number")
    private String idvRateTraOwnPsPaymentNumber;

    /**
     * 個別取引（自社支払側）_金額
     */
    @Column(name = "idv_rate_tra_own_p_s_amt")
    private Long idvRateTraOwnPsAmt;

    /**
     * 個別取引（自社支払側）_相手担当者
     */
    @Column(name = "idv_rate_tra_own_p_s_contact_person")
    private String idvRateTraOwnPsContactPerson;

    /**
     * 個別取引（自社支払側）_相手担当者電話番号
     */
    @Column(name = "idv_rate_tra_own_p_s_contact_person_tel")
    private String idvRateTraOwnPsContactPersonTel;

    /**
     * 個別取引（自社支払側）_相手担当者メールアドレス
     */
    @Column(name = "idv_rate_tra_own_p_s_contact_person_email_address")
    private String idvRateTraOwnPsContactPersonEmailAddress;

    /**
     * 個別取引（自社支払側）_自社担当者
     */
    @Column(name = "idv_rate_tra_own_p_s_in_house_contact")
    private String idvRateTraOwnPsInHouseContact;

    /**
     * 個別取引（自社支払側）_自社担当者電話番号
     */
    @Column(name = "idv_rate_tra_own_p_s_in_house_contact_tel")
    private String idvRateTraOwnPsInHouseContactTel;

    /**
     * 個別取引（自社支払側）_自社担当者メールアドレス
     */
    @Column(name = "idv_rate_tra_own_p_s_e_mail_address")
    private String idvRateTraOwnPsEmailAddress;

    /**
     * 個別取引（自社支払側）_接続日からの経過日数
     */
    @Column(name = "idv_rate_tra_own_p_s_days_since_cnt_date")
    private String idvRateTraOwnPsDaysSinceCntDate;

    /**
     * 個別取引（自社支払側）_備考
     */
    @Column(name = "idv_rate_tra_own_p_s_remarks")
    private String idvRateTraOwnPsRemarks;

    /**
     * 登録ユーザ
     */
    @NotNull
    @Column(name = "insert_user")
    private String insertUser;

    /**
     * 更新ユーザ
     */
    @NotNull
    @Column(name = "update_user")
    private String updateUser;

    /**
     * 更新日時
     */
    @NotNull
    @Column(name = "update_datetime")
    private LocalDateTime updatedAt;

    /**
     * 登録日時
     */
    @NotNull
    @Column(name = "insert_datetime")
    private LocalDateTime createdAt;
    /**
     * 削除日時
     */
    @Column(name = "delete_datetime")
    private LocalDateTime deleteDatetime;

    /**
     * 削除ユーザ
     */
    @Column(name = "delete_user")
    private LocalDateTime deleteUser;
}