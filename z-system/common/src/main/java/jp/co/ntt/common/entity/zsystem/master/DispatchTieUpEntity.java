package jp.co.ntt.common.entity.zsystem.master;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@Data
@Entity
@Table(name = "TM_DispatchTieUp")
@EntityListeners(AuditingEntityListener.class)
public class DispatchTieUpEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "data_id", unique = true, nullable = false)
	private Integer dataId;

	@Column(name = "account_period_month", nullable = false, length = 2)
	private String accountPeriodMonth;

	@Column(name = "account_period_year", nullable = false, length = 4)
	private String accountPeriodYear;

	@Column(name = "building_address_correction", length = 255)
	private String buildingAddressCorrection;

	@Column(name = "building_address_dispatch", length = 255)
	private String buildingAddressDispatch;

	@Column(name = "building_address_origin", length = 255)
	private String buildingAddressOrigin;

	@Column(name = "building_code_correction", length = 255)
	private String buildingCodeCorrection;

	@Column(name = "building_code_origin", length = 255)
	private String buildingCodeOrigin;

	@Column(name = "building_name_correction", length = 255)
	private String buildingNameCorrection;

	@Column(name = "building_name_dispatch", length = 255)
	private String buildingNameDispatch;

	@Column(name = "building_name_origin", length = 255)
	private String buildingNameOrigin;

	@Column(name = "corporate_inhabitant_tax_correction", length = 255)
	private String corporateInhabitantTaxCorrection;

	@Column(name = "municipality_correction", length = 255)
	private String municipalityCorrection;

	@Column(name = "prefecture_correction", length = 255)
	private String prefectureCorrection;

	@CreatedBy
	@Column(name = "insert_user", nullable = false, length = 64)
	private String insertUser;

	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "insert_datetime", nullable = false)
	private Date insertDatetime;

	@LastModifiedBy
	@Column(name = "update_user", nullable = false, length = 64)
	private String updateUser;

	@LastModifiedDate
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "update_datetime", nullable = false)
	private Date updateDatetime;

	@Column(name = "delete_user", length = 64)
	private String deleteUser;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "delete_datetime")
	private Date deleteDatetime;

}
