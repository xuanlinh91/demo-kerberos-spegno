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
@Table(name = "TM_AcctDepartmentTask")
public class DepartmentMasterEntity {
    /**
     *
     */
    @Id
    @NotNull
    @Column(name = "department_code")
    private String departmentCode;

    /**
     *
     */
    @NotNull
    @Column(name = "department_name")
    private String departmentName;

    /**
     *
     */
    @NotNull
    @Column(name = "division")
    private String division;

    /**
     *
     */
    @NotNull
    @Column(name = "organization_code")
    private String organizationCode;

    /**
     *
     */
    @NotNull
    @Column(name = "organization_name")
    private String organizationName;

    /**
     *
     */
    @NotNull
    @Column(name = "remarks")
    private String remarks;

    /**
     *
     */
    @NotNull
    @Column(name = "task_name")
    private String taskName;

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
