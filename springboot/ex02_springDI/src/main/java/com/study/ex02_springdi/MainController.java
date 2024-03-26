package com.study.ex02_springdi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

//@Controller : HTTP 요청을 처리하는 컨트롤러 클래스
@Controller
public class MainController {
    @GetMapping("/")
    @ResponseBody
    public String main() {
        return "{name: 'hong', age:20}";
    }

    @GetMapping("/test")
    @ResponseBody
    public String test() {
        return "테스트입니다.";
    }

    //스프링 빈을 주입받는 방법
    //1. 필드 주입
    @Autowired
    private Member member1;
    @Autowired
    private Member member2;

    @GetMapping("/field")
    @ResponseBody
    public String field() {
        return "field()" + member1.getName();
    }

    //2. 수정자 주입
    private Member member3;

    @Autowired
    public void setMember(Member member) {
        this.member3 = member;
    }

    @GetMapping("/setter")
    @ResponseBody
    public String setter() {
        return "setter(): " + member3.getName();
    }

    //3. 생성자 주입
    // 1. final 키워드 사용 가능(재할당 방지)
    // 2. 생성자로서 미리 주입받을 수 있음, null safety
    private final Member member4;

    @Autowired
    public MainController(Member member) {
        this.member4 = member;
    }

    @GetMapping("/constructor")
    @ResponseBody
    public String constructor() {
        return "constructor(): " + member4.getName();
    }
}
