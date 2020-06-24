package jp.co.ntt.common.dto.tax.bldg;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 会計期間-年度、会計期間-月
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountingPeriod implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotNull(message = "会計年度-年度は必須入力です。")
	@Min(value = 1900, message = "会計年度-年度を正しく入力してください。")
	public Integer year;
	@NotNull(message = "会計年度-月は必須入力です。")
	@Range(min = 1, max = 12, message = "会計年度-月を正しく入力してください。")
	public Integer month;
}
