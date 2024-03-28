package com.study.pr03vm;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@Controller
public class HtmlController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/changeLocale")
    public String changeLocale(HttpSession session) {
        String LSAN = SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME;
        Locale locale = (Locale) session.getAttribute(LSAN);
        if (Locale.US.equals(locale)) {
            session.setAttribute(LSAN, Locale.KOREA);
        } else {
            session.setAttribute(LSAN, Locale.US);
        }
        return "redirect:/";
    }

}
