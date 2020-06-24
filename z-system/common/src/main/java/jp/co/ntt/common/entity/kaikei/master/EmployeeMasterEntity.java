package jp.co.ntt.common.entity.kaikei.master;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "TM_UserInfoData")
public class EmployeeMasterEntity {
    /**
     * ユーザ情報データID
     */
    @Id
    @NotNull
    @Column(name = "user_info_data_id")
    private String userInfoDataId;

    /**
     * 帳票ID
     */
    @NotNull
    @Column(name = "report_id")
    private String reportId;

    /**
     * サブ帳票番号
     */
    @NotNull
    @Column(name = "sub_report_no")
    private String subReportNo;

    /**
     * 年度
     */
    @Column(name = "fiscal_year")
    private String fiscalYear;

    /**
     * 会計期間区分
     */
    @Column(name = "fiscal_period_type")
    private String fiscalPeriodType;

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
    @NotNull
    @Column(name = "incremental_flag")
    private String incrementalFlag;

    /**
     * バージョン
     */
    @NotNull
    @Column(name = "version")
    private String version;

    /**
     * ファイル作成日時
     */
    @Column(name = "file_created_datetime")
    private String fileCreatedDatetime;

    /**
     * ファイル更新日時
     */
    @Column(name = "file_lastmodified_datetime")
    private String fileLastModifiedDatetime;

    /**
     * 社員コード
     */
    @Column(name = "employee_code")
    private String employeeCode;

    /**
     * 生年月日
     */
    @Column(name = "birth_date")
    private String birthDate;

    /**
     * 漢字氏名（姓）
     */
    @Column(name = "kanji_name_last_name")
    private String kanjiNameLastName;

    /**
     * 漢字氏名（名）
     */
    @NotNull
    @Column(name = "kanji_name_first_name")
    private String kanjiNameFirstName;

    /**
     * カナ氏名（姓）
     */
    @Column(name = "kana_name_last_name")
    private String kanaNameLastName;

    /**
     * カナ氏名（名）
     */
    @Column(name = "kana_name_first_name")
    private String kanaNameFirstName;

    /**
     * メールアドレス
     */
    @Column(name = "email_address")
    String emailAddress;

    /**
     * 連絡先電話番号
     */
    @Column(name = "contact_information_tel")
    String contactInformationTel;

    /**
     * ユーザ有効日
     */
    @Column(name = "user_effective_date")
    String userEffectiveDate;

    /**
     * ユーザ無効日
     */
    @NotNull
    @Column(name = "user_invalid_date")
    String userInvalidDate;

    /**
     * 本務識別
     */
    @Column(name = "main_biz_identification")
    String mainBizIdentification;

    /**
     * 部課コード
     */
    @Column(name = "depa_code")
    String departmentCode;

    /**
     * 役職名
     */
    @Column(name = "job_title_name")
    String jobTitleMame;

    /**
     * 所属有効日
     */
    @Column(name = "affiliation_effective_date")
    Integer affiliationEffectiveDate;

    /**
     * 所属無効日
     */
    @NotNull
    @Column(name = "affiliation_invalid_date")
    String affiliationInvalidDate;

    /**
     * 職責基本名
     */
    @Column(name = "responsibility_basic_name")
    String responsibilityBasicName;

//    @ManyToOne
//    @JoinColumn(name="accounting_org_code")
//    DepaDataMasterEntity dataMaster;
//
//    @ManyToOne
//    @JoinColumn(name="accounting_org_code")
//    AccountingOrgMasterEntity accountingOrgMaster;

    /**
     * 職責有効日
     */
    @NotNull
    @Column(name = "responsibility_effective_date")
    String responsibilityEffectiveDate;

    /**
     * 職責無効日
     */
    @Column(name = "responsibility_invalidity_date")
    String responsibilityInvalidityDate;

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
    @UpdateTimestamp
    @Column(name = "update_datetime", updatable = false)
    private LocalDateTime updatedAt;

    /**
     * 登録日時
     */
    @NotNull
    @CreationTimestamp
    @Column(name = "insert_datetime", insertable = false)
    private LocalDateTime createdAt;
}
