package com.study.ex14_readdb.dto;

import com.study.ex14_readdb.entity.MemberEntity;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;


public record MemberSaveDto(
//        Long id,
        String userId,
        String userPw,
        String userName,
        String userRole,
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        LocalDate joinDate,
        String userAddress
) {
    public MemberEntity toMemberEntity() {
        return new MemberEntity(0L, userId, userPw, userName, userRole, joinDate);
    }
}
