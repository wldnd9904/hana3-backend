package com.study.exam01.dto.member;

import com.study.exam01.domain.admin.Admin;
import com.study.exam01.domain.member.Member;
import lombok.Builder;

import java.time.LocalDate;

public record MemberResponseDto(
        Long memberIdx,
        String memberId,
        String memberPw,
        String memberName,
        String memberEmail,
        int memberEmailReceive,
        int memberPwQuestion,
        String memberPwAnswer,
        String memberGender,
        LocalDate memberBirthDate,
        LocalDate memberJoinDate
) {
    public MemberResponseDto(Member entity) {
        this(
                entity.getMemberIdx(),
                entity.getMemberId(),
                entity.getMemberPw(),
                entity.getMemberName(),
                entity.getMemberEmail(),
                entity.getMemberEmailReceive(),
                entity.getMemberPwQuestion(),
                entity.getMemberPwAnswer(),
                entity.getMemberGender(),
                entity.getMemberBirthDate(),
                entity.getMemberJoinDate());
    }

    public MemberResponseDto(Admin entity) {
        this(
                entity.getMemberIdx(),
                entity.getMemberId(),
                entity.getMemberPw(),
                entity.getMemberName(),
                entity.getMemberEmail(),
                0,
                0,
                "",
                "",
                LocalDate.now(),
                entity.getMemberJoinDate()
        );
    }
}
