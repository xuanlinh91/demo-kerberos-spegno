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
@Table(name = "TD_DataVersion")
public class DataVersionEntity {

    /**
     * データバージョンID
     */
    @Id
    @NotNull
    @Column(name = "data_version_id")
    private Integer dataVersionId;

    /**
     * 帳票ID
     */
    @Column(name = "report_id")
    private Integer reportId;

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