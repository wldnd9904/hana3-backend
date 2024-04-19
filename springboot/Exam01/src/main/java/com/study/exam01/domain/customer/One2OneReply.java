package com.study.exam01.domain.customer;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Entity
@Builder
@Table(name = "company_one2one_reply")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class One2OneReply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "one2one_reply_idx")
    private Long one2OneIdx;
    @Column(name = "one2one_reply_content")
    private String one2OneContent;
    @Column(name = "one2one_reply_name")
    private String one2OneName;
    @Column(name = "one2one_reply_date")
    @Builder.Default
    private LocalDate one2OneDate = LocalDate.now();
    @Column(name = "one2one_reply_one2one_idx")
    private Long one2OneEmail;
}
