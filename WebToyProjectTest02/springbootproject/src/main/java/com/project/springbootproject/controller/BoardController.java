package com.project.springbootproject.controller;

import com.project.springbootproject.dto.BoardDto;
import com.project.springbootproject.service.BoardService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
public class BoardController {
    private BoardService boardService;

    @GetMapping ("/post")
    public String write () {
        return "board/write.html";
    }

    @PostMapping ("/post")
    public String write (BoardDto boardDto) {
        boardService.savePost(boardDto);

        return "redirect:/";
    }

    @GetMapping("/")
    public String list(Model model) {
        List<BoardDto> boardList = boardService.getBoardlist();

        //Presentation TIER 에 넘길 변수 boardList
        //Model 객체를 통해 addAttribute로 Presentation TIER에 데이터를 전달한다.
        model.addAttribute("boardList", boardList);

        return "board/list.html";
    }

    @GetMapping("/post/{no}")
    public String detail(@PathVariable("no") Long no, Model model){
        BoardDto boardDto = boardService.getPost(no);
        System.out.println("넘어오나요?");
        model.addAttribute("boardDto", boardDto);
        return "board/detail.html";
    }

    @GetMapping("/post/edit/{no}")
    public String edit (@PathVariable("no") Long no, Model model) {
        BoardDto boardDto = boardService.getPost(no);
        model.addAttribute("boardDto", boardDto);
        return "board/update.html";
    }

    @PutMapping("/post/edit/{no}")
    public String update(BoardDto boardDto) {
        boardService.savePost(boardDto);

        return "redirect:/";
    }

    @DeleteMapping("/post/{no}")
    public String delete(@PathVariable("no") Long no) {
        boardService.deletePost(no);

        return "redirect:/";
    }





}
