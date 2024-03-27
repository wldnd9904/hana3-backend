package com.study.pr03vm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ProductWithIndex extends Product {
    private int index;

    public ProductWithIndex(String name, int price, LocalDate limit_date, int index) {
        super(name, price, limit_date);
        this.index = index;
    }
}
