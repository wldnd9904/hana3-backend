package com.study.ex14_readdb.controller;

import com.study.ex14_readdb.MemberRepository;
import com.study.ex14_readdb.dto.MemberSaveDto;
import com.study.ex14_readdb.entity.MemberEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class MainController {
    final MemberRepository memberRepository;

    @GetMapping("/")
    public String main(Model model) {
        List<MemberEntity> list = memberRepository.findAll();
        model.addAttribute("list", list);
        return "index";
    }

    @GetMapping("/viewMember")
    public String view(@RequestParam long id, Model model) {
        Optional<MemberEntity> optional = memberRepository.findById(id);
        optional.ifPresent(member -> {
            model.addAttribute("member", member);
        });

        return "modifyForm";

    }

    @GetMapping("/deleteDTO")
    public String delete(@RequestParam long id, Model model) {
        memberRepository.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/joinForm")
    public String joinForm() {
        return "joinForm";
    }

    @PostMapping("joinAction")
    @ResponseBody
    public String joinAction(@ModelAttribute MemberSaveDto dto) {
        System.out.println("name:" + dto.userName());
        try {
            MemberEntity memberEntity = dto.toMemberEntity();
            memberRepository.save(memberEntity);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            System.out.println("회원가입 실패");
            return "<script>alert('회원가입 실패');location.href='/joinForm';</script>";
        }
        return "<script>alert('회원가입 성공');location.href='/';</script>";
    }
}
