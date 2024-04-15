package com.study.ex24_board.dto;

import com.study.ex24_board.domain.board.Board;

import java.time.LocalDateTime;

public record BoardResponseDto(
        long boardIdx,
        String boardName,
        String boardTitle,
        String boardContent,
        int boardHit,
        LocalDateTime boardDate) {
    public BoardResponseDto(Board entity) {
        this(entity.getBoardIdx(), entity.getBoardName(), entity.getBoardTitle(), entity.getBoardContent(), entity.getBoardHit(), entity.getBoardDate());
    }
}
