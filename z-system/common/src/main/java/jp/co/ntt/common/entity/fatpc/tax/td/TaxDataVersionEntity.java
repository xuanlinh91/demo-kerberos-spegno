package jp.co.ntt.common.entity.fatpc.tax.td;

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
@Table(name = "TD_DataVersion")
public class TaxDataVersionEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "data_version_id")
	private Integer dataVersionId;

	@Column(name = "data_period")
	private String dataPeriod;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "delete_datetime")
	private Date deleteDatetime;

	@Column(name = "delete_user")
	private String deleteUser;

	@Column(name = "fiscal_period")
	private String fiscalPeriod;

	@Column(name = "fiscal_period_type")
	private Byte fiscalPeriodType;

	@Column(name = "fiscal_year")
	private Short fiscalYear;

	@Column(name = "incremental_flag")
	private Byte incrementalFlag;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "insert_datetime")
	private Date insertDatetime;

	@Column(name = "insert_user")
	private String insertUser;

	@Column(name = "report_id")
	private Short reportId;

	@Column(name = "report_org")
	private String reportOrg;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "update_datetime")
	private Date updateDatetime;

	@Column(name = "update_user")
	private String updateUser;

	@Column(nullable = false)
	private Integer version;

}
