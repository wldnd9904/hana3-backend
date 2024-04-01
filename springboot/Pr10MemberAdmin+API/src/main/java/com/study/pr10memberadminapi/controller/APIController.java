package com.study.pr10memberadminapi.controller;

import com.study.pr10memberadminapi.model.Member;
import com.study.pr10memberadminapi.model.MemberList;
import com.study.pr10memberadminapi.request.JoinRequest;
import com.study.pr10memberadminapi.request.LoginRequest;
import com.study.pr10memberadminapi.request.MemberUpdateRequest;
import com.study.pr10memberadminapi.response.AlertResponse;
import com.study.pr10memberadminapi.response.MemberUpdateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;

@RestController
@RequestMapping("/api")
public class APIController {
    MemberList memberList;

    APIController() {
        memberList = new MemberList();
        memberList.join(new Member("aaa", "aaa", "aaa@aa.a", LocalDate.now()));
        memberList.join(new Member("bbb", "bbb", "bbb@bb.b", LocalDate.now()));
        memberList.join(new Member("ccc", "ccc", "ccc@cc.c", LocalDate.now()));
        memberList.join(new Member("ddd", "ddd", "ddd@dd.d", LocalDate.now()));
    }

    @GetMapping("/check-dupl")
    public AlertResponse checkDuplicate(@RequestParam String inputName) {
        System.out.println("중복검사: " + inputName);
        if (memberList.isDuplicate(inputName))
            return new AlertResponse("중복된 아이디가 있습니다.", "alert-primary");
        else return new AlertResponse("사용 가능한 아이디입니다.", "alert-success");
    }

    @PostMapping("/login")
    public AlertResponse login(@RequestBody LoginRequest loginRequest) {
        System.out.println("로그인: " + loginRequest);
        if (memberList.login(loginRequest.inputName(), loginRequest.inputPw()))
            return new AlertResponse("로그인 성공!", "alert-success");
        else return new AlertResponse("아이디와 비밀번호를 확인해주세요.", "alert-danger");
    }

    @PostMapping("/join")
    public AlertResponse join(@RequestBody JoinRequest joinRequest) {
        System.out.println("회원가입: " + joinRequest);
        if (memberList.join(new Member(joinRequest.inputName(), joinRequest.inputPw(), joinRequest.inputEmail(), LocalDate.now())))
            return new AlertResponse("성공적으로 회원가입 되었습니다.", "alert-success");
        else return new AlertResponse("중복된 아이디가 있습니다.", "alert-primary");
    }

    @GetMapping("/members")
    public ArrayList<Member> members() {
        return memberList.getMemberList();
    }

    @GetMapping("/get")
    public Member get(@RequestParam int index) {
        System.out.println("get");
        return memberList.findMemberById(index);
    }

    @PostMapping("/update")
    public AlertResponse update(@RequestBody MemberUpdateRequest request) {
        if (memberList.updateMember(request))
            return new AlertResponse("수정되었습니다.", "alert-success");
        else
            return new AlertResponse("수정하지 못했습니다.", "alert-danger");
    }

    @DeleteMapping("/delete")
    public AlertResponse delete(@RequestParam int index) {
        if (memberList.removeMemberById(index))
            return new AlertResponse("삭제되었습니다.", "alert-success");
        else
            return new AlertResponse("삭제하지 못했습니다.", "alert-danger");
    }
}
