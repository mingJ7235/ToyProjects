package com.project.springbootproject.repository;

import com.project.springbootproject.domain.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> {
    //검색하는 column의 이름에 따라서 findBy____Containing을해주면 된다.
    //제목에서 keyword를 검색하고 싶으면 findByTitleContaing (board 라는 테이블의 제목을 명시한 column명이 title이다.)
    //List<BoardEntity> findByWriterContaining (String keyword);
    List<BoardEntity> findByTitleContaining (String keyword);
}
