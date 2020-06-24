package jp.co.ntt.common.dto.kaikei.incomplete;

public interface AccountingDataReport {
    Integer getAccountingReportDataId();
    String getContactTel();
    String getContactMailAddress();
    Integer getReportId();
    Integer getSubReportNo();
    String getPartnerCompanyName();
    String getStatus();
    String getBldgingSideAcptCntStatus();
    String getPaymentSideAcptCntStatus();
    String getAccountingOrgCode();
    String getContractRegistrationNumber();
    String getFiscalPeriod();
    void setPartnerPicName(String partnerPicName);
    void setPartnerPicTel(String partnerPicTel);
    void setPartnerPicEmail(String partnerPicEmail);
}
