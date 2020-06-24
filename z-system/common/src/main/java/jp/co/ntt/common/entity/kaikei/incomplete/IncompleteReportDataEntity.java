package jp.co.ntt.common.entity.kaikei.incomplete;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "TD_AcctRptDtaIncomplete")
@EntityListeners(AuditingEntityListener.class)
public class IncompleteReportDataEntity {

    /**
     * 会計用データID
     */
    @Id
    @NotNull
    @Column(name = "accounting_report_data_id")
    private Integer accountingReportDataId;

    /**
     * 判定(問合せBox)
     */
    @Column(name = "judgement")
    private Integer judgement;

    /**
     * 処理状況
     */
    @Column(name = "processing_status")
    private String processingStatus;

    /**
     * 督促除外
     */
    @Column(name = "reminder_exclusion")
    private Integer reminderExclusion;

    /**
     * エリア
     */
    @Column(name = "area")
    private String area;

    /**
     * 請求側非参画で金額なし
     */
    @Column(name = "no_billing_side_participation_no_amount")
    private String noBillingSideParticipationNoAmount;

    /**
     * 	処理案内
     */
    @Column(name = "processing_guide")
    private String processingGuide;

    /**
     * 判定（BA西担当者利用）
     */
    @Column(name = "ba_judgement")
    private Integer baJudgement;

    /**
     * 処理状況（BA西担当者利用）
     */
    @Column(name = "ba_processing_status")
    private String baProcessingStatus;

    /**
     * 自由記入欄
     */
    @Column(name = "ba_comment")
    private String baComment;

    /**
     * 契約登録番号
     */
    @Column(name = "contract_registration_number")
    private String contractRegistrationNumber;
    
    /**
     * 契約登録番号
     */
    @Column(name = "fiscal_period")
    private String fiscalPeriod;

    /**
     * 登録ユーザ
     */
    @NotNull
    @Column(name = "insert_user", updatable = false)
    @CreatedBy
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
    @LastModifiedDate
    private LocalDateTime updatedAt;

    /**
     * 登録日時
     */
    @NotNull
    @Column(name = "insert_datetime", updatable = false)
    @CreatedDate
    private LocalDateTime createdAt;
}