package com.study.exam01.dto.member;

public record MemberLoginRequestDto(
        String loginID,
        String loginPW
) {
}
