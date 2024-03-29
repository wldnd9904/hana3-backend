package com.study.pr07loginjoin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    private String username;
    private String password;
    private String email;
    private LocalDate joindate;
}