package com.study.ex24_board.controller;

import com.study.ex24_board.domain.board.Board;
import com.study.ex24_board.domain.board.BoardRepository;
import com.study.ex24_board.domain.reply.Reply;
import com.study.ex24_board.dto.ReplySaveRequestDto;
import com.study.ex24_board.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/reply")
@RequiredArgsConstructor
public class ReplyController {
    private final ReplyService replyService;
    private final BoardRepository boardRepository;

    @PostMapping("/writeReplyAction")
    @ResponseBody
    public String writeReplyAction(@ModelAttribute ReplySaveRequestDto dto, @RequestParam long replyBoardIdx) {
        Reply tmp = dto.toEntity();
        Optional<Board> optional = boardRepository.findById(replyBoardIdx);
        if (optional.isEmpty())
            return String.format("<script>alert('댓글쓰기 실패'); history.back();</script>", replyBoardIdx);
        optional.get().addReply(tmp);
        Long newReplyIdx = replyService.save(tmp);
        boolean isFound = replyService.existById(newReplyIdx);
        if (isFound) {
            return String.format("<script>alert('댓글쓰기 성공'); location.href='/board/content/%d';</script>", replyBoardIdx);
        } else {
            return "<script>alert('댓글쓰기 실패'); history.back();</script>";
        }
    }

    @GetMapping("/deleteAction")
    @ResponseBody
    public String deleteAction(@RequestParam(name = "id") long id) {
        boolean isDeleted = replyService.deleteById(id);
        if (isDeleted)
            return "<script>alert('댓글이 삭제되었습니다.');history.back()</script>";
        else
            return "<script>alert('삭제 실패');history.back();</script>";
    }

    @GetMapping("/all")
    public String allReplies(Model model) {
        model.addAttribute("list", replyService.findAll());
        return "replies";
    }
}
