package com.study.exam01.domain.customer;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Entity
@Builder
@Table(name = "company_qna_reply")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class QnAReply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "qna_reply_idx")
    private Long qnaReplyIdx;
    @Column(name = "qna_reply_content")
    private String qnaReplyContent;
    @Column(name = "qna_reply_name")
    private String qnaReplyName;
    @Column(name = "qna_reply_date")
    @Builder.Default
    private LocalDate qnaReplyDate = LocalDate.now();
    @Column(name = "qna_reply_qna_idx")
    private Long qnaReplyQnaIdx;
}
