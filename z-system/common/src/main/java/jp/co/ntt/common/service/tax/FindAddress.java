
package jp.co.ntt.common.service.tax;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindAddress {

	public static String[] splitAddress(String text) {
		// 住所文字列を空白で分割する
		text = text.replaceAll("[　]", " ");
		text = text.trim();
		String[] arrText = text.split(" ");
		if (arrText.length == 0) {
			return null;
		}

		// 住所文字列を空白で分割した最初の要素だけ使用する
		// 例)住所が「大阪府大阪市都島区東野田町４丁目１５番８２号 ＮＴＴ西日本新京橋ビル ＮＴＴ西日本新京橋ビル」の場合
		// 「大阪府大阪市都島区東野田町４丁目１５番８２号」だけ使用する。
		String editedText = arrText[0];
		String pattern1 = "(^.{2,3}?[都道府県])";
		String pattern2 = "((?:旭川|伊達|石狩|盛岡|奥州|田村|南相馬|那須塩原|東村山|武蔵村山|羽村|十日町|上越|富山|野々市|大町|蒲郡|四日市|姫路|大和郡山|廿日市|下松|岩国|田川|大村|宮古|富良野|別府|佐伯|黒部|小諸|塩尻|玉野|周南)市|(?:余市|高市|[^市]{2,3}?)郡"
				+ "(?:玉村|大町|.{1,5}?)[町村]|(?:.{1,4}市)?[^町]{1,4}?区|.{1,7}?[市町村])(.*[^0-9０-９一二三四五六七八九\\-\\－\\丁目\\丁\\番地\\番\\号*])(.*)";

		Pattern ptn = Pattern.compile(pattern1);
		Matcher mach = ptn.matcher(editedText); // 分割前住所
		boolean result = mach.find();
		String[] retArray = null;
		if (result) {
			// 都道府県がある場合
			String pattern3 = pattern1 + pattern2;
			ptn = Pattern.compile(pattern3);
			mach = ptn.matcher(editedText);
			result = mach.find();
			if (result) {
				// 都道府県・市町村区郡・番地前・番地
				retArray = new String[] { mach.group(1) == null ? "" : mach.group(1), mach.group(2), mach.group(3),
						mach.group(4) };
			} else {
				// 都道府県がない場合
				ptn = Pattern.compile(pattern2);
				mach = ptn.matcher(editedText);
				result = mach.find();
				if (result) {
					retArray = new String[] { mach.group(1) == null ? "" : mach.group(1), mach.group(2),
							mach.group(3) };
				}
			}

		}
		return retArray;
	}
}
