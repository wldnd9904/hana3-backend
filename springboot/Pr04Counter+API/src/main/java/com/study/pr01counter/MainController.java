package com.study.pr01counter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    @Autowired
    Counter counter;

    MainController() {
        counter = new Counter();
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("count", counter.getCount());
        return "index";
    }

    @GetMapping("/plus")
    @ResponseBody
    public Counter plus() {
        counter.increment();
        return counter;
    }

    @GetMapping("/minus")
    @ResponseBody
    public Counter minus() {
        counter.decrement();
        return counter;
    }
}
