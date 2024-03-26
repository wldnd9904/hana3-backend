package com.study.ex06_thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("name_text", "홍길동");
        model.addAttribute("name_html", "<ins>김길동</ins>");
        model.addAttribute("server_value", "HONG");
        return "forward:index";
        // forward: 내부 변수값을 가지고 페이지 이동
        // redirect: 내부 변수값 버리고 다른사이트로 이동
    }

    @GetMapping("/index")
    public String index() {
        //Model 클래스: 스프링 데이터 담아서 전달하는 클래스 객체
        return "index";
    }

    //HTML에서 서버로 데이터 전송
    //HTML Form 태그: GET/POST 방식으로 submit
    //JS Fetch(): GET/POST/PUT/DELETE
    //JQuery ajax(): GET/POST/PUT/DELETE
    //Axios module axios(): GET/POST/PUT/DELETE
    //디버깅툴: POSTMAN, THUNDER

    //GET으로 요청파라미터 데이터 받음
    //URI(URL) : localhost:8080/index-param?id=hong&pw=1234
    @GetMapping("/index-param")
    public String indexParam(@RequestParam String id, @RequestParam String pw, Model model) {
        System.out.println("id:" + id);
        System.out.println("pw:" + pw);
        model.addAttribute("id", id);
        model.addAttribute("pw", pw);
        return "index";
    }

    @PostMapping("/index-param")
    public String indexParamPost(@RequestParam String id, @RequestParam String pw, Model model) {
        System.out.println("id:" + id);
        System.out.println("pw:" + pw);
        model.addAttribute("id", id);
        model.addAttribute("pw", pw);
        return "index";
    }
}
