package com.study.exam01.domain.customer;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Entity
@Builder
@Table(name = "company_one2one")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class One2One {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "one2one_idx")
    private Long one2OneIdx;
    @Column(name = "one2one_name")
    private String one2OneName;
    @Column(name = "one2one_phone")
    private String one2OnePhone;
    @Column(name = "one2one_email")
    private String one2OneEmail;
    @Column(name = "one2one_address")
    private String one2OneAddress;
    @Column(name = "one2one_title")
    private String one2OneTitle;
    @Column(name = "one2one_content")
    private String one2OneContent;
    @Column(name = "one2one_date")
    @Builder.Default
    private LocalDate one2OneDate = LocalDate.now();
}
