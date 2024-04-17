package com.study.ex24_board.domain.reply;

import com.study.ex24_board.domain.board.Board;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
public class Reply {
    @Id
    @Column(name = "reply_idx", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long replyIdx;

    @Column(name = "reply_name", nullable = false)
    private String replyName;

    @Column(name = "reply_content", nullable = false)
    private String replyContent;

    @Column(name = "reply_date", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime replyDate = LocalDateTime.now();

    @Setter
    @ManyToOne
    @JoinColumn(name = "board_idx")
    private Board board;

    public void update(String replyName, String replyContent) {
        this.replyName = replyName;
        this.replyContent = replyContent;
        this.replyDate = LocalDateTime.now();
    }
}

// CREATE TABLE reply(
// reply_idx       BIGINT PRIMARY KEY AUTO_INCREMENT,
// reply_name      VARCHAR(255),
// reply_content   VARCHAR(255),
// reply_date      DATETIME DEFAULT NOW(),
// reply_board_idx BIGINT NOT NULL
// );