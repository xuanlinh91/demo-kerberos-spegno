package jp.co.ntt.common.dto.tax.bldg;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BldgErrBldgListView {

	private String status;

	private String bldgCd;

	private String bldgNm;

	private String bldgAdd;

	private String errWarnCont;

	private String corr;

	private String errWarnDtIds;
}
