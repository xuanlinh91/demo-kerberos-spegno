package jp.co.ntt.common.dto.tax.td;

import org.springframework.beans.factory.annotation.Value;

public interface BldgErrBldgTieUpErrorWarningData {

	@Value("#{target.error_warning_data_ids}")
	public String getErrorWarningDataIds();

	@Value("#{target.error_warning_id}")
	public Short getErrorWarningId();

	@Value("#{target.status}")
	public String getStatus();

	@Value("#{target.building_code}")
	public String getBuildingCode();

	@Value("#{target.building_name}")
	public String getBuildingName();

	@Value("#{target.building_address}")
	public String getBuildingAddress();
}
