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
@Immutable
@Data
@Table(name = "TM_DepaData")
public class DepaDataMasterEntity {
    @Id
    @NotNull
    @Column(name = "depa_data_id")
    private String depaDataId;

    @Column(name = "report_id")
    private String reportIdd;

    @Column(name = "sub_report_no")
    private String subReportNo;

    @Column(name = "fiscal_year")
    private String fiscalYear;

    @Column(name = "fiscal_period_type")
    private String fiscalPeriodType;

    @Column(name = "fiscal_period")
    private String fiscalPeriod;

    @Column(name = "report_org")
    private String reportOrg;

    @Column(name = "data_period")
    private String dataPeriod;

    @Column(name = "incremental_flag")
    private String incrementalFlag;

    @Column(name = "version")
    private String version;

    @Column(name = "file_created_datetime")
    private String fileCreatedDatetime;

    @Column(name = "file_lastmodified_datetime")
    private String fileLastModifiedDatetime;

    @Column(name = "company_code")
    private String companyCode;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "accounting_org_code")
    private String accountingOrgCode;

    @Column(name = "general_tabulation_depa_code")
    private String generalTabulationDepaCode;

    @Column(name = "general_tabulation_depa_name")
    private String generalTabulationDepaName;

    @Column(name = "tabulation_depa_code")
    private String tabulationDepaCode;

    @Column(name = "tabulation_depa_name")
    private String tabulationDepaName;

    @Column(name = "depa_code")
    private String depaCode;

    @Column(name = "depa_name")
    private String depaName;

    @Column(name = "operation_availability_flag")
    private String operationAvailabilityFlag;

    @Column(name = "treasurer_input_availability_flag")
    private String treasurerInputAvailabilityFlag;

    @Column(name = "accounting_depa_authority_availability_flag")
    private String accountingDepaAuthorityAvailabilityFlag;

    @Column(name = "contract_depa_authority_availability_flag")
    private String contractDepaAuthorityAvailabilityFlag;

    @Column(name = "consumption_tax_available_code")
    private String consumptionTaxAvailableCode;

    @Column(name = "ivt_location_flag")
    private String ivtLocationFlag;

    @Column(name = "available")
    private String available;

    @Column(name = "valid_pd_from")
    private String ValidPdFrom;

    @Column(name = "validity_pd_to")
    private String ValidityPdTo;

    @Column(name = "biz_esta_code")
    private String bizEstaCode;

    @Column(name = "biz_esta_formal_name_depa_location")
    private String bizEstaFormalNameDepaLocation;

    @Column(name = "address_zip_code")
    private String addressZipCode;

    @Column(name = "address_address_1")
    private String addressAddress1;

    @Column(name = "address_teletel")
    private String addressTeletel;

    @Column(name = "address_fax_number")
    private String addressFaxNumber;

    @Column(name = "ocr_invoice_output_address_1st_line")
    private String ocrInvoiceOutputAddress1stLine;

    @Column(name = "ocr_invoice_output_address_2nd_line")
    private String ocrInvoiceOutputAddress2ndLine;

    @Column(name = "sales_rec_address_1")
    private String salesRecAddress1;

    @Column(name = "sales_rec_address_2")
    private String salesRecAddress2;

    @Column(name = "sales_rec_address_zip_code")
    private String salesRecAddressZipCode;

    @Column(name = "sales_rec_address_tel")
    private String salesRecAddressTel;

    @Column(name = "sales_rec_address_fax_number")
    private String salesRecAddressFaxNumber;

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
