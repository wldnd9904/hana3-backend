package com.study.exam01.controller;

import com.study.exam01.domain.member.Member;
import com.study.exam01.dto.ResponseDto;
import com.study.exam01.dto.member.MemberFindIdRequestDto;
import com.study.exam01.dto.member.MemberFindPwRequestDto;
import com.study.exam01.dto.member.MemberJoinRequestDto;
import com.study.exam01.dto.member.MemberLoginRequestDto;
import com.study.exam01.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.Optional;

@RequestMapping("/api/member")
@RestController
@RequiredArgsConstructor
public class MemberAPIController {
    private final MemberService memberService;

    @GetMapping("/checkID")
    public ResponseDto checkID(@RequestParam(name = "userID") String userID) {
        boolean userExists = memberService.existsByUserID(userID);
        if (userExists) {
            return new ResponseDto("중복된 아이디입니다.", "red");
        } else {
            return new ResponseDto("사용 가능한 아이디입니다.", "green");
        }
    }

    @PostMapping("/join")
    public String join(@ModelAttribute MemberJoinRequestDto dto) {
        boolean isAccepted = memberService.join(dto);
        if (isAccepted) {
            return "<script>alert('회원가입되었습니다.');location.href='/login'</script>";
        } else {
            return "<script>alert('회원가입에 실패했습니다.');history.back();</script>";
        }
    }

    @PostMapping("/login")
    public String login(@ModelAttribute MemberLoginRequestDto dto, HttpSession session) {
        boolean memberExists = memberService.existsByUserID(dto.loginID());
        if (!memberExists)
            return "<script>alert('아이디가 존재하지 않습니다.');history.back();</script>";
        Optional<Member> optional = memberService.login(dto);
        if (optional.isPresent()) {
            session.setAttribute("userIdx", optional.get().getMemberIdx());
            return "<script>alert('로그인 되었습니다.');location.href='/'</script>";
        } else {
            return "<script>alert('비밀번호가 다릅니다.');history.back();</script>";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "<script>alert('로그아웃 되었습니다.');location.href='/'</script>";
    }

    @PostMapping("/findId")
    public ResponseDto findId(@RequestBody MemberFindIdRequestDto dto) {
        Optional<Member> optional = memberService.findByUserNameAndUserEmail(dto.userName(), dto.userEmail());
        if (optional.isPresent()) {
            return new ResponseDto(dto.userName() + "님의 아이디는 " + optional.get().getMemberId() + " 입니다.", "green");
        } else {
            return new ResponseDto("찾으시는 계정이 없습니다.", "red");
        }
    }

    @PostMapping("/findPw")
    public ResponseDto findPw(@RequestBody MemberFindPwRequestDto dto) {
        Optional<Member> optional = memberService.findByUserNameAndUserEmailAndUserId(dto.userName(), dto.userEmail(), dto.userId());
        if (optional.isPresent()) {
            return new ResponseDto(dto.userName() + "님의 비밀번호는 " + optional.get().getMemberPw() + " 입니다.", "green");
        } else {
            return new ResponseDto("찾으시는 계정이 없습니다.", "red");
        }
    }
}
