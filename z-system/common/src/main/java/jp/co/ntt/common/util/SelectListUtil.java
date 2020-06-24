package jp.co.ntt.common.util;

import jp.co.ntt.common.constant.Constants;
import jp.co.ntt.common.dto.common.SubReport;

import java.util.ArrayList;
import java.util.List;

public final class SelectListUtil {
    private SelectListUtil() {}

    public static List<SubReport> generateSubReportList() {
        List<SubReport> subReportList = new ArrayList<>();
        subReportList.add(new SubReport(Constants.FLAT_RATE_TRA_IN_HBS, Constants.FLAT_RATE_TRA_IN_HBS_NAME));
        subReportList.add(new SubReport(Constants.FLAT_RATE_TRA_OWN_PS, Constants.FLAT_RATE_TRA_OWN_PS_NAME));
        subReportList.add(new SubReport(Constants.IDV_RATE_TRA_IN_HBS, Constants.IDV_RATE_TRA_IN_HBS_NAME));
        subReportList.add(new SubReport(Constants.IDV_RATE_TRA_OWN_PS, Constants.IDV_RATE_TRA_OWN_PS_NAME));
        return subReportList;
    }
}
