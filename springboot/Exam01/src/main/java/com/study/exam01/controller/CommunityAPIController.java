package com.study.exam01.controller;

import com.study.exam01.dto.ResponseDto;
import com.study.exam01.dto.notice.NoticeEditRequestDto;
import com.study.exam01.dto.notice.NoticeWriteRequestDto;
import com.study.exam01.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/community")
public class CommunityAPIController {
    private final NoticeService noticeService;

    @PostMapping("/notice")
    public String postNotice(@ModelAttribute NoticeWriteRequestDto dto) {
        boolean isSaved = noticeService.save(dto);
        if (isSaved)
            return "<script>alert('공지사항이 등록되었습니다.'); location.href='/admin/notice';</script>";
        else
            return "<script>alert('공지사항 등록에 실패했습니다.'); location.href='/admin/notice';</script>";
    }

    @PostMapping("/notice/edit")
    public String editNotice(@ModelAttribute NoticeEditRequestDto dto) {
        boolean isSaved = noticeService.save(dto);
        if (isSaved)
            return "<script>alert('공지사항이 수정되었습니다.'); location.href='/admin/notice';</script>";
        else
            return "<script>alert('공지사항 수정에 실패했습니다.'); location.href='/admin/notice';</script>";
    }

    @GetMapping("/notice/delete")
    public String editNotice(@RequestParam(name = "id") Long id) {
        boolean isDeleted = noticeService.deleteById(id);
        if (isDeleted)
            return "<script>alert('공지사항이 삭제되었습니다.'); location.href='/admin/notice';</script>";
        else
            return "<script>alert('공지사항 삭제에 실패했습니다.'); location.href='/admin/notice';</script>";
    }
}
