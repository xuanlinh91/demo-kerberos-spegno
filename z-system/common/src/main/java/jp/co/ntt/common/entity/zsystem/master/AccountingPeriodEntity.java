package jp.co.ntt.common.entity.zsystem.master;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
@Table(name = "TM_AccountingPeriod")
public class AccountingPeriodEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "data_id", unique = true, nullable = false)
	private Integer dataId;

	@Column(name = "beginning_of_period", nullable = false)
	private Integer beginningOfPeriod;

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
