package jp.co.ntt.common.entity.zsystem.master;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
@Table(name = "TM_DbPurpose")
public class DbPurposeEntity {
	@Id
	@Column(name = "db_purpose_id", unique = true, nullable = false)
	private byte dbPurposeId;

	@Column(name = "db_purpose", nullable = false, length = 15)
	private String dbPurpose;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "delete_datetime")
	private Date deleteDatetime;

	@Column(name = "delete_user", length = 64)
	private String deleteUser;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "insert_datetime", nullable = false)
	private Date insertDatetime;

	@Column(name = "insert_user", nullable = false, length = 64)
	private String insertUser;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "update_datetime", nullable = false)
	private Date updateDatetime;

	@Column(name = "update_user", nullable = false, length = 64)
	private String updateUser;
}
