package com.study.ex03_autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    //호출 url = :8080
    @GetMapping("/")
    @ResponseBody
    public String Main() {
        return "아 잠온다";
    }

    //필드 주입
    @Autowired
    private Member member;

    @GetMapping("/member")
    @ResponseBody
    public String member() {
        member.setName("홍길동");
        return "member() : " + member.getName();
    }

    @Autowired
    @Qualifier("cardBC")
    ICard iCard; //인터페이스 구현객체 주입, 어떤놈을 넣을지 모름

    @GetMapping("/card")
    @ResponseBody
    public String card() {
        member.setiCard(iCard);
        member.getiCard().buy("phone");
        return "card()";
    }
}
