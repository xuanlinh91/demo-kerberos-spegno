package jp.co.ntt.common.entity.kaikei.master;

import lombok.Data;
import org.springframework.data.annotation.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Data
@Immutable
@Table(name = "TM_AccountingOrgData")
public class AccountingOrgMasterEntity {
    /**
     *
     */
    @Id
    @NotNull
    @Column(name = "accounting_org_data_id")
    private String accountingOrgDataId;

    /**
     *
     */
    @Column(name = "report_id")
    private String reportId;

    /**
     *
     */
    @Column(name = "sub_report_no")
    private String subReportNo;

    /**
     *
     */
    @Column(name = "fiscal_year")
    private String fiscalYear;

    /**
     *
     */
    @Column(name = "fiscal_period_type")
    private String fiscalPeriodType;

    /**
     *
     */
    @Column(name = "fiscal_period")
    private String fiscalPeriod;

    /**
     *
     */
    @Column(name = "report_org")
    private String reportOrg;

    /**
     *
     */
    @Column(name = "data_period")
    private String dataPeriod;

    /**
     *
     */
    @Column(name = "incremental_flag")
    private String incrementalFlag;

    /**
     *
     */
    @Column(name = "version")
    private String version;

    /**
     *
     */
    @Column(name = "file_created_datetime")
    private String fileCreatedDatetime;

    /**
     *
     */
    @Column(name = "file_lastmodified_datetime")
    private String fileLastModifiedDatetime;

    /**
     *
     */
    @Column(name = "company_code")
    private String companyCode;

    /**
     *
     */
    @Column(name = "accounting_org_code")
    private String accountingOrgCode;

    /**
     *
     */
    @Column(name = "converted_value")
    private String convertedValue;

    /**
     *
     */
    @Column(name = "description")
    private String description;

    /**
     *
     */
    @Column(name = "available")
    private String available;

    /**
     *
     */
    @Column(name = "effective_date_from")
    private String effectiveDateFrom;

    /**
     *
     */
    @Column(name = "effective_date_to")
    private String effectiveDateTo;

    /**
     *
     */
    @Column(name = "parent")
    private String parent;

    /**
     *
     */
    @Column(name = "org_group")
    private String orgGroup;

    /**
     *
     */
    @Column(name = "org_level")
    private String orgLevel;

    /**
     *
     */
    @Column(name = "allow_budget_registration")
    private String allowBudgetRegistration;

    /**
     *
     */
    @Column(name = "allow_posting")
    private String allowPosting;

    /**
     *
     */
    @Column(name = "account_title_type")
    private String accountTitleType;

    /**
     *
     */
    @Column(name = "child_value_range_from")
    private String childValueRangeFrom;

    /**
     *
     */
    @Column(name = "child_value_range_to")
    private String childValueRangeTo;

    /**
     *
     */
    @Column(name = "including")
    private String including;

    /**
     *
     */
    @Column(name = "prefecture_code")
    private String prefectureCode;

    /**
     *
     */
    @Column(name = "headquarters_orgal_authority_availability")
    private String headquartersOrgalAuthorityAvailability;

    /**
     *
     */
    @Column(name = "use_aggregated_org_authority_propriety")
    private String useAggregatedOrgAuthorityPropriety;

    /**
     *
     */
    @Column(name = "dff4_spare")
    private String dff4Spare;

    /**
     *
     */
    @Column(name = "org_classification")
    private String orgClassification;

    /**
     *
     */
    @Column(name = "dff6_spare")
    private String dff6Spare;

    /**
     *
     */
    @Column(name = "dff7_spare")
    private String dff7Spare;

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
}
