package com.study.pr10memberadminapi.model;

import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
public class Member {
    private String username;
    private String password;
    private String email;
    private LocalDate joinDate;
}