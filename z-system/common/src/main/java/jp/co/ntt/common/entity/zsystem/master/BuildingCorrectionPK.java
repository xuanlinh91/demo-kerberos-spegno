package jp.co.ntt.common.entity.zsystem.master;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class BuildingCorrectionPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "account_period_year", unique = true, nullable = false, length = 4)
	private String accountPeriodYear;

	@Column(name = "account_period_month", unique = true, nullable = false, length = 2)
	private String accountPeriodMonth;

	@Column(name = "company_buiding_code", unique = true, nullable = false, length = 255)
	private String companyBuidingCode;
}
