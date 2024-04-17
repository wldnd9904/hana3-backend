package com.study.ex24_board.dto;

import com.study.ex24_board.domain.reply.Reply;
import lombok.Builder;

@Builder
public record ReplySaveRequestDto(
        String replyContent,
        String replyName
) {
    public Reply toEntity() {
        return
                Reply.builder()
                        .replyContent(this.replyContent)
                        .replyName(this.replyName)
                        .build();
    }
}
