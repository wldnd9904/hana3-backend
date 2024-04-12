package com.study.ex22_tdd;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.regex.Matcher;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(MainController.class)
class MainControllerTest {
    //MockMvc : 웹 API를 테스트할 때 가상의 HTTP요청을 만들어주는 클래스이다.
    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("main() 테스트")
    void main() throws Exception {
        Member member = new Member("hong", "1234");

        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"))
                .andExpect(model().attributeExists("member"))
                .andExpect(model().attribute("list", Matchers.contains("hong", "lee")));
//                .andExpect(model().attribute("member", member));
        //.andDo(print());
    }

}