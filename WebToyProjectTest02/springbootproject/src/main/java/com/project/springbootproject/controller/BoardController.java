package com.project.springbootproject.controller;

import com.project.springbootproject.dto.BoardDto;
import com.project.springbootproject.service.BoardService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class BoardController {
    private BoardService boardService;

    @GetMapping("/")
    public String list(Model model) {
        List<BoardDto> boardList = boardService.getBoardlist();

        //Presentation TIER 에 넘길 변수 boardList
        //Model 객체를 통해 addAttribute로 Presentation TIER에 데이터를 전달한다.
        model.addAttribute("boardList", boardList);

        return "board/list.html";
    }

    @GetMapping ("/post")
    public String write () {
        return "board/write.html";
    }

    @PostMapping ("/post")
    public String write (BoardDto boardDto) {
        boardService.savePost(boardDto);

        return "redirect:/";

    }



}
