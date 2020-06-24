package jp.co.ntt.webapp.controller.main;

import jp.co.ntt.common.constant.Constants;
import jp.co.ntt.common.util.SelectListUtil;
import jp.co.ntt.webapp.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("/accounting")
@Controller
public class KaikeiController extends BaseController {
    private Map<String, String> getYearList() {
        Map<String, String> yearList = new HashMap<String, String>();
        // TODO: Add yearList logic here
        yearList.put("2018", "2018年度");
        yearList.put("2019", "2019年度");
        yearList.put("2020", "2020年度");
        return yearList;
    }

    @RequestMapping({"/", "dashboard"})
    public ModelAndView dashboard(ModelAndView modelAndView) {
        modelAndView.addObject("yearList", getYearList());
        modelAndView.addObject("crumbFirst", Constants.ACCOUNTING_FINANCIAL_CHECK);
        modelAndView.addObject("crumbSecond", Constants.ACCOUNTING_DASHBOARD);
        modelAndView.setViewName("main/accounting/dashboard.html");
        return modelAndView;
    }

    @RequestMapping("/incomplete")
    public ModelAndView incomplete(ModelAndView modelAndView) {
        modelAndView.addObject("yearList", getYearList());
        modelAndView.addObject("subReportList", SelectListUtil.generateSubReportList());
        modelAndView.addObject("crumbFirst", Constants.ACCOUNTING_FINANCIAL_CHECK);
        modelAndView.addObject("crumbSecond", Constants.ACCOUNTING_INCOMPLETE);
        modelAndView.setViewName("main/accounting/incomplete.html");
        return modelAndView;
    }

    @RequestMapping("/unaccepted")
    public ModelAndView unaccepted(ModelAndView modelAndView) {
        modelAndView.addObject("yearList", getYearList());
        modelAndView.addObject("crumbFirst", Constants.ACCOUNTING_FINANCIAL_CHECK);
        modelAndView.addObject("crumbSecond", Constants.ACCOUNTING_UNACCEPTED);
        modelAndView.setViewName("main/accounting/unaccepted.html");
        return modelAndView;
    }

    @RequestMapping("/report-creation")
    public ModelAndView reportCreation(ModelAndView modelAndView) {
        modelAndView.addObject("crumbFirst", Constants.ACCOUNTING_FINANCIAL_CHECK);
        modelAndView.addObject("crumbSecond", Constants.ACCOUNTING_REPORT_CREATION);
        modelAndView.setViewName("main/accounting/reportCreation.html");
        return modelAndView;
    }

    @RequestMapping("/function-key-setting")
    public ModelAndView functionKeySetting(ModelAndView modelAndView) {
        modelAndView.addObject("crumbFirst", Constants.ACCOUNTING_FUNCTION_KEY_SETTING);
        modelAndView.setViewName("main/accounting/functionKeySetting.html");
        return modelAndView;
    }

    @RequestMapping("/scheduler-setting")
    public ModelAndView schedulerSetting(ModelAndView modelAndView) {
        modelAndView.addObject("crumbFirst", Constants.ACCOUNTING_SCHEDULER_SETTING);
        modelAndView.setViewName("main/accounting/schedulerSetting.html");
        return modelAndView;
    }

    @RequestMapping("/master-setting")
    public ModelAndView masterSetting(ModelAndView modelAndView) {
        modelAndView.addObject("crumbFirst", Constants.ACCOUNTING_MASTER_SETTING);
        modelAndView.setViewName("main/accounting/masterSetting.html");
        return modelAndView;
    }
}
