package com.study.ex12_h2db;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final MemberRepository memberRepository;

    @GetMapping("/")
    public String index(Model model) {
        memberRepository.save(new MemberEntity((long) 1, "hong", "1234", "홍길동", "ROLE_USER", LocalDate.parse("2023-09-01")));
        memberRepository.save(new MemberEntity((long) 2, "kong", "1234", "콩길동", "ROLE_USER", LocalDate.parse("2023-09-02")));
        memberRepository.save(new MemberEntity((long) 3, "gong", "1234", "공길동", "ROLE_USER", LocalDate.parse("2023-09-03")));
        memberRepository.save(new MemberEntity((long) 4, "bong", "1234", "봉길동", "ROLE_USER", LocalDate.parse("2023-09-04")));
        memberRepository.save(new MemberEntity((long) 5, "pong", "1234", "퐁길동", "ROLE_ADMIN", LocalDate.parse("2023-09-05")));

        model.addAttribute("list", memberRepository.findAll());
        return "index";
    }
}
