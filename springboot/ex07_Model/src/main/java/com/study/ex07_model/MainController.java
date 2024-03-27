package com.study.ex07_model;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
    @GetMapping("/")
    public String main() {
        return "redirect:model1";
    }

    //@RequestMapping : GET/POST/PUT/PATCH/DELETE 모두 받을 수 있음.
    @RequestMapping("/model1")
    //request 객체 : HTTP 요청에 대한 정보를 담고 있음.
    public String model1(HttpServletRequest request) {
        request.setAttribute("name", "홍길동");
        request.setAttribute("age", "30");

        request.getSession().setAttribute("isLogin", "true");

        return "index"; //index.html로 응답함
    }

    // URL : http://localhost:8080/post-form
    @RequestMapping("/post-form")
    public String postForm() {
        return "postForm";//postForm.html로 응답함.
    }

    //호출URL : GET localhost:8080/model2?name=홍길동&age=30
    @RequestMapping("/model2")
    public String model2(HttpServletRequest request) {
        String param_name = request.getParameter("name");
        String param_age = request.getParameter("age");
        request.setAttribute("name", param_name);
        request.setAttribute("age", param_age);

        return "index";//index.html로 응답함
    }

    //ModelAndView : 모델(데이타)와 View(HTML)을 동시에 저장/응답하는 객체
    @RequestMapping("/model4")
    public ModelAndView model3(ModelAndView mv) {
        mv.addObject("name", "춘향이");
        mv.addObject("age", "18");

        //뷰 설정
        mv.setViewName("index"); //index.html로 응답

        return mv;
    }
}
