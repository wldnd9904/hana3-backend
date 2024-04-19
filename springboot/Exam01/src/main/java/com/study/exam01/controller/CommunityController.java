package com.study.exam01.controller;

import com.study.exam01.domain.community.Notice;
import com.study.exam01.dto.member.MemberResponseDto;
import com.study.exam01.dto.notice.NoticeResponseDto;
import com.study.exam01.service.MemberService;
import com.study.exam01.service.NoticeService;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CommunityController {
    private final NoticeService noticeService;
    private final MemberService memberService;

    @GetMapping("/community/notice")
    public String notice(Model model, HttpSession session,
                         @RequestParam(name = "page", defaultValue = "0") int page,
                         @RequestParam(name = "limit", defaultValue = "10") int limit,
                         @RequestParam(name = "searchType", defaultValue = "") String searchType,
                         @RequestParam(name = "searchValue", defaultValue = "") String searchValue) {
        Long userIdx = (Long) session.getAttribute("userIdx");
        if (userIdx != null)
            model.addAttribute("member", new MemberResponseDto(memberService.findById(userIdx)));
        Page<NoticeResponseDto> noticeResponseDtoPage = noticeService.findPage(page, limit, searchType, searchValue);
        model.addAttribute("paging", noticeResponseDtoPage);
        model.addAttribute("searchType", searchType);
        model.addAttribute("searchValue", searchValue);
        return "pages/community/community01";
    }

    @GetMapping("/community/notice/{idx}")
    public String noticeDetail(Model model, HttpSession session, @PathVariable(name = "idx") Long idx) {
        Long userIdx = (Long) session.getAttribute("userIdx");
        if (userIdx != null)
            model.addAttribute("member", new MemberResponseDto(memberService.findById(userIdx)));
        NoticeResponseDto dto = noticeService.findByIdx(idx);
        model.addAttribute("notice", dto);
        return "pages/community/community01_1";
    }
}
