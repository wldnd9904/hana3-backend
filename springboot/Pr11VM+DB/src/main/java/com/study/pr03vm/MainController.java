package com.study.pr03vm;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

@Controller
public class MainController {
    @Autowired
    ProductRepository productRepository;

    public MainController() {
        LanguagePack.packs.put("kor", KoreanPack.dictionary);
        LanguagePack.packs.put("eng", EnglishPack.dictionary);
    }

    @GetMapping("/")
    public String slash(Model model) {
        model.addAttribute("products", productRepository.findAll());

        return "redirect:/kor";
    }

    @GetMapping("/{lang}")
    public String index(@PathVariable("lang") String lang, Model model) {
        model.addAttribute("products", productRepository.findAll());
        model.addAttribute("languagePack", LanguagePack.packs.get(lang));

        return "index";
    }

    @GetMapping("/{lang}/new")
    public String newPage(@PathVariable("lang") String lang, Model model) {
        model.addAttribute("languagePack", LanguagePack.packs.get(lang));
        return "new";
    }

    @PostMapping("/{lang}/new")
    public String newItem(@PathVariable("lang") String lang,
                          @RequestParam String name,
                          @RequestParam int price,
                          @RequestParam LocalDate limit_date) {
        productRepository.save(new ProductEntity(0, name, price, limit_date));
        return "redirect:/" + lang;
    }

    @GetMapping("/{lang}/edit")
    public String editPage(@PathVariable("lang") String lang, @RequestParam long id, Model model) {
        Optional<ProductEntity> optional = productRepository.findById(id);
        optional.ifPresent((productEntity -> {
            model.addAttribute("product", productEntity);
            model.addAttribute("id", id);
            model.addAttribute("languagePack", LanguagePack.packs.get(lang));
            //업데이트 페이지로 이동
        }));
        if (optional.isPresent())
            return "edit";
        return "redirect:/";
    }

    @PostMapping("/{lang}/edit")
    public String edit(@PathVariable("lang") String lang, @RequestParam String name, @RequestParam int price, @RequestParam LocalDate limit_date, @RequestParam long id) {
        productRepository.updateProduct(id, name, price, limit_date);
        //업데이트 페이지로 이동
        return "redirect:/" + lang;
    }

    @GetMapping("/{lang}/delete")
    public String delete(@PathVariable("lang") String lang, @RequestParam long id) {
        productRepository.deleteById(id);
        //업데이트 페이지로 이동
        return "redirect:/" + lang;
    }
}
