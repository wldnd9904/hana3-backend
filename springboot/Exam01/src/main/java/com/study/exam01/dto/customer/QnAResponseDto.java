package com.study.exam01.dto.customer;

import com.study.exam01.domain.customer.QnA;
import com.study.exam01.domain.customer.QnAReply;
import jakarta.persistence.Column;
import lombok.Builder;

import java.time.LocalDate;

public record QnAResponseDto(
        Long qnaIdx,
        String qnaName,
        String qnaPw,
        String qnaTitle,
        String qnaContent,
        LocalDate qnaDate
) {
    public QnAResponseDto(QnA entity) {
        this(
                entity.getQnaIdx(),
                entity.getQnaName(),
                entity.getQnaPw(),
                entity.getQnaTitle(),
                entity.getQnaContent(),
                entity.getQnaDate()
        );
    }
}
