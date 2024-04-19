package com.study.exam01.controller;

import com.study.exam01.dto.customer.One2OneSaveRequestDto;
import com.study.exam01.service.One2OneService;
import com.study.exam01.service.QnAService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/customer")
@RestController
@RequiredArgsConstructor
public class CustomerAPIController {
    private final One2OneService one2OneService;
    private final QnAService qnAService;

    @PostMapping("/one2one")
    public String postOne2One(@ModelAttribute One2OneSaveRequestDto dto) {
        boolean isSaved = one2OneService.save(dto);
        if (isSaved)
            return "<script>alert('문의가 등록되었습니다.'); location.href='/';</script>";
        else
            return "<script>alert('문의 등록에 실패했습니다.'); location.href='/';</script>";
    }

    @PostMapping("/qna/check")
    public String postOne2One(@RequestParam long qnaIdx, @RequestParam String qnaPw) {
        boolean isValid = qnAService.existsByIdAndQnaPw(qnaIdx, qnaPw);
        if (isValid)
            return "<script>location.href='/customer/qna/" + qnaIdx + "';</script>";
        else
            return "<script>alert('비밀번호를 확인해주세요.'); history.back();</script>";
    }
}
