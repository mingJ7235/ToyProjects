package com.project.springbootproject.service;

import com.project.springbootproject.dto.BoardDto;
import com.project.springbootproject.repository.BoardRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class BoardService {
    private BoardRepository boardRepository;

    @Transactional
    public Long savePost (BoardDto boardDto) {
        return boardRepository.save(boardDto.toEntity()).getId();
    }
}
