package jp.co.ntt.common.entity.kaikei.shared;


import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Embeddable
public class Audit {
    /**
     * 登録ユーザ
     */
    @NotNull
    @Column(name = "insert_user", updatable = false)
    @CreatedBy
    private String insertUser;

    /**
     * 更新ユーザ
     */
    @NotNull
    @Column(name = "update_user")
    @LastModifiedBy
    private String updateUser;

    /**
     * 更新日時
     */
    @NotNull
    @Column(name = "update_datetime")
    @LastModifiedDate
    private LocalDateTime updatedAt;

    /**
     * 登録日時
     */
    @NotNull
    @Column(name = "insert_datetime", updatable = false)
    @CreatedDate
    private LocalDateTime createdAt;
}
