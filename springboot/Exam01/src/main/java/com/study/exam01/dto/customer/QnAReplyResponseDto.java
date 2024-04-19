package com.study.exam01.dto.customer;

import com.study.exam01.domain.customer.QnA;
import com.study.exam01.domain.customer.QnAReply;

import java.time.LocalDate;

public record QnAReplyResponseDto(
        Long qnaReplyIdx,
        String qnaReplyContent,
        String qnaReplyName,
        LocalDate qnaReplyDate,
        Long qnaReplyQnaIdx
) {
    public QnAReplyResponseDto(QnAReply entity) {
        this(
                entity.getQnaReplyIdx(),
                entity.getQnaReplyContent(),
                entity.getQnaReplyName(),
                entity.getQnaReplyDate(),
                entity.getQnaReplyQnaIdx()
        );
    }
}
