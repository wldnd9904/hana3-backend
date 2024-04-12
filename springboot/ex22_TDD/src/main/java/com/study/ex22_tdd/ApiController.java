package com.study.ex22_tdd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
    @Autowired
    MemberService memberService;

    @PostMapping("/loginAction1")
    public ResultDto loginAction1(@RequestBody Member member) {
        System.out.println(member.getLoginId());
        System.out.println(member.getLoginPw());
        int result = (memberService.loginAction(member));
        ResultDto resultDto = new ResultDto();
        if (result == 1) {
            resultDto.setStatus("ok");
            resultDto.setMessage("로그인 성공!");
        } else {
            resultDto.setStatus("fail");
            resultDto.setMessage("로그인 실패!");
        }

        return resultDto;
    }
}