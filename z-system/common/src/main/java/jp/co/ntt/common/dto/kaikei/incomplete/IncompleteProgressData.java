package jp.co.ntt.common.dto.kaikei.incomplete;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IncompleteProgressData {
    /**
     * 会計用データID
     */
    @JsonIgnore
    private Integer accountingReportDataId;

    /**
     * 判定
     */
    @Min(1)
    @Max(5)
    private Integer judgement;

    /**
     * 判定（BA西担当者利用）
     */
    private Integer baJudgement;

    /**
     * 処理状況
     */
    private String processingStatus;

    /**
     * 督促除外
     */
    private Integer reminderExclusion;

    /**
     * エリア
     */
    private String area;

    /**
     * 請求側非参画で金額なし
     */
    private String noBillingSideParticipationNoAmount;

    /**
     * 	処理案内
     */
    private String processingGuide;

    /**
     * 処理状況（BA西担当者利用）
     */
    @Size(min = 1, max = 200)
    private String baProcessingStatus;

    /**
     * 自由記入欄（BA西担当者利用）
     */
    @Size(min = 1, max = 200)
    private String baComment;

    /**
     * 更新者
     */
    private String updateUser;
}