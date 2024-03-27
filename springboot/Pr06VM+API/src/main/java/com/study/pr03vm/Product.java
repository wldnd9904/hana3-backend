package com.study.pr03vm;

import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    protected String name; // 상품명
    protected int price; // 가격
    protected LocalDate limit_date; // 유통기한
}