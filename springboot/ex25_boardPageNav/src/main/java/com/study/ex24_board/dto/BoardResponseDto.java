package com.study.ex24_board.dto;

import com.study.ex24_board.domain.board.Board;
import com.study.ex24_board.domain.reply.Reply;

import java.time.LocalDateTime;
import java.util.List;

public record BoardResponseDto(
        long boardIdx,
        String boardName,
        String boardTitle,
        String boardContent,
        int boardHit,
        LocalDateTime boardDate,
        List<Reply> replyList
) {
    public BoardResponseDto(Board entity) {
        this(entity.getBoardIdx(), entity.getBoardName(), entity.getBoardTitle(), entity.getBoardContent(), entity.getBoardHit(), entity.getBoardDate(), entity
                .getReplyList());
    }
}
