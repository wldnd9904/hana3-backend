
package com.study.pr03vm;

import java.time.LocalDate;

public record ProductDto(
        long id,
        String name, // 상품명
        int price, // 가격
        LocalDate limitDate) // 유통기한
{
}
