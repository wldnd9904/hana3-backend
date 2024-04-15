package com.study.ex24_board.dto;

import com.study.ex24_board.domain.board.Board;

import java.time.LocalDateTime;

public record BoardSaveRequestDto(String boardTitle, String boardContent, String boardName) {
    public Board toEntity() {
        return Board.builder()
                .boardContent(boardContent)
                .boardName(boardName)
                .boardTitle(boardTitle)
                .boardHit(0)
                .boardDate(LocalDateTime.now())
                .build();
    }
}