package com.study.ex06_thymeleaf;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
public class User {
    private String username;
    private String password;
}
