package jp.co.ntt.common.entity.kaikei.master;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "TM_Organization")
public class OrganizationMasterEntity {
    /**
     * 組織コード
     */
    @Id
    @NotNull
    @Column(name = "org_code")
    private String orgCode;

    /**
     * エリア
     */
    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "regional_code", nullable = false)
    private RegionalMasterEntity regional;

    /**
     * 組織名
     */
    @NotNull
    @Column(name = "org_name")
    private String orgName;

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
