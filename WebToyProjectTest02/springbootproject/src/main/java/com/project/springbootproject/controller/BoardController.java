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

    //게시판 목록 (게시판메인)
    @GetMapping("/board")
    public String list(Model model) {
        List<BoardDto> boardList = boardService.getBoardlist();

        //Presentation TIER 에 넘길 변수 boardList
        //Model 객체를 통해 addAttribute로 Presentation TIER에 데이터를 전달한다.
        model.addAttribute("boardList", boardList);

        return "board/list.html";
    }

    //글쓰기 페이지 이동
    @GetMapping ("/post")
    public String write () {
        return "board/write.html";
    }

    //글쓰기 기능
    @PostMapping ("/post")
    public String write (BoardDto boardDto) {
        boardService.savePost(boardDto);

        return "redirect:/";
    }

    //게시판 상세보기 페이지 이동
    @GetMapping("/post/{no}")
    public String detail(@PathVariable("no") Long no, Model model){
        BoardDto boardDto = boardService.getPost(no);
        model.addAttribute("boardDto", boardDto);
        return "board/detail.html";
    }

    //게시판 수정 페이지 이동
    @GetMapping("/post/edit/{no}")
    public String edit (@PathVariable("no") Long no, Model model) {
        BoardDto boardDto = boardService.getPost(no);
        model.addAttribute("boardDto", boardDto);
        return "board/update.html";
    }

    //게시판 수정 기능
    @PutMapping("/post/edit/{no}")
    public String update(BoardDto boardDto) {
        boardService.savePost(boardDto);

        return "redirect:/";
    }

    //게시판 삭제 기능
    @DeleteMapping("/post/{no}")
    public String delete(@PathVariable("no") Long no) {
        boardService.deletePost(no);

        return "redirect:/";
    }

    @GetMapping("/board/search")
    public String search(@RequestParam(value = "keyword") String keyword, Model model){
        List<BoardDto> boardDtoList = boardService.searchPosts(keyword);

        model.addAttribute("boardList", boardDtoList);

        return "board/list.html";
    }

}
