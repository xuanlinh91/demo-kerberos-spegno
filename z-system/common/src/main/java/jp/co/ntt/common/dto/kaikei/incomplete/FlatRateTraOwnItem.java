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
public class FlatRateTraOwnItem extends CommonIncomplete implements AccountingDataReport {
    /**
     * 定額取引（自社支払側）_ステータス
     */
    private String flatRateTraOwnPsStatus;

    /**
     * 定額取引（自社支払側）_自会社名※支払側
     */
    private String flatRateTraOwnPsOwnComanyNamePaymentSide;

    /**
     * 定額取引（自社支払側）_相手会社名
     */
    private String flatRateTraOwnPsOtherCompanyName;

    /**
     * 定額取引（自社支払側）_契約登録番号
     */
    private String flatRateTraOwnPsContractRegistrationNumber;

    /**
     * 定額取引（自社支払側）_契約件名
     */
    private String flatRateTraOwnPsContractSbj;

    /**
     * 定額取引（自社支払側）_請求側組織コード
     */
    private String flatRateTraOwnPsBldgingSideOrgCode;

    /**
     * 定額取引（自社支払側）_請求側組織名
     */
    private String flatRateTraOwnPsBldgingSideOrgName;

    /**
     * 定額取引（自社支払側）_請求側部課コード
     */
    private String flatRateTraOwnPsBldgingSideSectionCode;

    /**
     * 定額取引（自社支払側）_請求側部課名
     */
    private String flatRateTraOwnPsBldgingSectionName;

    /**
     * 定額取引（自社支払側）_支払側組織コード
     */
    private String flatRateTraOwnPsPayerOrgCode;

    /**
     * 定額取引（自社支払側）_支払側組織名
     */
    private String flatRateTraOwnPsPayingOrgName;

    /**
     * 定額取引（自社支払側）_支払側部課コード
     */
    private String flatRateTraOwnPsPaymentDepaCode;

    /**
     * 定額取引（自社支払側）_支払側部課名
     */
    private String flatRateTraOwnPsPaymentDepaName;

    /**
     * 定額取引（自社支払側）_接続日
     */
    private String flatRateTraOwnPsCntDate;

    /**
     * 定額取引（自社支払側）_初回請求金額
     */
    private Long flatRateTraOwnPsInitialBillingAmt;

    /**
     * 定額取引（自社支払側）_例月請求金額
     */
    private Long flatRateTraOwnPsMonthlyBillingAmt;

    /**
     * 定額取引（自社支払側）_終回請求金額
     */
    private Long flatRateTraOwnPsFinalChargeAmt;

    /**
     * 定額取引（自社支払側）_相手担当者
     */
    private String flatRateTraOwnPsContactPerson;

    /**
     * 定額取引（自社支払側）_相手担当者電話番号
     */
    private String flatRateTraOwnPsContactPersonTel;

    /**
     * 定額取引（自社支払側）_相手担当者メールアドレス
     */
    private String flatRateTraOwnPsContactPersonTelMailAddress;

    /**
     * 定額取引（自社支払側）_自社担当者
     */
    private String flatRateTraOwnPsOwnContactPerson;

    /**
     * 定額取引（自社支払側）_自社担当者電話番号
     */
    private String flatRateTraOwnPsOwnContactPersonTel;

    /**
     * 定額取引（自社支払側）_自社担当者メールアドレス
     */
    private String flatRateTraOwnPaymentOwnContactPersonTelMailAddress;

    /**
     * 定額取引（自社支払側）_請求側初回検収接続状態
     */
    private String flatRateTraOwnPsBillingInitialAcptCntStatus;

    /**
     * 定額取引（自社支払側）_支払側初回検収接続状態
     */
    private String flatRateTraOwnPsPaymentSideFirstChkCntState;

    /**
     * 定額取引（自社支払側）_接続日からの経過日数
     */
    private String flatRateTraOwnPsPaymentSideCntDayProgressDay;

    /**
     * サブ帳票番号
     */
    @JsonIgnore
    private Integer subReportNo;

    @Override
    public String getPartnerCompanyName() {
        return flatRateTraOwnPsOtherCompanyName;
    }

    @Override
    public String getContactTel() {
        return this.flatRateTraOwnPsOwnContactPersonTel;
    }

    @Override
    public String getContactMailAddress() {
        return flatRateTraOwnPaymentOwnContactPersonTelMailAddress;
    }

    @Override
    public String getStatus() {
        return this.flatRateTraOwnPsStatus;
    }

    @Override
    public String getBldgingSideAcptCntStatus() {
        return this.flatRateTraOwnPsBillingInitialAcptCntStatus;
    }

    @Override
    public String getPaymentSideAcptCntStatus() {
        return this.flatRateTraOwnPsPaymentSideFirstChkCntState;
    }

    @Override
    public String getAccountingOrgCode() {
        return null;
    }

    @Override
    public void setPartnerPicName(String partnerPicName) {
        this.flatRateTraOwnPsOwnContactPerson = partnerPicName;
    }

    @Override
    public void setPartnerPicTel(String partnerPicTel) {
        this.flatRateTraOwnPsOwnContactPersonTel = partnerPicTel;
    }

    @Override
    public void setPartnerPicEmail(String partnerPicEmail) {
        this.flatRateTraOwnPaymentOwnContactPersonTelMailAddress = partnerPicEmail;
    }

    @Override
    public String getContractRegistrationNumber() {
        return flatRateTraOwnPsContractRegistrationNumber;
    }
}
