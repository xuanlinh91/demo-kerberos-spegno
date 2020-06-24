package jp.co.ntt.common.dto.tax.bldg;

import java.util.List;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BldgErrListUpdate {

	@NotNull(message = "会計年度月は必須入力です。")
	public AccountingPeriod accPeriod;

	@NotNull(message = "ビル情報は必須入力です。")
	public List<BldgErrUpdate> bldgErrList;
}
