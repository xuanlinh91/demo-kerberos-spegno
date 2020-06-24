package jp.co.ntt.common.entity.fatpc.tax.master;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * ビルマスタ(原本)
 * 
 */
@Data
@Entity
@Table(name = "TM_BuildingOrigin")
public class BuildingOriginViewEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "data_id", unique = true, nullable = false)
	private Integer dataId;

	@Column(name = "building_code_origin", nullable = false, length = 255)
	private String buildingCodeOrigin;

	@Column(name = "building_name_origin", length = 255)
	private String buildingNameOrigin;

	@Column(length = 255)
	private String address;

}