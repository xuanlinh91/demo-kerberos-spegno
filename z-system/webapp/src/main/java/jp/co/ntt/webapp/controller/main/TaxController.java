package jp.co.ntt.webapp.controller.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/tax")
@Controller
public class TaxController {
	@RequestMapping("/bldg-err-bldg")
	public ModelAndView bldgErrBldg(ModelAndView modelAndView) {
		modelAndView.setViewName("main/local_tax/errorBldgMaster.html");
		return modelAndView;
	}

	@RequestMapping("/bldg-err-dispatch")
	public ModelAndView bldgErrDispatch(ModelAndView modelAndView) {
		modelAndView.setViewName("main/local_tax/errorOtherDispatch.html");
		return modelAndView;
	}

	@RequestMapping("/bldg-err-floor")
	public ModelAndView bldgErrFloor(ModelAndView modelAndView) {
		modelAndView.setViewName("main/local_tax/errorFloorArea.html");
		return modelAndView;
	}
}
