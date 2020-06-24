package jp.co.ntt.common.entity.fatpc.tax.td;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "TD_DataVersion")
public class TaxDataVersionViewEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "data_version_id")
	private Integer dataVersionId;

	@Column(name = "report_id")
	private Short reportId;

	@Column(nullable = false)
	private Integer version;

	@Column(name = "incremental_flag")
	private Byte incrementalFlag;

}
