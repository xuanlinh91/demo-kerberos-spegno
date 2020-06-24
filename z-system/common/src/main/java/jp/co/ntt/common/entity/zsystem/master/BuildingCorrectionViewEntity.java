package jp.co.ntt.common.entity.zsystem.master;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "TM_BuildingCorrection")
public class BuildingCorrectionViewEntity {

	@EmbeddedId
	private BuildingCorrectionPK id;

	@Column(name = "company_code", nullable = false, length = 255)
	private String companyCode;

	@Column(name = "company_name", length = 255)
	private String companyName;

	@Column(name = "building_code", length = 255)
	private String buildingCode;

	@Column(name = "building_name", length = 255)
	private String buildingName;

	@Column(length = 255)
	private String address;

	@Column(name = "building_code_correction", length = 255)
	private String buildingCodeCorrection;

	@Column(name = "building_name_correction", length = 255)
	private String buildingNameCorrection;

	@Column(name = "address_correction", length = 255)
	private String addressCorrection;

	@Column(name = "changed_month", length = 255)
	private String changedMonth;

	@Column(name = "changed_reason", length = 255)
	private String changedReason;
}
