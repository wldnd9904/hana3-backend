package com.study.pr03vm;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
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
    IProductDao productDao;

    public MainController() {
        LanguagePack.packs.put("kor", KoreanPack.dictionary);
        LanguagePack.packs.put("eng", EnglishPack.dictionary);
    }

    @GetMapping("/")
    public String slash(Model model) {
        return "redirect:/kor";
    }

    @GetMapping("/{lang}")
    public String index(@PathVariable("lang") String lang, Model model) {
        model.addAttribute("products", productDao.list());
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
        productDao.insert(new ProductDto(0, name, price, limit_date));
        return String.format("<script>alert('%s');location.href='%s'</script>", LanguagePack.packs.get(lang).get("상품 추가 완료!"), "/" + lang);
    }

    @GetMapping("/{lang}/edit")
    public String editPage(@PathVariable("lang") String lang, @RequestParam long id, Model model) {
        Optional<ProductDto> optional = productDao.findById(id);
        optional.ifPresent((productDto -> {
            model.addAttribute("product", productDto);
            model.addAttribute("id", id);
            model.addAttribute("languagePack", LanguagePack.packs.get(lang));
            //업데이트 페이지로 이동
        }));
        if (optional.isPresent())
            return "edit";
        return "redirect:/";
    }

    @PostMapping("/{lang}/edit")
    @ResponseBody
    public String edit(@PathVariable("lang") String lang, @RequestParam String name, @RequestParam int price, @RequestParam LocalDate limit_date, @RequestParam long id) {
        productDao.update(new ProductDto(id, name, price, limit_date));
        //업데이트 페이지로 이동
        return String.format("<script>alert('%s');location.href='%s'</script>", LanguagePack.packs.get(lang).get("상품 수정 완료!"), "/" + lang);
    }

    @GetMapping("/{lang}/delete")
    @ResponseBody
    public String delete(@PathVariable("lang") String lang, @RequestParam long id) {
        productDao.deleteById(id);
        //업데이트 페이지로 이동
        return String.format("<script>alert('%s');location.href='%s'</script>", LanguagePack.packs.get(lang).get("상품 삭제 완료!"), "/" + lang);
    }
}
