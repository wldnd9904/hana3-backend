package com.study.pr07loginjoin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api")
public class APIController {
    @Autowired
    MemberList memberList;

    @GetMapping("/check-dupl")
    public AlertDto checkDuplicate(@RequestParam String inputName) {
        if(memberList.isDuplicate(inputName))
            return new AlertDto("중복된 아이디가 있습니다.", "alert-primary");
        else return new AlertDto("사용 가능한 아이디입니다.", "alert-success");
    }

    @PostMapping("/login")
    public AlertDto login(@RequestBody LoginForm loginForm) {
        System.out.println("로그인: " + loginForm.getInputName() + ", " + loginForm.getInputPw());
        if(memberList.login(loginForm.getInputName(),loginForm.getInputPw()))
            return new AlertDto("로그인 성공!", "alert-success");
        else return  new AlertDto( "아이디와 비밀번호를 확인해주세요.", "alert-danger");
    }

    @PostMapping("/join")
    public AlertDto join(@RequestBody JoinForm joinForm) {
        if(memberList.join(new Member(joinForm.getInputName(), joinForm.getInputPw(), joinForm.getInputEmail(), LocalDate.now())))
            return new AlertDto("성공적으로 회원가입 되었습니다.","alert-success");
        else return new AlertDto("중복된 아이디가 있습니다.","alert-primary");
    }
}
