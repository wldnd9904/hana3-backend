package com.study.ex24_board.domain.board;

import com.study.ex24_board.domain.reply.Reply;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name = "board")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_idx", nullable = false)
    private Long boardIdx;

    @Column(name = "board_name", nullable = false)
    private String boardName;

    @Column(name = "board_title", nullable = false)
    private String boardTitle;

    @Column(name = "board_content", nullable = false)
    private String boardContent;

    @Column(name = "board_hit", nullable = false)
    private int boardHit;

    @Column(name = "board_date", nullable = false)
    private LocalDateTime boardDate;

    @OneToMany(mappedBy = "board", cascade = CascadeType.PERSIST)
    private List<Reply> replyList;

    //매개변수 있는 생성자
    public Board(String boardName, String boardTitle, String boardContent, int boardHit) {
        this.boardName = boardName;
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
        this.boardHit = boardHit;
        this.boardDate = LocalDateTime.now();
    }

    public void addReply(Reply reply) {
        replyList.add(reply);
        reply.setBoard(this);
    }

    public void update(String boardName, String boardTitle,
                       String boardContent) {
        this.boardName = boardName;
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
        this.boardDate = LocalDateTime.now(); //현재시간으로 업데이트
    }
}
//    -- 기본키, 작성자, 글제목, 글내용, 작성일, 조회수
//    CREATE TABLE `board`(
//    board_idx       BIGINT PRIMARY KEY AUTO_INCREMENT,
//    board_name      VARCHAR(255),
//    board_title     VARCHAR(255),
//    board_content   TEXT,
//    board_date      DATETIME DEFAULT NOW(),
//    board_hit       INT DEFAULT 0
//    );
