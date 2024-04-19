package com.study.exam01.dto.customer;

import com.study.exam01.domain.customer.One2One;

import java.time.LocalDate;

public record One2OneResponseDto(
        Long one2OneIdx,
        String one2OneName,
        String one2OnePhone,
        String one2OneEmail,
        String one2OneAddress,
        String one2OneTitle,
        String one2OneContent,
        LocalDate one2OneDate
) {
    public One2OneResponseDto(One2One entity) {
        this(
                entity.getOne2OneIdx(),
                entity.getOne2OneName(),
                entity.getOne2OnePhone(),
                entity.getOne2OneEmail(),
                entity.getOne2OneAddress(),
                entity.getOne2OneTitle(),
                entity.getOne2OneContent(),
                entity.getOne2OneDate()
        );
    }
}
