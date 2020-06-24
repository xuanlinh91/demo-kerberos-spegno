package jp.co.ntt.common.entity.zsystem.master;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
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
@Table(name = "TM_BuildingCorrection")
@EntityListeners(AuditingEntityListener.class)
public class BuildingCorrectionEntity {

	@EmbeddedId
	private BuildingCorrectionPK id;

	@Column(length = 255)
	private String address;

	@Column(name = "address_correction", length = 255)
	private String addressCorrection;

	@Column(name = "building_code", length = 255)
	private String buildingCode;

	@Column(name = "building_code_correction", length = 255)
	private String buildingCodeCorrection;

	@Column(name = "building_name", length = 255)
	private String buildingName;

	@Column(name = "building_name_correction", length = 255)
	private String buildingNameCorrection;

	@Column(name = "changed_month", length = 255)
	private String changedMonth;

	@Column(name = "changed_reason", length = 255)
	private String changedReason;

	@Column(name = "company_code", nullable = false, length = 255)
	private String companyCode;

	@Column(name = "company_name", length = 255)
	private String companyName;

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
