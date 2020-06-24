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
public class IdvRateTraInHbsItem extends CommonIncomplete implements AccountingDataReport {
    /**
     * 個別取引（自社請求側）_ステータス
     */
    private String idvRateTraInHbsStatus;

    /**
     * 個別取引（自社請求側）_突合候補
     */
    private String idvRateTraInHbsSynapse;

    /**
     * 個別取引（自社請求側）_自会社名※請求側
     */
    private String idvRateTraInHbsOwnCompanyNameBldgingSide;

    /**
     * 個別取引（自社請求側）_相手会社名
     */
    private String idvRateTraInHbsOtherCompanyName;

    /**
     * 個別取引（自社請求側）_契約登録番号
     */
    private String idvRateTraInHbsContractRegistrationNumber;

    /**
     * 個別取引（自社請求側）_契約件名
     */
    private String idvRateTraInHbsContractSbj;

    /**
     * 個別取引（自社請求側）_請求側組織コード
     */
    private String idvRateTraInHbsBldgingSideOrgCode;

    /**
     * 個別取引（自社請求側）_請求側組織名
     */
    private String idvRateTraInHbsBlgingSideOrgName;

    /**
     * 個別取引（自社請求側）_請求側部課コード
     */
    private String idvRateTraInHbsBldgingSideSectionCode;

    /**
     * 個別取引（自社請求側）_請求側部課名
     */
    private String idvRateTraInHbsBlgingSideSectionName;

    /**
     * 個別取引（自社請求側）_支払側組織コード
     */
    private String idvRateTraInHbsPayingSideOrgCode;

    /**
     * 個別取引（自社請求側）_支払側組織名
     */
    private String idvRateTraInHbsPayingOrgName;

    /**
     * 個別取引（自社請求側）_支払側部課コード
     */
    private String idvRateTraInHbsPaymentSectionCode;

    /**
     * 個別取引（自社請求側）_支払側部課名
     */
    private String idvRateTraInHbsPayingSideSectionName;

    /**
     * 個別取引（自社請求側）_取引種別
     */
    private String idvRateTraInHbsTraType;

    /**
     * 個別取引（自社請求側）_概算識別
     */
    private String idvRateTraInHbsRoughIdentification;

    /**
     * 個別取引（自社請求側）_接続日
     */
    private String idvRateTraInHbsCntDate;

    /**
     * 個別取引（自社請求側）_役務提供開始日
     */
    private String idvRateTraInHbsServiceStartDate;

    /**
     * 個別取引（自社請求側）_役務提供終了日
     */
    private String idvRateTraInHbsServiceCloseDate;

    /**
     * 個別取引（自社請求側）_取引日
     */
    private String idvRateTraInHbsTradingDay;

    /**
     * 個別取引（自社請求側）_請求番号
     */
    private String idvRateTraInHbsBillingNumber;

    /**
     * 個別取引（自社請求側）_支払番号
     */
    private String idvRateTraInHbsPaymentNumber;

    /**
     * 個別取引（自社請求側）_金額
     */
    private Long idvRateTraInHbsAmt;

    /**
     * 個別取引（自社請求側）_相手担当者
     */
    private String idvRateTraInHbsContactPerson;

    /**
     * 個別取引（自社請求側）_相手担当者電話番号
     */
    private String idvRateTraInHbsContactPersonTel;

    /**
     * 個別取引（自社請求側）_相手担当者メールアドレス
     */
    private String idvRateTraInHbsContactPersonEmailAddress;

    /**
     * 個別取引（自社請求側）_自社担当者
     */
    private String idvRateTraInHbsInHouseContact;

    /**
     * 個別取引（自社請求側）_自社担当者電話番号
     */
    private String idvRateTraInHbsInHouseContactTel;

    /**
     * 	個別取引（自社請求側）_自社担当者メールアドレス
     */
    private String idvRateTraInHbsEmailAddress;

    /**
     * 個別取引（自社請求側）_接続日からの経過日数
     */
    private String idvRateTraInHbsDaysSinceCntDate;

    /**
     * 個別取引（自社請求側）_備考
     */
    private String idvRateTraInHbsRemarks;

    /**
     * サブ帳票番号
     */
    @JsonIgnore
    private Integer subReportNo;

    @Override
    public String getContactTel(){
        return this.idvRateTraInHbsInHouseContactTel;
    }

    @Override
    public String getContactMailAddress() {
        return idvRateTraInHbsEmailAddress;
    }

    @Override
    public String getPartnerCompanyName() {
        return idvRateTraInHbsOtherCompanyName;
    }

    @Override
    public String getStatus() {
        return this.idvRateTraInHbsStatus;
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
        return idvRateTraInHbsBldgingSideOrgCode;
    }

    @Override
    public void setPartnerPicName(String partnerPicName) {
        this.idvRateTraInHbsInHouseContact = partnerPicName;
    }

    @Override
    public void setPartnerPicTel(String partnerPicTel) {
        this.idvRateTraInHbsInHouseContactTel = partnerPicTel;
    }

    @Override
    public void setPartnerPicEmail(String partnerPicEmail) {
        this.idvRateTraInHbsEmailAddress = partnerPicEmail;
    }

    @Override
    public String getContractRegistrationNumber() {
        return idvRateTraInHbsContractRegistrationNumber;
    }
}
