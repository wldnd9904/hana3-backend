package com.study.exam01.controller;

import com.study.exam01.dto.member.MemberResponseDto;
import com.study.exam01.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final MemberService memberService;

    @GetMapping("/")
    public String index(Model model, HttpSession session) {
        Long userIdx = (Long) session.getAttribute("userIdx");
        if (userIdx != null)
            model.addAttribute("member", new MemberResponseDto(memberService.findById(userIdx)));
        return "index";
    }

    @GetMapping("/company/company01")
    public String company01(Model model, HttpSession session) {
        Long userIdx = (Long) session.getAttribute("userIdx");
        if (userIdx != null)
            model.addAttribute("member", new MemberResponseDto(memberService.findById(userIdx)));
        return "pages/company/company01";
    }

    @GetMapping("/company/company03")
    public String company03(Model model, HttpSession session) {
        Long userIdx = (Long) session.getAttribute("userIdx");
        if (userIdx != null)
            model.addAttribute("member", new MemberResponseDto(memberService.findById(userIdx)));
        return "pages/company/company03";
    }

    @GetMapping("/business/business01")
    public String business01(Model model, HttpSession session) {
        Long userIdx = (Long) session.getAttribute("userIdx");
        if (userIdx != null)
            model.addAttribute("member", new MemberResponseDto(memberService.findById(userIdx)));
        return "pages/business/business01";
    }

    @GetMapping("/product/product01")
    public String product01(Model model, HttpSession session) {
        Long userIdx = (Long) session.getAttribute("userIdx");
        if (userIdx != null)
            model.addAttribute("member", new MemberResponseDto(memberService.findById(userIdx)));
        return "pages/product/product01";
    }

    @GetMapping("/product/product01_1")
    public String product01_1(Model model, HttpSession session) {
        Long userIdx = (Long) session.getAttribute("userIdx");
        if (userIdx != null)
            model.addAttribute("member", new MemberResponseDto(memberService.findById(userIdx)));
        return "pages/product/product01_1";
    }

    @GetMapping("/loginPlease")
    @ResponseBody
    public String loginPlease() {
        return "<script>alert('로그인이 필요합니다.');location.href ='/login';</script>";
    }

    @GetMapping("/admin")
    public String adminLogin() {
        return "redirect:/admin/";
    }
}
