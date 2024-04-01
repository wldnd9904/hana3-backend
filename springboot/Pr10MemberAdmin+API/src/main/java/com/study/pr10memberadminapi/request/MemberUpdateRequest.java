package com.study.pr10memberadminapi.request;

import com.study.pr10memberadminapi.model.Member;

import java.time.LocalDate;

public record MemberUpdateRequest(
        String username,
        String password,
        String email,
        LocalDate joinDate,
        int index
) {
    public Member toMember() {
        return new Member(username, password, email, joinDate);
    }
}