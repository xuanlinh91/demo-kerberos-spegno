package jp.co.ntt.common.entity.kaikei.master;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "TM_AcctNonParticipatingCmp")
public class NonParticipatingCompanyMasterEntity {
    /**
     * 非参画会社ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "company_id")
    private Integer companyId;

    /**
     * 非参画会社名
     */
    @Column(name = "company_name")
    String companyName;

    /**
     * 登録ユーザ
     */
    @Column(name = "insert_user")
    private String insertUser;

    /**
     * 更新ユーザ
     */
    @Column(name = "update_user")
    private String updateUser;

    /**
     * 更新日時
     */
    @Column(name = "update_datetime", updatable = false)
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    /**
     * 登録日時
     */
    @Column(name = "insert_datetime", insertable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;
}
