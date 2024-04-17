package com.study.ex24_board.domain.board;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
    //findAll, findById, save, delete
    @Modifying
    @Query(value = "update Board b set b.boardHit = b.boardHit + 1 where b.boardIdx=:id")
    void hitById(Long id);
}