package com.study.pr10memberadminapi.response;

import com.study.pr10memberadminapi.model.Member;

import java.time.LocalDate;

public record MemberUpdateResponse(
        String username,
        String password,
        String email,
        LocalDate joinDate,
        int index
) {
    public MemberUpdateResponse(Member member, int index) {
        this(
                member.getUsername(),
                member.getPassword(),
                member.getEmail(),
                member.getJoinDate(),
                index
        );
    }
}
