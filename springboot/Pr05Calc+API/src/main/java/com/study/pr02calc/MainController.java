package com.study.pr02calc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {
    @Autowired
    Calculator calculator;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("inputA", calculator.getInputA());
        model.addAttribute("inputB", calculator.getInputB());
        model.addAttribute("result", calculator.getResult());
        return "index";
    }

    @PostMapping("/add")
    @ResponseBody
    public Response add(@RequestParam int num1, @RequestParam int num2) {
        calculator.add(num1,num2);
        return new Response("ok",calculator.getResult());
    }

    @PostMapping("/sub")
    @ResponseBody
    public Response sub(@RequestParam int num1, @RequestParam int num2) {
        calculator.sub(num1,num2);
        return new Response("ok",calculator.getResult());
    }

    @PostMapping("/mul")
    @ResponseBody
    public Response mul(@RequestParam int num1, @RequestParam int num2) {
        calculator.mul(num1, num2);
        return new Response("ok",calculator.getResult());
    }

    @PostMapping("/div")
    @ResponseBody
    public Response div(@RequestParam int num1, @RequestParam int num2) {
        calculator.div(num1,num2);
        return new Response("ok",calculator.getResult());
    }

}
