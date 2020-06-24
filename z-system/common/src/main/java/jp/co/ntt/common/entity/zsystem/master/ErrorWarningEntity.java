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
@Table(name = "TM_ErrorWarning")
public class ErrorWarningEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "data_id", unique = true, nullable = false)
	private Integer dataId;

	@Column(name = "correspondence", nullable = false, length = 1000)
	private String correspondence;

	@Column(name = "data_period", length = 20)
	private String dataPeriod;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "delete_datetime")
	private Date deleteDatetime;

	@Column(name = "delete_user", length = 64)
	private String deleteUser;

	@Column(name = "error_warning_content", nullable = false, length = 1000)
	private String errorWarningContent;

	@Column(name = "error_warning_id", nullable = false)
	private Short errorWarningId;

	@Column(name = "fiscal_period", length = 20)
	private String fiscalPeriod;

	@Column(name = "fiscal_period_type")
	private Byte fiscalPeriodType;

	@Column(name = "fiscal_year")
	private Short fiscalYear;

	@Column(name = "incremental_flag", nullable = false)
	private Byte incrementalFlag;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "insert_datetime", nullable = false)
	private Date insertDatetime;

	@Column(name = "insert_user", nullable = false, length = 64)
	private String insertUser;

	@Column(name = "report_id", nullable = false)
	private Short reportId;

	@Column(name = "report_org", length = 30)
	private String reportOrg;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "update_datetime", nullable = false)
	private Date updateDatetime;

	@Column(name = "update_user", nullable = false, length = 64)
	private String updateUser;

	@Column(nullable = false)
	private Integer version;
}
