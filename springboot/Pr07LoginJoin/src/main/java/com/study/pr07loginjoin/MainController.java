package com.study.pr07loginjoin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.ArrayList;

@Controller
public class MainController {
    @Autowired
    MemberList memberList;

    @GetMapping("/")
    public String index() {
        return "login";
    }

    @GetMapping("/join-form")
    public String joinForm() {
        return "join";
    }

    @PostMapping("/login")
    public String login(@RequestParam String inputName, @RequestParam String inputPw, Model model) {
        System.out.println("로그인: " + inputName + ", " + inputPw);
        if (memberList.login(inputName, inputPw)) {
            model.addAttribute("alertMessage", "로그인 성공!");
            model.addAttribute("alertStatus", "alert-success");
            return "login";
        }
        model.addAttribute("alertMessage", "아이디와 비밀번호를 확인해주세요.");
        model.addAttribute("alertStatus", "alert-danger");
        return "login";
    }

    @GetMapping("/check-dupl")
    public String checkDuplicate(@RequestParam String inputName, Model model) {
        if (memberList.isDuplicate(inputName)) {
            model.addAttribute("alertMessage", "중복된 아이디가 있습니다.");
            model.addAttribute("alertStatus", "alert-primary");
            model.addAttribute("inputName", inputName);
            return "join";
        }
        model.addAttribute("alertMessage", "사용 가능한 아이디입니다.");
        model.addAttribute("alertStatus", "alert-success");
        model.addAttribute("inputName", inputName);
        return "join";
    }

    @PostMapping("/join")
    public String join(@RequestParam String inputName, @RequestParam String inputPw, @RequestParam String inputEmail, Model model) {
        if (memberList.join(new Member(inputName, inputPw, inputEmail, LocalDate.now()))) {
            model.addAttribute("alertMessage", "성공적으로 회원가입 되었습니다.");
            model.addAttribute("alertStatus", "alert-success");
            memberList.printAll();
            return "login";
        } else {
            model.addAttribute("alertMessage", "중복된 아이디가 있습니다.");
            model.addAttribute("alertStatus", "alert-primary");
            return "login";
        }
    }
}
