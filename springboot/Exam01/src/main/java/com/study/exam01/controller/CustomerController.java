package com.study.exam01.controller;

import com.study.exam01.dto.customer.QnAResponseDto;
import com.study.exam01.dto.member.MemberResponseDto;
import com.study.exam01.service.MemberService;
import com.study.exam01.service.QnAService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class CustomerController {
    private final MemberService memberService;
    private final QnAService qnaService;

    @GetMapping("/customer/one2one")
    public String one2one(Model model, HttpSession session) {
        Long userIdx = (Long) session.getAttribute("userIdx");
        if (userIdx != null) {
            model.addAttribute("member", new MemberResponseDto(memberService.findById(userIdx)));
        } else {
            return "redirect:/loginPlease";
        }
        return "pages/customer/customer01";
    }


    @GetMapping("/customer/qna")
    public String notice(Model model, HttpSession session,
                         @RequestParam(name = "page", defaultValue = "0") int page,
                         @RequestParam(name = "limit", defaultValue = "10") int limit,
                         @RequestParam(name = "searchType", defaultValue = "") String searchType,
                         @RequestParam(name = "searchValue", defaultValue = "") String searchValue) {
        Long userIdx = (Long) session.getAttribute("userIdx");
        if (userIdx != null) {
            model.addAttribute("member", new MemberResponseDto(memberService.findById(userIdx)));
        } else {
            return "redirect:/loginPlease";
        }
        Page<QnAResponseDto> qnAResponseDtoPage = qnaService.findPage(page, limit, searchType, searchValue);
        model.addAttribute("paging", qnAResponseDtoPage);
        model.addAttribute("searchType", searchType);
        model.addAttribute("searchValue", searchValue);
        return "pages/customer/customer02";
    }


    @GetMapping("/customer/qna/{idx}")
    public String noticeDetail(Model model, HttpSession session, @PathVariable(name = "idx") Long idx) {
        Long userIdx = (Long) session.getAttribute("userIdx");
        if (userIdx != null)
            model.addAttribute("member", new MemberResponseDto(memberService.findById(userIdx)));
        QnAResponseDto dto = qnaService.findByIdx(idx);
        model.addAttribute("qna", dto);
        return "pages/customer/customer02_4";
    }

    @GetMapping("/customer/qna/new")
    public String qnaNew(Model model, HttpSession session) {
        Long userIdx = (Long) session.getAttribute("userIdx");
        if (userIdx != null) {
            model.addAttribute("member", new MemberResponseDto(memberService.findById(userIdx)));
        } else {
            return "redirect:/loginPlease";
        }
        return "pages/customer/customer02";
    }

    @GetMapping("/customer/faq")
    public String faq(Model model, HttpSession session) {
        Long userIdx = (Long) session.getAttribute("userIdx");
        if (userIdx != null) {
            model.addAttribute("member", new MemberResponseDto(memberService.findById(userIdx)));
        } else {
            return "redirect:/loginPlease";
        }
        return "pages/customer/customer03";
    }
}
