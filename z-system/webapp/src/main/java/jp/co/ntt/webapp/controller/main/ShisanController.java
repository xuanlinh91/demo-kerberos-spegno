package jp.co.ntt.webapp.controller.main;

import jp.co.ntt.webapp.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/shisan")
@Controller
public class ShisanController extends BaseController {
    @RequestMapping("/all")
    public ModelAndView menu(ModelAndView modelAndView) {
        modelAndView.setViewName("main/shisan/all.html");
        return modelAndView;
    }

    @RequestMapping("/daily-bukkan")
    public ModelAndView dailyBukkan(ModelAndView modelAndView) {
        modelAndView.setViewName("main/shisan/all.html");
        return modelAndView;
    }

    @RequestMapping("/daily-buka")
    public ModelAndView dailyBuka(ModelAndView modelAndView) {
        modelAndView.setViewName("main/shisan/all.html");
        return modelAndView;
    }

    @RequestMapping("/daily-mission")
    public ModelAndView dailyMission(ModelAndView modelAndView) {
        modelAndView.setViewName("main/shisan/all.html");
        return modelAndView;
    }
}
