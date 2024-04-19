package com.study.exam01.dto.member;

public record MemberFindPwRequestDto(
        String userName,
        String userEmail,
        String userId
) {
}
