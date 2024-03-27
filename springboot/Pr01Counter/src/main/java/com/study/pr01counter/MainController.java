package com.study.pr01counter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @Autowired
    Counter counter;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("count", counter.getCount());
        return "index";
    }

    @GetMapping("/plus")
    public String plus(Model model) {
        counter.increment();
        model.addAttribute("count", counter.getCount());
        return "index";
    }

    @GetMapping("/minus")
    public String minus(Model model) {
        counter.decrement();
        model.addAttribute("count", counter.getCount());
        return "index";
    }
}
