package com.project.springbootproject.service;

import com.project.springbootproject.domain.entity.BoardEntity;
import com.project.springbootproject.dto.BoardDto;
import com.project.springbootproject.repository.BoardRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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

    //게시판 상세보기
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

}
