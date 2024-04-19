package com.study.exam01.dto.notice;

import com.study.exam01.domain.community.Notice;

public record NoticeWriteRequestDto(
        String memberId,
        String noticeTitle,
        String noticeContent
) {
    public Notice toEntity() {
        return Notice.builder()
                .noticeMemberId(memberId)
                .noticeTitle(noticeTitle)
                .noticeContent(noticeContent)
                .build();
    }
}
