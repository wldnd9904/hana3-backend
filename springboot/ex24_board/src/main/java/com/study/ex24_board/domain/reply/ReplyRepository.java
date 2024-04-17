package com.study.ex24_board.domain.reply;

import jakarta.persistence.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReplyRepository extends JpaRepository<Reply, Long> {
    // findAll, existsById, save(update, insert), delete
    List<Reply> findAllByReplyBoardIdx(Long replyBoardIdx);
}
