package com.study.exam01.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class MemberController {
    @GetMapping("/login")
    public String login() {
        return "pages/member/login";
    }

    @GetMapping("/join")
    public String join() {
        return "pages/member/join";
    }

    @GetMapping("/join2")
    public String join2() {
        return "pages/member/join2";
    }

}
