package jp.co.ntt.common.entity.kaikei.unaccepted;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "TD_AcctRptDtaUnapproved")
@EntityListeners(AuditingEntityListener.class)
public class UnacceptedReportDataEntity {
    /**
     * 会計用データID
     */
    @Id
    @NotNull
    @Column(name = "accounting_report_data_id")
    private Integer accountingReportDataId;

    /**
     * 判定
     */
    @Column(name = "judgement")
    private Integer judgement;

    /**
     * 備考（処理状況）
     */
    @Column(name = "remark")
    private String remark;

    /**
     * 督促除外
     */
    @Column(name = "reminder_exclusion")
    private Integer reminderExclusion;

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
     * 備考（BA西担当者利用）
     */
    @Column(name = "ba_comment")
    private String baComment;

    /**
     * 	伝票番号
     */
    @Column(name = "sales_slip_number")
    private String salesSlipNumber;

    /**
     * 会計期間
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
    @LastModifiedBy
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