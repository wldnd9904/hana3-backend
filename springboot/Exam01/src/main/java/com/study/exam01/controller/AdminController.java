package com.study.exam01.controller;

import com.study.exam01.domain.community.Notice;
import com.study.exam01.dto.member.MemberResponseDto;
import com.study.exam01.dto.notice.NoticeResponseDto;
import com.study.exam01.service.AdminService;
import com.study.exam01.service.MemberService;
import com.study.exam01.service.NoticeService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    private final AdminService adminService;
    private final MemberService memberService;
    private final NoticeService noticeService;

    @GetMapping("/")
    public String adminLogin(Model model, HttpSession session) {
        Long userIdx = (Long) session.getAttribute("adminIdx");
        if (userIdx != null)
            return "redirect:/admin/member";
        return "/pages/admin/admin_login";
    }

    @GetMapping("/member")
    public String adminMember(Model model, HttpSession session,
                              @RequestParam(name = "page", defaultValue = "0") int page,
                              @RequestParam(name = "limit", defaultValue = "5") int limit,
                              @RequestParam(name = "searchType", defaultValue = "") String searchType,
                              @RequestParam(name = "searchValue", defaultValue = "") String searchValue,
                              @RequestParam(name = "sortType", defaultValue = "idAsc") String sortType
    ) {
        Long userIdx = (Long) session.getAttribute("adminIdx");
        if (userIdx == null)
            return "redirect:/admin/";
        else
            model.addAttribute("member", new MemberResponseDto(adminService.findById(userIdx)));
        Page<MemberResponseDto> memberResponseDtoPage = memberService.findPage(page, limit, searchType, searchValue, sortType);
        model.addAttribute("paging", memberResponseDtoPage);
        model.addAttribute("searchType", searchType);
        model.addAttribute("searchValue", searchValue);
        model.addAttribute("sortType", sortType);

        return "/pages/admin/admin_member";
    }

    @GetMapping("/notice")
    public String adminNotice(Model model, HttpSession session,
                              @RequestParam(name = "page", defaultValue = "0") int page,
                              @RequestParam(name = "limit", defaultValue = "5") int limit,
                              @RequestParam(name = "searchType", defaultValue = "") String searchType,
                              @RequestParam(name = "searchValue", defaultValue = "") String searchValue,
                              @RequestParam(name = "sortType", defaultValue = "idAsc") String sortType
    ) {
        Long userIdx = (Long) session.getAttribute("adminIdx");
        if (userIdx == null)
            return "redirect:/admin/";
        else
            model.addAttribute("member", new MemberResponseDto(adminService.findById(userIdx)));
        Page<NoticeResponseDto> noticeResponseDtoPage = noticeService.findPage2(page, limit, searchType, searchValue, sortType);
        model.addAttribute("paging", noticeResponseDtoPage);
        model.addAttribute("searchType", searchType);
        model.addAttribute("searchValue", searchValue);
        model.addAttribute("sortType", sortType);

        return "/pages/admin/admin_notice";
    }

    @GetMapping("/notice/new")
    public String adminNoticeNew(Model model, HttpSession session) {
        Long userIdx = (Long) session.getAttribute("adminIdx");
        if (userIdx == null)
            return "redirect:/admin/";
        else
            model.addAttribute("member", new MemberResponseDto(adminService.findById(userIdx)));
        return "/pages/admin/admin_notice_write";
    }

    @GetMapping("/notice/{idx}")
    public String noticeDetail(Model model, HttpSession session, @PathVariable(name = "idx") Long idx) {
        Long userIdx = (Long) session.getAttribute("adminIdx");
        if (userIdx == null)
            return "redirect:/admin/";
        else
            model.addAttribute("member", new MemberResponseDto(adminService.findById(userIdx)));
        NoticeResponseDto dto = noticeService.findByIdx(idx);
        model.addAttribute("notice", dto);
        return "pages/admin/admin_notice_view";
    }

}
