package jp.co.ntt.common.dto.kaikei.incomplete;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import static jp.co.ntt.common.constant.Constants.EMPTY_STRING;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class IdvRateTraOwnPsItem extends CommonIncomplete implements AccountingDataReport {
    /**
     * 個別取引（自社支払側）_ステータス
     */
    private String idvRateTraOwnPsStatus;

    /**
     * 個別取引（自社支払側）_突合候補
     */
    private String idvRateTraOwnPsSynapse;

    /**
     * 個別取引（自社支払側）_自会社名※支払側
     */
    private String idvRateTraOwnPsOwnCompanyNamePaymentSide;

    /**
     * 個別取引（自社支払側）_相手会社名
     */
    private String idvRateTraOwnPsOtherCompanyName;

    /**
     * 個別取引（自社支払側）_契約登録番号
     */
    private String idvRateTraOwnPsContractRegistrationNumber;

    /**
     * 個別取引（自社支払側）_契約件名
     */
    private String idvRateTraOwnPsContractSbj;

    /**
     * 個別取引（自社支払側）_請求側組織コード
     */
    private String idvRateTraOwnPsBldgingSideOrgCode;

    /**
     * 個別取引（自社支払側）_請求側組織名
     */
    private String idvRateTraOwnPsBldgingSideOrgName;

    /**
     * 個別取引（自社支払側）_請求側部課コード
     */
    private String idvRateTraOwnPsBldgingSideSectionCode;

    /**
     * 個別取引（自社支払側）_請求側部課名
     */
    private String idvRateTraOwnCompanyPaymentSideBldgingSectionName;

    /**
     * 個別取引（自社支払側）_支払側組織コード
     */
    private String idvRateTraOwnPsPayerOrgCode;

    /**
     * 個別取引（自社支払側）_支払側組織名
     */
    private String idvRateTraOwnPsPayingOrgName;

    /**
     * 個別取引（自社支払側）_支払側部課コード
     */
    private String idvRateTraOwnPsPaymentDepaCode;

    /**
     * 個別取引（自社支払側）_支払側部課名
     */
    private String idvRateTraOwnPsPaymentDepaName;

    /**
     * 個別取引（自社支払側）_取引種別
     */
    private String idvRateTraOwnPsTraType;

    /**
     * 個別取引（自社支払側）_概算識別
     */
    private String idvRateTraOwnPsRoughIdentification;

    /**
     * 個別取引（自社支払側）_接続日
     */
    private String idvRateTraOwnPsCntDate;

    /**
     * 個別取引（自社支払側）_役務提供開始日
     */
    private String idvRateTraOwnPsServiceStartDate;

    /**
     * 個別取引（自社支払側）_取引日
     */
    private String idvRateTraOwnPsTradingDay;

    /**
     * 個別取引（自社支払側）_請求番号
     */
    private String idvRateTraOwnPsBillingNumber;

    /**
     * 個別取引（自社支払側）_支払番号
     */
    private String idvRateTraOwnPsPaymentNumber;

    /**
     * 個別取引（自社支払側）_金額
     */
    private Long idvRateTraOwnPsAmt;

    /**
     * 個別取引（自社支払側）_相手担当者
     */
    private String idvRateTraOwnPsContactPerson;

    /**
     * 個別取引（自社支払側）_相手担当者電話番号
     */
    private String idvRateTraOwnPsContactPersonTel;

    /**
     * 個別取引（自社支払側）_相手担当者メールアドレス
     */
    private String idvRateTraOwnPsContactPersonEmailAddress;

    /**
     * 個別取引（自社支払側）_自社担当者
     */
    private String idvRateTraOwnPsInHouseContact;

    /**
     * 個別取引（自社支払側）_自社担当者電話番号
     */
    private String idvRateTraOwnPsInHouseContactTel;

    /**
     * 個別取引（自社支払側）_自社担当者メールアドレス
     */
    private String idvRateTraOwnPsEmailAddress;

    /**
     * 個別取引（自社支払側）_接続日からの経過日数
     */
    private String idvRateTraOwnPsDaysSinceCntDate;

    /**
     * 個別取引（自社支払側）_備考
     */
    private String idvRateTraOwnPsRemarks;

    /**
     * サブ帳票番号
     */
    @JsonIgnore
    private Integer subReportNo;

    @Override
    public String getPartnerCompanyName() {
        return idvRateTraOwnPsOtherCompanyName;
    }

    @Override
    public String getContactTel() {
        return this.idvRateTraOwnPsInHouseContactTel;
    }

    @Override
    public String getContactMailAddress() {
        return idvRateTraOwnPsEmailAddress;
    }

    @Override
    public String getStatus() {
        return this.idvRateTraOwnPsStatus;
    }

    @Override
    public String getBldgingSideAcptCntStatus() {
        return EMPTY_STRING;
    }

    @Override
    public String getPaymentSideAcptCntStatus() {
        return EMPTY_STRING;
    }

    @Override
    public String getAccountingOrgCode() {
        return null;
    }

    @Override
    public void setPartnerPicName(String partnerPicName) {
        this.idvRateTraOwnPsInHouseContact = partnerPicName;
    }

    @Override
    public void setPartnerPicTel(String partnerPicTel) {
        this.idvRateTraOwnPsInHouseContactTel = partnerPicTel;
    }

    @Override
    public void setPartnerPicEmail(String partnerPicEmail) {
        this.idvRateTraOwnPsEmailAddress = partnerPicEmail;
    }

    @Override
    public String getContractRegistrationNumber() {
        return idvRateTraOwnPsContractRegistrationNumber;
    }
}
