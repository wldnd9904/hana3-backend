package com.study.ex24_board.controller;

import com.study.ex24_board.domain.board.Board;
import com.study.ex24_board.dto.BoardSaveRequestDto;
import com.study.ex24_board.service.BoardService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    // localhost:8080/board/
    @GetMapping("/")
    public String main() {
        return "redirect:/board/listForm";
    }

    @GetMapping("/listForm")
    public String listForm(Model model) {
        model.addAttribute("list", boardService.findAll());
        return "listForm";
    }

    @GetMapping("/content/{idx}")
    public String contentForm(Model model, @PathVariable Long idx) {
        model.addAttribute("content", boardService.findById(idx));
        return "contentForm";
    }

    @GetMapping("/writeForm")
    public String writeForm() {
        return "writeForm";
    }

    @PostMapping("/writeAction")
    @ResponseBody
    public String writeAction(@ModelAttribute BoardSaveRequestDto dto) {
        long newIdx = boardService.save(dto);
        boolean isFound = boardService.existById(newIdx);
        if (isFound)
            return "<script>alert('게시글이 작성되었습니다.');location.href='listForm'</script>";
        else
            return "<script>alert('글쓰기 실패');history.back();</script>";
    }

    @GetMapping("/deleteAction")
    @ResponseBody
    public String deleteAction(@RequestParam(name = "id") long id) {
        boolean isDeleted = boardService.deleteById(id);
        if (isDeleted)
            return "<script>alert('게시글이 삭제되었습니다.');location.href='listForm'</script>";
        else
            return "<script>alert('삭제 실패');history.back();</script>";
    }

    @PostMapping("/updateAction")
    @ResponseBody
    public String updateAction(@ModelAttribute BoardSaveRequestDto dto, @RequestParam("id") long id) {
        try {
            boardService.update(id, dto);
        } catch (Exception e) {
            return "<script>alert('수정 실패');history.back();</script>";
        }
        return "<script>alert('게시글이 수정되었습니다.');location.href='listForm'</script>";
    }
}
