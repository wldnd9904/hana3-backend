package com.study.ex11_localization;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
        if (Locale.KOREA.equals(locale)) {
            session.setAttribute(LSAN, Locale.US);
        } else {
            session.setAttribute(LSAN, Locale.KOREA);
        }
        return "redirect:/";
    }
}
