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
    ArrayList<Product> products;

    public MainController() {
        LanguagePack.packs.put("kor", KoreanPack.dictionary);
        LanguagePack.packs.put("eng", EnglishPack.dictionary);
        products = new ArrayList<>();
        products.add(new Product("상추버거", 3000, LocalDate.of(2024, 3, 30)));
        products.add(new Product("소고기버거", 1000, LocalDate.of(2024, 3, 26)));
        products.add(new Product("치즈버거", 2000, LocalDate.of(2024, 3, 26)));
    }

    @GetMapping("/")
    public String slash(Model model) {
        model.addAttribute("products", products);

        return "redirect:/kor";
    }

    @GetMapping("/{lang}")
    public String index(@PathVariable("lang") String lang, Model model) {
        model.addAttribute("products", products);
        model.addAttribute("languagePack", LanguagePack.packs.get(lang));

        return "index";
    }

    @GetMapping("/{lang}/new")
    public String newPage(@PathVariable("lang") String lang, Model model) {
        model.addAttribute("languagePack", LanguagePack.packs.get(lang));
        return "new";
    }

    @PostMapping("/{lang}/new")
    @ResponseBody
    public String newItem(@PathVariable("lang") String lang,
                          @RequestParam String name,
                          @RequestParam int price,
                          @RequestParam LocalDate limit_date) {
        products.add(new Product(name, price, limit_date));
        return String.format("<script>alert('%s');location.href='%s'</script>", LanguagePack.packs.get(lang).get("상품 추가 완료!"), "/" + lang);
    }

    @GetMapping("/{lang}/edit")
    public String editPage(@PathVariable("lang") String lang, @RequestParam String index, Model model) {
        model.addAttribute("product", products.get(Integer.parseInt(index)));
        model.addAttribute("index", index);
        model.addAttribute("languagePack", LanguagePack.packs.get(lang));
        //업데이트 페이지로 이동
        return "edit";
    }

    @PostMapping("/{lang}/edit")
    @ResponseBody
    public String edit(@PathVariable("lang") String lang, @RequestParam String name, @RequestParam int price, @RequestParam LocalDate limit_date, @RequestParam int index) {
        products.set(index, new Product(name, price, limit_date));
        //업데이트 페이지로 이동
        return String.format("<script>alert('%s');location.href='%s'</script>", LanguagePack.packs.get(lang).get("상품 수정 완료!"), "/" + lang);
    }

    @GetMapping("/{lang}/delete")
    @ResponseBody
    public String delete(@PathVariable("lang") String lang, @RequestParam int index) {
        products.remove(index);
        //업데이트 페이지로 이동
        return String.format("<script>alert('%s');location.href='%s'</script>", LanguagePack.packs.get(lang).get("상품 삭제 완료!"), "/" + lang);
    }
}
