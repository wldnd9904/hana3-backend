package com.study.exam01.dto.member;

import com.study.exam01.domain.member.Member;

import java.time.LocalDate;

public record MemberJoinRequestDto(
        String userID,
        String userPW,
        String userName,
        String userEmail,
        int emailReceive,
        int passwordCheckQuestion,
        String passwordCheckAnswer,
        String gender,
        LocalDate birthday
) {
    public Member toEntity() {
        return Member.builder()
                .memberId(userID)
                .memberPw(userPW)
                .memberName(userName)
                .memberEmail(userEmail)
                .memberEmailReceive(emailReceive)
                .memberPwQuestion(passwordCheckQuestion)
                .memberPwAnswer(passwordCheckAnswer)
                .memberGender(gender)
                .memberBirthDate(birthday)
                .build();
    }
}
