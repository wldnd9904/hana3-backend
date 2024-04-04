
package com.study.pr03vm;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name = "product")
@Getter
@AllArgsConstructor
@NoArgsConstructor // @ModelAttribute @RequestBody ㅁㅐ핑시 필요
public class ProductEntity {
    @Id
    @Column
    private long id;
    @Column
    private String name; // 상품명
    @Column
    private int price; // 가격
    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate limitDate; // 유통기한
}
