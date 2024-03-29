package com.study.pr07loginjoin;

import lombok.Data;
import org.springframework.web.bind.annotation.RequestBody;

@Data
public class LoginForm {
    private String inputName;
    private String inputPw;
}
