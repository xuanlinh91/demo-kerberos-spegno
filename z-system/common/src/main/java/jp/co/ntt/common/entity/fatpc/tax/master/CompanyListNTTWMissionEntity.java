package jp.co.ntt.common.entity.fatpc.tax.master;

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
@Table(name = "TM_CompanyListNTTWMission")
public class CompanyListNTTWMissionEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "data_id", unique = true, nullable = false)
	private Integer dataId;

	@Column(name = "company_code", nullable = false, length = 255)
	private String companyCode;

	@Column(name = "company_name", length = 255)
	private String companyName;

	@Column(name = "data_period", length = 20)
	private String dataPeriod;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "delete_datetime")
	private Date deleteDatetime;

	@Column(name = "delete_user", length = 64)
	private String deleteUser;

	@Column(name = "fiscal_period", length = 20)
	private String fiscalPeriod;

	@Column(name = "fiscal_period_type")
	private Byte fiscalPeriodType;

	@Column(name = "fiscal_year")
	private Short fiscalYear;

	@Column(name = "incremental_flag", nullable = false)
	private Byte incrementalFlag;

	@Column(nullable = false)
	private Integer version;

	@Column(name = "report_id", nullable = false)
	private Short reportId;

	@Column(name = "report_org", length = 30)
	private String reportOrg;

	@Column(name = "insert_user", nullable = false, length = 64)
	private String insertUser;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "insert_datetime", nullable = false)
	private Date insertDatetime;

	@Column(name = "update_user", nullable = false, length = 64)
	private String updateUser;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "update_datetime", nullable = false)
	private Date updateDatetime;

}
