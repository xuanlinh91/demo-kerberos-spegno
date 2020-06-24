package jp.co.ntt.common.dto.tax.bldg;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BldgErrUpdate {

	@NotBlank(message = "エラーワーニングデータIDは必須入力です。")
	public String errWarnDtIds;

	@NotBlank(message = "ビル名称は必須入力です。")
	@Size(min = 1, max = 255, message = "ビル名称の長さが最大桁数(255)を超えています。")
	public String bldgNm;

	@NotBlank(message = "ビル住所は必須入力です。")
	@Size(min = 1, max = 255, message = "ビル住所の長さが最大桁数(255)を超えています。")
	public String bldgAdd;

	@Min(value = 1, message = "ビル(原本)データIDを正しく入力してください。")
	public Integer bldgOrgDtId;

//	@NotBlank(message = "ビルコード(原本)は必須入力です。")
//	@Size(min = 1, max = 255, message = "ビルコード(原本)の長さが最大桁数(255)を超えています。")
//	public String bldgOrgCd;
//
//	@NotBlank(message = "ビル名称(原本)は必須入力です。")
//	@Size(min = 1, max = 255, message = "ビル名称(原本)の長さが最大桁数(255)を超えています。")
//	public String bldgOrgNm;
//
//	@NotBlank(message = "ビル住所(原本)は必須入力です。")
//	@Size(min = 1, max = 255, message = "ビル住所(原本)の長さが最大桁数(255)を超えています。")
//	public String bldgOrgAdd;

	@Min(value = 1, message = "ビル(補正後)データIDIDを正しく入力してください。")
	public Integer bldgCorrDtId;

//	@NotBlank(message = "ビルコード(補正後)は必須入力です。")
//	@Size(min = 1, max = 255, message = "ビルコード(補正後)の長さが最大桁数(255)を超えています。")
//	public String bldgCorrCd;
//
//	@NotBlank(message = "ビル名称(補正後)は必須入力です。")
//	@Size(min = 1, max = 255, message = "ビル名称(補正後)の長さが最大桁数(255)を超えています。")
//	public String bldgCorrNm;
//
//	@NotBlank(message = "ビル住所(補正後)は必須入力です。")
//	@Size(min = 1, max = 255, message = "ビル住所(補正後)の長さが最大桁数(255)を超えています。")
//	public String bldgCorrAdd;

}
