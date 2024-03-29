package com.study.pr03vm;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import javax.swing.text.html.HTML;
import java.util.Locale;

@Controller
public class HtmlController {

    @GetMapping("/")
    public String index(@RequestHeader("Accept-Language") String acceptLanguage, HttpSession session) {
        String LSAN = SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME;
        if (session.getAttribute(LSAN) == null) {
            String MainLocale = acceptLanguage.split(",")[0];
            session.setAttribute(LSAN, Locale.forLanguageTag(MainLocale));
        }
        return "index";
    }

    @GetMapping("/changeLocale")
    public String changeLocale(HttpSession session) {
        String LSAN = SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME;
        Locale locale = (Locale) session.getAttribute(LSAN);
        System.out.println(locale);
        if (Locale.US.equals(locale)) {
            session.setAttribute(LSAN, Locale.KOREA);
        } else {
            session.setAttribute(LSAN, Locale.US);
        }
        return "redirect:/";
    }

}
