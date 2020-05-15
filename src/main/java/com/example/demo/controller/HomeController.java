package com.example.demo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController{
    @GetMapping("/")
    @ResponseBody
    public String  home() {
        return  "Hello";
    }

    @GetMapping("/test")
    @ResponseBody
    public String  home(Authentication authentication) {
        return  "Test " + authentication.getName();
    }
}
