package com.study.exam01.dto.customer;


import com.study.exam01.domain.customer.One2OneReply;

import java.time.LocalDate;

public record One2OneReplyResponseDto(
        Long one2OneIdx,
        String one2OneContent,
        String one2OneName,
        LocalDate one2OneDate,
        Long one2OneEmail
) {
    public One2OneReplyResponseDto(One2OneReply entity) {
        this(
                entity.getOne2OneIdx(),
                entity.getOne2OneContent(),
                entity.getOne2OneName(),
                entity.getOne2OneDate(),
                entity.getOne2OneEmail()
        );
    }
}
