package jp.co.ntt.common.entity.kaikei.master;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Table(name = "TM_AcctProcessingGuide")
@Entity
public class ProcessingGuideMasterEntity {
    /**
     * パターン番号
     */
    @Id
    @NotNull
    @Column(name = "pattern_no")
    private Integer patternNo;

    /**
     * ステータス
     */
    @NotNull
    @Column(name = "status")
    private String status;

    /**
     * ステータス
     */
    @NotNull
    @Column(name = "report_id")
    private Integer reportId;

    /**
     * ステータス
     */
    @NotNull
    @Column(name = "sub_report_no")
    private Integer subReportId;

    /**
     * 請求側初回検収接続状態
     */
    @Column(name = "billing_first_time_acc_conn_status")
    private String billingFirstTimeAccConnStatus;

    /**
     * 支払側初回検収接続状態
     */
    @Column(name = "payment_first_time_acc_conn_status")
    private String paymentFirstTimeAccConnStatus;

    /**
     * 相手会社依頼
     */
    @NotNull
    @Column(name = "partner_company_request")
    private String partnerCompanyRequest;

    /**
     * 処理案内
     */
    @Column(name = "processing_guide")
    private String processingGuide;

    /**
     * リンク先URL
     */
    @Column(name = "url")
    private String url;

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
    @Column(name = "update_datetime", updatable = false)
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    /**
     * 登録日時
     */
    @NotNull
    @Column(name = "insert_datetime", insertable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;
}
