package com.study.ex14_readdb.controller;

import com.study.ex14_readdb.dao.IMemberDao;
import com.study.ex14_readdb.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class MainController {
    final IMemberDao memberDao;

    @GetMapping("/")
    public String main(Model model) {
        List<MemberDto> list = memberDao.list();
        model.addAttribute("list", list);
        model.addAttribute("count", memberDao.count());
        return "index";
    }

    @GetMapping("/viewMember")
    public String view(@RequestParam long id, Model model) {
        Optional<MemberDto> optional = memberDao.getById(id);
        if (optional.isPresent()) {
            model.addAttribute("member", optional.get());
        } else {
            System.out.println("회원정보가 없습니다.");
            return "redirect:/";
        }

        return "modifyForm";

    }

    @GetMapping("/deleteDTO")
    public String delete(@RequestParam long id, Model model) {
        memberDao.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/joinForm")
    public String joinForm() {
        return "joinForm";
    }

    @PostMapping("joinAction")
    @ResponseBody
    public String joinAction(@ModelAttribute MemberDto dto) {
        System.out.println("name:" + dto.userName());
        try {
            memberDao.insert(dto);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            System.out.println("회원가입 실패");
            return "<script>alert('회원가입 실패');location.href='/joinForm';</script>";
        }
        return "<script>alert('회원가입 성공');location.href='/';</script>";
    }

    @PostMapping("/modifyAction")
    @ResponseBody
    public String modifyAction(@ModelAttribute MemberDto dto) {
        try {
            memberDao.update(dto);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("회원정보수정 실패");
            return "<script>alert('회원정보수정 실패');history.back();</script>";
        }
        System.out.println("회원정보수정 성공");
        return "<script>alert('회원정보수정 성공');location.href='/';</script>";
    }


}
