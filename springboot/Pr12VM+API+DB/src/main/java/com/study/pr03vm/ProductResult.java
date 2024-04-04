package com.study.pr03vm;

import java.time.LocalDate;

public record ProductResult(
        String status,
        long id,
        String name,
        int price,
        LocalDate limit_date
) {
}
