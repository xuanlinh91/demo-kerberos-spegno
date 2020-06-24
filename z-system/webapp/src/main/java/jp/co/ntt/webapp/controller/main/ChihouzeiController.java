package jp.co.ntt.webapp.controller.main;

import jp.co.ntt.common.constant.Constants;
import jp.co.ntt.webapp.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/local-tax")
@Controller
public class ChihouzeiController extends BaseController {
    private Map<String, String> getYearList() {
        Map<String, String> yearList = new HashMap<>();
        // TODO: Use API response to populate 会計期間 select
        yearList.put("2018", "2018年度");
        yearList.put("2019", "2019年度");
        yearList.put("2020", "2020年度");
        return yearList;
    }

    @RequestMapping({"/", "error-bldg-master"})
    public ModelAndView errorBldgMaster(ModelAndView modelAndView) {
        modelAndView.addObject("yearList", getYearList());
        modelAndView.addObject("crumbFirst", Constants.LOCAL_TAX_ERROR);
        modelAndView.addObject("crumbSecond", Constants.LOCAL_TAX_ERROR_BLDG_MASTER);
        modelAndView.setViewName("main/local_tax/errorBldgMaster.html");
        return modelAndView;
    }

    @RequestMapping("error-other-dispatch")
    public ModelAndView errorOtherDispatch(ModelAndView modelAndView) {
        modelAndView.addObject("yearList", getYearList());
        modelAndView.addObject("crumbFirst", Constants.LOCAL_TAX_ERROR);
        modelAndView.addObject("crumbSecond", Constants.LOCAL_TAX_ERROR_OTHER_DISPATCH);
        modelAndView.setViewName("main/local_tax/errorOtherDispatch.html");
        return modelAndView;
    }

    @RequestMapping("error-floor-area")
    public ModelAndView errorFloorArea(ModelAndView modelAndView) {
        modelAndView.addObject("yearList", getYearList());
        modelAndView.addObject("crumbFirst", Constants.LOCAL_TAX_ERROR);
        modelAndView.addObject("crumbSecond", Constants.LOCAL_TAX_ERROR_FLOOR_AREA);
        modelAndView.setViewName("main/local_tax/errorFloorArea.html");
        return modelAndView;
    }

    @RequestMapping("update-bldg-master")
    public ModelAndView updateBldgMaster(ModelAndView modelAndView) {
        modelAndView.addObject("yearList", getYearList());
        modelAndView.addObject("crumbFirst", Constants.LOCAL_TAX_UPDATE);
        modelAndView.addObject("crumbSecond", Constants.LOCAL_TAX_UPDATE_BLDG_MASTER);
        modelAndView.setViewName("main/local_tax/updateBldgMaster.html");
        return modelAndView;
    }

    @RequestMapping("update-other-dispatch")
    public ModelAndView updateOtherDispatch(ModelAndView modelAndView) {
        modelAndView.addObject("yearList", getYearList());
        modelAndView.addObject("crumbFirst", Constants.LOCAL_TAX_UPDATE);
        modelAndView.addObject("crumbSecond", Constants.LOCAL_TAX_UPDATE_OTHER_DISPATCH);
        modelAndView.setViewName("main/local_tax/updateOtherDispatch.html");
        return modelAndView;
    }

    @RequestMapping("update-floor-area")
    public ModelAndView updateFloorArea(ModelAndView modelAndView) {
        modelAndView.addObject("yearList", getYearList());
        modelAndView.addObject("crumbFirst", Constants.LOCAL_TAX_UPDATE);
        modelAndView.addObject("crumbSecond", Constants.LOCAL_TAX_UPDATE_FLOOR_AREA);
        modelAndView.setViewName("main/local_tax/updateFloorArea.html");
        return modelAndView;
    }

    @RequestMapping("summary-report")
    public ModelAndView summaryReport(ModelAndView modelAndView) {
        modelAndView.addObject("yearList", getYearList());
        modelAndView.addObject("crumbFirst", Constants.LOCAL_TAX_SUMMARY_REPORT);
        modelAndView.setViewName("main/local_tax/summaryReport.html");
        return modelAndView;
    }

    @RequestMapping("/scheduler-setting")
    public ModelAndView schedulerSetting(ModelAndView modelAndView) {
        modelAndView.addObject("crumbFirst", Constants.LOCAL_TAX_SCHEDULER_SETTING);
        modelAndView.setViewName("main/local_tax/schedulerSetting.html");
        return modelAndView;
    }

    @RequestMapping("/master-setting")
    public ModelAndView masterSetting(ModelAndView modelAndView) {
        modelAndView.addObject("crumbFirst", Constants.LOCAL_TAX_MASTER_SETTING);
        modelAndView.setViewName("main/local_tax/masterSetting.html");
        return modelAndView;
    }
}
