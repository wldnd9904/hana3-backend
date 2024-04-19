package com.study.exam01.controller;

import com.study.exam01.domain.admin.Admin;
import com.study.exam01.domain.member.Member;
import com.study.exam01.dto.ResponseDto;
import com.study.exam01.dto.member.MemberFindIdRequestDto;
import com.study.exam01.dto.member.MemberFindPwRequestDto;
import com.study.exam01.dto.member.MemberJoinRequestDto;
import com.study.exam01.dto.member.MemberLoginRequestDto;
import com.study.exam01.service.AdminService;
import com.study.exam01.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.Optional;

@RequestMapping("/api/admin")
@RestController
@RequiredArgsConstructor
public class AdminAPIController {
    private final AdminService adminService;

    @GetMapping("/checkID")
    public ResponseDto checkID(@RequestParam(name = "userID") String userID) {
        boolean userExists = adminService.existsByUserID(userID);
        if (userExists) {
            return new ResponseDto("중복된 아이디입니다.", "red");
        } else {
            return new ResponseDto("사용 가능한 아이디입니다.", "green");
        }
    }

    @PostMapping("/login")
    public String login(@ModelAttribute MemberLoginRequestDto dto, HttpSession session) {
        boolean memberExists = adminService.existsByUserID(dto.loginID());
        if (!memberExists)
            return "<script>alert('아이디가 존재하지 않습니다.');history.back();</script>";
        Optional<Admin> optional = adminService.login(dto);
        if (optional.isPresent()) {
            session.setAttribute("adminIdx", optional.get().getMemberIdx());
            return "<script>alert('로그인 되었습니다.');location.href='/admin/member'</script>";
        } else {
            return "<script>alert('비밀번호가 다릅니다.');history.back();</script>";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "<script>alert('로그아웃 되었습니다.');location.href='/'</script>";
    }

}
