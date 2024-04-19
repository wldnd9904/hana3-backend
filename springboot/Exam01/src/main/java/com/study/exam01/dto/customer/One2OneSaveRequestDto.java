package com.study.exam01.dto.customer;

import com.study.exam01.domain.customer.One2One;

public record One2OneSaveRequestDto(
        String name,
        String tel,
        String email,
        String address,
        String detailAddress,
        String title,
        String desc
) {
    public One2One toEntity() {
        return One2One.builder()
                .one2OnePhone(tel)
                .one2OneName(name)
                .one2OneEmail(email)
                .one2OneAddress(address + detailAddress)
                .one2OneTitle(title)
                .one2OneContent(desc)
                .build();
    }
}
