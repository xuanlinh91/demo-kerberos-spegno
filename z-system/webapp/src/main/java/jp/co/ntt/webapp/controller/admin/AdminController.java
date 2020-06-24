package jp.co.ntt.webapp.controller.admin;

import jp.co.ntt.common.constant.Constants;
import jp.co.ntt.webapp.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class AdminController extends BaseController {
    private String username() {
        // TODO: Get username from auth
        return "username";
    }

    @RequestMapping("/login")
    public ModelAndView login(ModelAndView modelAndView) {
        modelAndView.addObject("pageName", Constants.LOGIN);
        modelAndView.setViewName("admin/login/index");

        return modelAndView;
    }

    @RequestMapping("/menu")
    public ModelAndView menu(ModelAndView modelAndView) {
        modelAndView.addObject("pageName", Constants.MENU);
        modelAndView.addObject("username", username());
        modelAndView.setViewName("admin/menu/index");

        return modelAndView;
    }

    @RequestMapping("/master-list")
    public ModelAndView masterList(ModelAndView modelAndView) {
        modelAndView.addObject("pageName", Constants.MASTER_LIST);
        modelAndView.addObject("username", username());
        modelAndView.setViewName("admin/master_list/index");

        return modelAndView;
    }

    @RequestMapping("/user-master")
    public ModelAndView userMaster(ModelAndView modelAndView) {
        modelAndView.addObject("pageName", Constants.USER_MASTER);
        modelAndView.addObject("username", username());
        modelAndView.setViewName("admin/user_master/index");

        return modelAndView;
    }

    @RequestMapping("/user-master-add-edit")
    public ModelAndView userMasterAddEdit(ModelAndView modelAndView) {
        modelAndView.addObject("pageName", Constants.USER_MASTER_ADD_EDIT);
        modelAndView.addObject("username", username());
        modelAndView.setViewName("admin/user_master/user_master_add_edit/index");

        return modelAndView;
    }

    @RequestMapping("/report-master")
    public ModelAndView reportMaster(ModelAndView modelAndView) {
        modelAndView.addObject("pageName", Constants.REPORT_MASTER);
        modelAndView.addObject("username", username());
        modelAndView.setViewName("admin/report_master/index");

        return modelAndView;
    }

    @RequestMapping("/report-master-add-edit")
    public ModelAndView reportMasterAddEdit(ModelAndView modelAndView) {
        modelAndView.addObject("pageName", Constants.REPORT_MASTER_ADD_EDIT);
        modelAndView.addObject("username", username());
        modelAndView.setViewName("admin/report_master/report_master_add_edit/index");

        return modelAndView;
    }

    @RequestMapping("/rpa-master")
    public ModelAndView rpaMaster(ModelAndView modelAndView) {
        modelAndView.addObject("pageName", Constants.RPA_MASTER);
        modelAndView.addObject("username", username());
        modelAndView.setViewName("admin/rpa_master/index");

        return modelAndView;
    }

    @RequestMapping("/rpa-master-add-edit")
    public ModelAndView rpaMasterAddEdit(ModelAndView modelAndView) {
        modelAndView.addObject("pageName", Constants.RPA_MASTER_ADD_EDIT);
        modelAndView.addObject("username", username());
        modelAndView.setViewName("admin/rpa_master/rpa_master_add_edit/index");

        return modelAndView;
    }

    @RequestMapping("/system-master")
    public ModelAndView systemMaster(ModelAndView modelAndView) {
        modelAndView.addObject("pageName", Constants.SYSTEM_MASTER);
        modelAndView.addObject("username", username());
        modelAndView.setViewName("admin/system_master/index");

        return modelAndView;
    }

    @RequestMapping("/rpa-schedule")
    public ModelAndView rpaSchedule(ModelAndView modelAndView) {
        modelAndView.addObject("pageName", Constants.RPA_SCHEDULE);
        modelAndView.addObject("username", username());
        modelAndView.setViewName("admin/rpa_schedule/index");

        return modelAndView;
    }

    @RequestMapping("/rpa-schedule-add-edit")
    public ModelAndView rpaScheduleAddEdit(ModelAndView modelAndView) {
        // Add code here
        return modelAndView;
    }

    @RequestMapping("/rpa-schedule-history")
    public ModelAndView rpaScheduleHistory(ModelAndView modelAndView) {
        // Add code here
        return modelAndView;
    }

    @RequestMapping("/logs")
    public ModelAndView logs(ModelAndView modelAndView) {
        modelAndView.addObject("pageName", Constants.LOGS);
        modelAndView.addObject("username", username());
        modelAndView.setViewName("admin/logs/index");

        return modelAndView;
    }
}
