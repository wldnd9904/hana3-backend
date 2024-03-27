package com.study.ex06_thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.reflect.Member;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @GetMapping("/index2")
    public String index2(Model model) {
        model.addAttribute("address", "한양");
        model.addAttribute("address_null", null);
        model.addAttribute("address_empty", "");
        return "index2";
    }


    @GetMapping("/index3")
    public String index3(Model model) {
        model.addAttribute("standardDate", new Date());
        model.addAttribute("localDate", LocalDate.now());
        model.addAttribute("localDateTime", LocalDateTime.now());

        model.addAttribute("number1", 12345678);
        model.addAttribute("number2", 123456.789);

        return "index3"; //index3.html로 응답함.
    }

    @GetMapping("/index4")
    public String index4(Model model) {
        model.addAttribute("role", "admin");

        return "index4"; //index4.html로 응답함.
    }

    @GetMapping("/index5")
    public String index5(Model model) {
        User member = new User("hong", "1234");
        model.addAttribute("member", member);

        List<User> list = new ArrayList<>();
        list.add(new User("lee", "2222"));
        list.add(new User("hana", "3333"));
        list.add(new User("tom", "4444"));
        model.addAttribute("list", list);

        return "index5"; //index5.html로 응답함.
    }

    @GetMapping("/index6")
    public String index6() {
        return "index6"; //index6.html로 응답함.
    }

    @GetMapping("/index7")
    public String index7() {
        return "index7"; //index7.html로 응답함.
    }
}
