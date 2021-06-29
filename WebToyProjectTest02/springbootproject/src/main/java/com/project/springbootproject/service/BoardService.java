package com.project.springbootproject.service;

import com.project.springbootproject.domain.entity.BoardEntity;
import com.project.springbootproject.dto.BoardDto;
import com.project.springbootproject.dto.GalleryDto;
import com.project.springbootproject.repository.BoardRepository;
import com.project.springbootproject.repository.GalleryRepository;
import jdk.nashorn.internal.runtime.regexp.joni.ast.BackRefNode;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.swing.*;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BoardService {

    private static final int BLOCK_PAGE_NUM_COUNT = 5; //한 블럭에 존재하는 게시판 페이지 번호 수
    private static final int PAGE_POST_COUNT = 4; //한 페이지에 존재하여 볼수 있는 게시글 수

    private BoardRepository boardRepository;
    private GalleryRepository galleryRepository;

    //게시판 등록하기 (수정하기도 마찬가지로 savePost를 사용한다.
    //save()메소드는 UPDATE, INSERT 둘다 사용가능하다.
    @Transactional
    public Long savePost (BoardDto boardDto) {
        return boardRepository.save(boardDto.toEntity()).getId();
    }

    //게시판 목록 불러오기
    @Transactional
    public List<BoardDto> getBoardlist(Integer pageNum) {

        Page<BoardEntity> page = boardRepository.findAll(PageRequest.of(pageNum -1, PAGE_POST_COUNT,
                Sort.by(Sort.Direction.ASC,
                        "createdDate")));

        List<BoardEntity> boardEntities = page.getContent();
        List<BoardDto> boardDtoList = new ArrayList<>();

        for (BoardEntity boardEntity : boardEntities) {
            boardDtoList.add(this.convertEntityToDto(boardEntity));
        }
        return boardDtoList;
    }

    @Transactional
    public Long getBoardCount() {
        System.out.println("게시판 갯수 (getBoardCount()의 리턴값) :" + boardRepository.count());
        return  boardRepository.count();
    }

    //페이지 연산
    public Integer[] getPageList(Integer curPageNum) {
        Integer[] pageList = new Integer[BLOCK_PAGE_NUM_COUNT];

        //총 게시글 갯수
        Double postsTotalCount = Double.valueOf(this.getBoardCount());

        //총 게시글 기준으로 계산한 마지막 페이지 번호 계산 -> 올림으로 계산해야한다
        //총 게시글을 한페이지에 볼 수 있는 수로 나누면 마지막 페이지 번호가 나오게된다.
        Integer totalLastPageNum = (int)(Math.ceil(postsTotalCount / PAGE_POST_COUNT));

        Integer blockStartPageNum =
                (curPageNum <= BLOCK_PAGE_NUM_COUNT / 2) ? 1 : curPageNum - BLOCK_PAGE_NUM_COUNT/2;

        //현재 페이지를 기준으로 블럭의 마지막 페이지 번호 계산
        Integer blockLastPageNum =
                (totalLastPageNum > blockStartPageNum + BLOCK_PAGE_NUM_COUNT -1) ? blockStartPageNum + BLOCK_PAGE_NUM_COUNT -1 : totalLastPageNum;
        //페이지 시작 번호 조정
        //curPageNum = (curPageNum <= 3) ? 1 : curPageNum - 2;

        //페이지 번호 할당
        for (int val = blockStartPageNum, idx = 0; val <= blockLastPageNum; val++, idx++) {
            pageList[idx] = val;
        }

        return pageList;
    }

    //게시판 상세보기 (return으로 BoardDTO 넘기기)
    @Transactional
    public BoardDto getPost (Long id) {
        Optional<BoardEntity> boardEntityWrapper = boardRepository.findById(id);
        BoardEntity boardEntity = boardEntityWrapper.get();

        BoardDto boardDto = BoardDto.builder()
                .id(boardEntity.getId())
                .title(boardEntity.getTitle())
                .content(boardEntity.getContent())
                .writer(boardEntity.getWriter())
                .createdDate(boardEntity.getCreatedDate())
                .build();

        return boardDto;
    }

    //게시판 삭제하기
    @Transactional
    public void deletePost (Long id) {
        boardRepository.deleteById(id);
    }

    // keyword 받아서 게시판 검색 => search
    @Transactional
    public List<BoardDto> searchPosts (String keyword) {
        //findByWriterContaining을 쓴 이유는 작성자에서 검색하기위함이다. 이걸활용해볼것
        //List<BoardEntity> boardEntities = boardRepository.findByWriterContaining(keyword);
        List<BoardEntity> boardEntities = boardRepository.findByTitleContaining(keyword);
        List<BoardDto> boardDtoList = new ArrayList<>();

        //검색결과가 없을 경우
        if(boardEntities.isEmpty()) {
            return boardDtoList;
        }

        //검색결과가 있을 경우 for문 돌려서 entity에 담고, 이걸 다시 list에 담는다.
        for (BoardEntity boardEntity : boardEntities) {
            boardDtoList.add(this.convertEntityToDto(boardEntity));
        }
        return boardDtoList;
    }

    //Entity를 다시 Dto에 변환하기위한 메소드
    private BoardDto convertEntityToDto (BoardEntity boardEntity) {
        return BoardDto.builder()
                .id(boardEntity.getId())
                .title(boardEntity.getTitle())
                .content(boardEntity.getContent())
                .writer(boardEntity.getWriter())
                .createdDate(boardEntity.getCreatedDate())
                .build();
    }

}
