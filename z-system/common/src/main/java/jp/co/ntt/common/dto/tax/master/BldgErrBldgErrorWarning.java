package jp.co.ntt.common.dto.tax.master;

import org.springframework.beans.factory.annotation.Value;

public interface BldgErrBldgErrorWarning {

	@Value("#{target.version}")
	public Integer getVersion();

	@Value("#{target.error_warning_id}")
	public Short getErrorWarningId();

	@Value("#{target.error_warning_content}")
	public String getErrorWarningContent();

	@Value("#{target.correspondence}")
	public String getCorrespondence();

}
