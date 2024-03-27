package com.study.pr03vm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

@Controller
public class MainController {

    public MainController() {
        LanguagePack.packs.put("kor", KoreanPack.dictionary);
        LanguagePack.packs.put("eng", EnglishPack.dictionary);
    }

    @GetMapping("/")
    public String slash() {
        return "redirect:/kor";
    }

    @GetMapping("/{lang}")
    public String index(@PathVariable("lang") String lang, Model model) {
        model.addAttribute("languagePack", LanguagePack.packs.get(lang));

        return "index";
    }
}
