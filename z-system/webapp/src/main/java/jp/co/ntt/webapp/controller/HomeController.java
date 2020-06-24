package jp.co.ntt.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController extends BaseController {
    @Autowired
    private Environment env;

    @GetMapping("/")
    @ResponseBody
    public String  home(Authentication authentication) {
        return  "Hello " + authentication.getName();
    }
}
