package jp.co.ntt.common.dto.kaikei.incomplete;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jp.co.ntt.common.entity.kaikei.report.DataVersionEntity;
import lombok.Data;

@Data
public class CommonIncomplete {
    /**
     * 会計用データID
     */
    private Integer accountingReportDataId;

    /**
     * 帳票ID
     */
    @JsonIgnore
    private Integer reportId;

    /**
     * サブ帳票番号
     */
    @JsonIgnore
    private Integer subReportNo;

    /**
     * データバージョン
     */
    @JsonIgnore
    private DataVersionEntity dataVersion;

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
    private String fiscalPeriod;

    /**
     * 更新ユーザ
     */
    private String updateUser;
}
