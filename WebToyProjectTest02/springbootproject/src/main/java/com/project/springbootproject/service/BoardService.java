package com.project.springbootproject.service;

import com.project.springbootproject.domain.entity.BoardEntity;
import com.project.springbootproject.dto.BoardDto;
import com.project.springbootproject.repository.BoardRepository;
import jdk.nashorn.internal.runtime.regexp.joni.ast.BackRefNode;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.*;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BoardService {
    private BoardRepository boardRepository;

    //게시판 등록하기 (수정하기도 마찬가지로 savePost를 사용한다.
    //save()메소드는 UPDATE, INSERT 둘다 사용가능하다.
    @Transactional
    public Long savePost (BoardDto boardDto) {
        return boardRepository.save(boardDto.toEntity()).getId();
    }

    //게시판 목록 불러오기
    @Transactional
    public List<BoardDto> getBoardlist() {
        List<BoardEntity> boardEntities = boardRepository.findAll();
        List<BoardDto> boardDtoList = new ArrayList<>();

        for (BoardEntity boardEntity : boardEntities) {
            BoardDto boardDto = BoardDto.builder()
                    .id(boardEntity.getId())
                    .title(boardEntity.getTitle())
                    .content(boardEntity.getContent())
                    .writer(boardEntity.getWriter())
                    .createdDate(boardEntity.getCreatedDate())
                    .build();

            boardDtoList.add(boardDto);
        }

        return boardDtoList;
    }

    //게시판 상세보기 (return으로 BoardDTO 넘기기)
    @Transactional
    public BoardDto getPost (Long id) {
        Optional<BoardEntity> boardEntityWrapper = boardRepository.findById(id);
        BoardEntity boardEntity = boardEntityWrapper.get();

        BoardDto boardDto = BoardDto.builder()
                .id(boardEntity.getId())
                .title(boardEntity.getTitle())
                .content(boardEntity.getTitle())
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
