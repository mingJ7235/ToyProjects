package com.project.springbootproject.controller;

import com.project.springbootproject.service.BoardService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping ("board/*")
@AllArgsConstructor
public class BoardController {
    private BoardService boardService;

    @GetMapping("/")
    public String list() {
        return "board/list.html";
    }

    @GetMapping ("/post")
    public String write () {
        return "board/write.html";
    }

    @PostMapping ("/post")
    public String write () {
        boardService.savePost(boardDto);

        return "redirect:/";

    }


}
