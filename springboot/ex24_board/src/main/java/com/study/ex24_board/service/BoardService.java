package com.study.ex24_board.service;

import com.study.ex24_board.domain.board.Board;
import com.study.ex24_board.domain.board.BoardRepository;
import com.study.ex24_board.dto.BoardResponseDto;
import com.study.ex24_board.dto.BoardSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public List<BoardResponseDto> findAll() { //전체 목록 조회
        Sort sort = Sort.by(Sort.Direction.DESC, "boardDate", "boardIdx");
        List<Board> list = boardRepository.findAll(sort);
        return list.stream().map(BoardResponseDto::new).toList();
    }

    @Transactional
    public BoardResponseDto findById(long id) {
        Board entity = boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("없는 id 입니다. id:" + id));
        boardRepository.hitById(id);
        
        return new BoardResponseDto(entity);
    }

    @Transactional
    public Long save(final BoardSaveRequestDto dto) {
        Board entity = boardRepository.save(dto.toEntity());
        return entity.getBoardIdx();
    }

    @Transactional(readOnly = true)
    public boolean existById(long idx) {
        return boardRepository.existsById(idx);
    }

    @Transactional
    public boolean deleteById(long id) {
        boardRepository.deleteById(id);
        return !boardRepository.existsById(id);
    }

    @Transactional
    public Board update(final Long boardIdx, final BoardSaveRequestDto dto) {
        Board entity = boardRepository.findById(boardIdx)
                .orElseThrow(() -> new IllegalArgumentException(
                        "없는 글인덱스입니다.boardIdx:" + boardIdx));
        entity.update(dto.boardName(), dto.boardTitle(),
                dto.boardContent());
        return entity;
    }
}

