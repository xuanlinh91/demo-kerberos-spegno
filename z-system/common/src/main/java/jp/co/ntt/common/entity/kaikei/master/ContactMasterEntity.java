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
@Entity
@Table(name = "TM_AcctContact")
@Deprecated
public class ContactMasterEntity {

    /**
     * 連絡先ID
     */
    @Id
    @NotNull
    @Column(name = "contact_id")
    private Integer contactId;

    /**
     * 契約登録番号
     */
    @NotNull
    @Column(name = "contact_registration_number")
    String contactRegistrationNumber;

    /**
     * 相手会社名
     */
    @NotNull
    @Column(name = "partner_company_name")
    String partnerCompanyName;

    /**
     * 自社担当者
     */
    @NotNull
    @Column(name = "partner_pic_name")
    String partnerPicName;

    /**
     * 自社担当者電話番号
     */
    @NotNull
    @Column(name = "partner_pic_tel")
    String partnerPicTel;

    /**
     * 自社担当者メールアドレス
     */
    @NotNull
    @Column(name = "partner_pic_email")
    String partnerPicEmail;

    /**
     * 備考
     */
    @Column(name = "remarks")
    String remarks;

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
