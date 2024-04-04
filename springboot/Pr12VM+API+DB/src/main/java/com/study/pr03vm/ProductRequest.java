package com.study.pr03vm;

import java.time.LocalDate;

public record ProductRequest(
        long id,
        String name,
        int price,
        LocalDate limit_date
) {
    public ProductEntity toProductEntity() {
        return new ProductEntity(id, name, price, limit_date);
    }
}