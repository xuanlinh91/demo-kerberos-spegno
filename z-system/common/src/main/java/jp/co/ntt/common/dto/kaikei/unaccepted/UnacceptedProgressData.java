package jp.co.ntt.common.dto.kaikei.unaccepted;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Data
public class UnacceptedProgressData {
    /**
     * 会計用データID
     */
    @JsonIgnore
    private Integer accountingReportDataId;

    /**
     * 判定
     */
    private Integer judgement;

    /**
     * 判定（BA西担当者利用）
     */
    @Min(1)
    @Max(5)
    private Integer baJudgement;

    /**
     * 備考
     */
    private String remark;

    /**
     * 督促除外
     */
    private Integer reminderExclusion;

    /**
     * 処理状況（BA西担当者利用）
     */
    @Size(min = 1, max = 200)
    private String baProcessingStatus;

    /**
     * 備考（BA西担当者利用）
     */
    @Size(min = 1, max = 200)
    private String baComment;

    /**
     * 更新ユーザ
     */
    private String updateUser;
}