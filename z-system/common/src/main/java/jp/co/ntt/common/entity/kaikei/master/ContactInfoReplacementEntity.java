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
@Table(name = "TM_AccContactInfoReplacement")
public class ContactInfoReplacementEntity {

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
    @Column(name = "matching_email")
    String matchingEmail;

    /**
     * 相手会社名
     */
    @NotNull
    @Column(name = "matching_name_code")
    String matchingNameCode;

    /**
     * 自社担当者
     */
    @NotNull
    @Column(name = "replace_pic_name")
    String replacePicName;

    /**
     * 自社担当者電話番号
     */
    @NotNull
    @Column(name = "replace_pic_tel")
    String replacePicTel;

    /**
     * 自社担当者メールアドレス
     */
    @NotNull
    @Column(name = "replace_pic_email")
    String replacePicEmail;

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
