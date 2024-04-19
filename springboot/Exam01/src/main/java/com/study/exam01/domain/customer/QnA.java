package com.study.exam01.domain.customer;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Entity
@Builder
@Table(name = "company_qna")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class QnA {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "qna_idx")
    private Long qnaIdx;
    @Column(name = "qna_name")
    private String qnaName;
    @Column(name = "qna_pw")
    private String qnaPw;
    @Column(name = "qna_title")
    private String qnaTitle;
    @Column(name = "qna_content")
    private String qnaContent;
    @Column(name = "qna_date")
    @Builder.Default
    private LocalDate qnaDate = LocalDate.now();
}
