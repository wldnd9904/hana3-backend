package com.study.exam01.dto.notice;

import com.study.exam01.domain.community.Notice;

public record NoticeEditRequestDto(
        Long noticeId,
        String memberId,
        String noticeTitle,
        String noticeContent
) {
    public Notice toEntity() {
        return Notice.builder()
                .noticeIdx(noticeId)
                .noticeMemberId(memberId)
                .noticeTitle(noticeTitle)
                .noticeContent(noticeContent)
                .build();
    }
}
