package com.study.ex27_security_01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    @GetMapping("/")
    @ResponseBody
    public String main() {
        return "Spring Security web desu";
    }

    @GetMapping("/loginForm")
    public String loginForm() {
        return "loginForm";
    }
}
