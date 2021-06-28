package com.project.springbootproject.controller;

import com.project.springbootproject.dto.BoardDto;
import com.project.springbootproject.dto.GalleryDto;
import com.project.springbootproject.service.BoardService;
import com.project.springbootproject.service.S3Service;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@AllArgsConstructor
public class BoardController {
    //private S3Service s3Service;
    private BoardService boardService;


    //게시판 목록 (게시판메인)
    @GetMapping("/board")
    //defaultValue를 설정해줘야한다. 그렇지않으면 초기 접속시 길을 잃는다.
    public String list(Model model, @RequestParam (value="page", defaultValue = "1") Integer pageNum) {
        List<BoardDto> boardList = boardService.getBoardlist(pageNum);
            //pageList는 service에서 비지니스 로직을 통해 연산되어 나온다.
        Integer[] pageList = boardService.getPageList(pageNum);

        //Presentation TIER 에 넘길 변수 boardList
        //Model 객체를 통해 addAttribute로 Presentation TIER에 데이터를 전달한다.
        model.addAttribute("boardList", boardList);
        model.addAttribute("pageList" , pageList);

        return "board/list";
    }

    //글쓰기 페이지 이동
    @GetMapping ("/post")
    public String write () {
        return "board/write";
    }

    //글쓰기 기능
    //@RequestMapping(value = "/post", method = {RequestMethod.POST})
    @PostMapping ("/post")
    public String write (BoardDto boardDto) {
        System.out.println("들어옴?");
        boardService.savePost(boardDto);

        return "redirect:/board";
    }

    //게시판 상세보기 페이지 이동
    @GetMapping("/post/{no}")
    public String detail(@PathVariable("no") Long no, Model model){
        BoardDto boardDto = boardService.getPost(no);
        model.addAttribute("boardDto", boardDto);
        return "board/detail";
    }

    //게시판 수정 페이지 이동
    @GetMapping("/post/edit/{no}")
    public String edit (@PathVariable("no") Long no, Model model) {
        BoardDto boardDto = boardService.getPost(no);
        model.addAttribute("boardDto", boardDto);
        return "board/update";
    }

    //게시판 수정 기능
    @PutMapping("/post/edit/{no}")
    public String update(BoardDto boardDto) {
        //수정 메소드 확인용 (변경된 content가 담겨서 넘어오는지)
        System.out.println(boardDto.getContent()); //확인 . 데이터는 넘어감 즉, content값이 수정되엇음
        boardService.savePost(boardDto);

        return "redirect:/board";
    }

    //게시판 삭제 기능
    @DeleteMapping("/post/{no}")
    public String delete(@PathVariable("no") Long no) {
        boardService.deletePost(no);

        return "redirect:/board";
    }

    //게시판 검색기능
    @GetMapping("/board/search")
    public String search(@RequestParam(value = "keyword") String keyword, Model model){
        List<BoardDto> boardDtoList = boardService.searchPosts(keyword);

        model.addAttribute("boardList", boardDtoList);

        return "board/list";
    }


}
