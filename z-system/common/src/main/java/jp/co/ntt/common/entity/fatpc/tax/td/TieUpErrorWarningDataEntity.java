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
@Table(name = "TD_TieUpErrorWarningData")
public class TieUpErrorWarningDataEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "error_warning_data_id", unique = true, nullable = false)
	private Integer errorWarningDataId;

	@Column(name = "account_period_month", nullable = false, length = 2)
	private String accountPeriodMonth;

	@Column(name = "account_period_year", nullable = false, length = 4)
	private String accountPeriodYear;

	@Column(name = "building_address", length = 255)
	private String buildingAddress;

	@Column(name = "building_code", length = 255)
	private String buildingCode;

	@Column(name = "building_name", length = 255)
	private String buildingName;

	@Column(name = "company_code", length = 255)
	private String companyCode;

	@Column(name = "db_purpose_id", nullable = false)
	private Byte dbPurposeId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "delete_datetime")
	private Date deleteDatetime;

	@Column(name = "delete_user", length = 64)
	private String deleteUser;

	@Column(name = "error_warning_id", nullable = false)
	private Short errorWarningId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "insert_datetime", nullable = false)
	private Date insertDatetime;

	@Column(name = "insert_user", nullable = false, length = 64)
	private String insertUser;

	@Column(length = 2)
	private String status;

	@Column(name = "tieup_type", nullable = false, length = 1)
	private String tieupType;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "update_datetime", nullable = false)
	private Date updateDatetime;

	@Column(name = "update_user", nullable = false, length = 64)
	private String updateUser;
}
