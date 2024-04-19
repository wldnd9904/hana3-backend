package com.study.exam01.dto.notice;

import com.study.exam01.domain.community.Notice;
import jakarta.persistence.Column;

import java.time.LocalDate;

public record NoticeResponseDto(
        Long noticeIdx,
        String noticeTitle,
        String noticeContent,
        String noticeMemberId,
        LocalDate noticeDate
) {
    public NoticeResponseDto(Notice entity) {
        this(
                entity.getNoticeIdx(),
                entity.getNoticeTitle(),
                entity.getNoticeContent(),
                entity.getNoticeMemberId(),
                entity.getNoticeDate()
        );
    }
}
