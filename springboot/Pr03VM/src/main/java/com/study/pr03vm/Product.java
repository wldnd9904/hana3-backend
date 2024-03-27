package com.study.pr03vm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Product {
    private String name; // 상품명
    private int price; // 가격
    private LocalDate limit_date; // 유통기한
}