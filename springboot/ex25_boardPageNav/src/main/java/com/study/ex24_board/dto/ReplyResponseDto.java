package com.study.ex24_board.dto;

import com.study.ex24_board.domain.reply.Reply;

import java.time.LocalDateTime;

public record ReplyResponseDto(
        Long replyIdx,
        String replyName,
        String replyContent,
        LocalDateTime replyDate,
        BoardResponseDto replyBoard
) {
    public ReplyResponseDto(Reply entity) {
        this(entity.getReplyIdx(), entity.getReplyName(), entity.getReplyContent(), entity.getReplyDate(), new BoardResponseDto(entity.getBoard()));
    }
}
