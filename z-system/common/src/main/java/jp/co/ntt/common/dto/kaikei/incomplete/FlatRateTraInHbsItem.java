package jp.co.ntt.common.dto.kaikei.incomplete;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class FlatRateTraInHbsItem extends CommonIncomplete implements AccountingDataReport {

    /**
     * 定額取引（自社請求側）_ステータス
     */
    private String flatRateTraInHbsStatus;

    /**
     * 自会社名※請求側
     */
    private String flatRateTraInHbsOwnCompanyNameBldging;

    /**
     * 定額取引（自社請求側）_相手会社名
     */
    private String flatRateTraInHbsOtherCompanyName;

    /**
     * 定額取引（自社請求側）_契約登録番号
     */
    private String flatRateTraInHbsContractRegistrationNumber;

    /**
     * 定額取引（自社請求側）_契約件名
     */
    private String flatRateTraInHbsContractSbj;

    /**
     * 定額取引（自社請求側）_請求側組織コード
     */
    private String flatRateTraInHbsBldgingSideOrgCode;

    /**
     * 定額取引（自社請求側）_請求側組織名
     */
    private String flatRateTraInHbsBldgingSideOrgName;


    /**
     * 定額取引（自社請求側）_請求側部課コード
     */
    private String flatRateTraInHbsBldgingSideSectionCode;

    /**
     * 定額取引（自社請求側）_請求側部課名
     */
    private String flatRateTraInHbsBldgingSideSectionName;

    /**
     * 定額取引（自社請求側）_支払側組織コード
     */
    private String flatRateTraInHbsPayingSideOrgCode;

    /**
     * 定額取引（自社請求側）_支払側組織名
     */
    private String flatRateTraInHbsPayingOrgName;

    /**
     * 定額取引（自社請求側）_支払側部課コード
     */
    private String flatRateTraInHbsPaymentSectionCode;

    /**
     * 定額取引（自社請求側）_支払側部課名
     */
    private String flatRateTraInHbsPayingSideSectionName;

    /**
     * 定額取引（自社請求側）_接続日
     */
    private String flatRateTraInHbsCntDate;

    /**
     * 定額取引（自社請求側）_初回請求金額
     */
    private Long flatRateTraInHbsFirstBldgingAmt;

    /**
     * 定額取引（自社請求側）_例月請求金額
     */
    private Long flatRateTraInHbsMonthlyBldgingAmt;

    /**
     * 定額取引（自社請求側）_終回請求金額
     */
    private Long flatRateTraInHbsLastBldgingAmt;

    /**
     * 定額取引（自社請求側）_相手担当者
     */
    private String flatRateTraInHbsContactPerson;

    /**
     * 定額取引（自社請求側）_相手担当者電話番号
     */
    private String flatRateTraInHbsTel;

    /**
     * 定額取引（自社請求側）_相手担当者メールアドレス
     */
    private String flatRateTraInHbsContactPersonEmailAddress;

    /**
     * 定額取引（自社請求側）_自社担当者
     */
    private String flatRateTraInHbsInHouseContact;

    /**
     * 定額取引（自社請求側）_自社担当者電話番号
     */
    private String flatRateTraInHbsInHouseContactTel;

    /**
     * 定額取引（自社請求側）_自社担当者メールアドレス
     */
    private String flatRateTraInHbsEmailAddress;

    /**
     * 定額取引（自社請求側）_請求側初回検収接続状態
     */
    private String flatRateTraInHbsBldgingSideAcptCntStatus;

    /**
     * 定額取引（自社請求側）_支払側初回検収接続状態
     */
    private String flatRateTraInHbsPaymentSideAcptCntStatus;

    /**
     * 定額取引（自社請求側）_接続日からの経過日数
     */
    private String flatRateTraInHbsDaysSinceCntDate;

    /**
     * サブ帳票番号
     */
    @JsonIgnore
    private Integer subReportNo;

    @Override
    public String getContactTel(){
        return this.flatRateTraInHbsInHouseContactTel;
    }

    @Override
    public String getContactMailAddress() {
        return flatRateTraInHbsEmailAddress;
    }

    @Override
    public String getPartnerCompanyName() {
        return flatRateTraInHbsOtherCompanyName;
    }

    @Override
    public String getStatus() {
        return flatRateTraInHbsStatus;
    }

    @Override
    public String getBldgingSideAcptCntStatus() {
        return flatRateTraInHbsBldgingSideAcptCntStatus;
    }

    @Override
    public String getPaymentSideAcptCntStatus() {
        return flatRateTraInHbsPaymentSideAcptCntStatus;
    }

    @Override
    public String getAccountingOrgCode() {
        return flatRateTraInHbsBldgingSideOrgCode;
    }

    @Override
    public void setPartnerPicName(String partnerPicName) {
        this.flatRateTraInHbsInHouseContact = partnerPicName;
    }

    @Override
    public void setPartnerPicTel(String partnerPicTel) {
        this.flatRateTraInHbsInHouseContactTel = partnerPicTel;
    }

    @Override
    public void setPartnerPicEmail(String partnerPicEmail) {
        this.flatRateTraInHbsEmailAddress = partnerPicEmail;
    }

    @Override
    public String getContractRegistrationNumber() {
        return flatRateTraInHbsContractRegistrationNumber;
    }
}
