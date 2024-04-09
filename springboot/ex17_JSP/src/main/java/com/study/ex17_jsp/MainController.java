package com.study.ex17_jsp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MainController {
    @GetMapping("/{num}")
    public String main(@PathVariable String num) {
        return "ex" + num;
    }
}
