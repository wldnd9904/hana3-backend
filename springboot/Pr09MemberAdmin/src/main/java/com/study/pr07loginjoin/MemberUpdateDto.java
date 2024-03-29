package com.study.pr07loginjoin;

import lombok.*;

import java.time.LocalDate;

@Data
public class MemberUpdateDto extends Member {
    private int index;
    private String username;
    private String password;
    private String email;
    private LocalDate joindate;

    public MemberUpdateDto(String username, String password, String email, LocalDate joindate, int index) {
        super(username, password, email, joindate);
        this.index = index;
    }
}
