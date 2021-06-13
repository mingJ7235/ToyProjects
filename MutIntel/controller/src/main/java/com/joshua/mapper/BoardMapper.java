package com.joshua.mapper;

import com.joshua.domain.BoardVO;
import com.joshua.domain.Criteria;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BoardMapper {

    public List<BoardVO> getList();

    public List<BoardVO> getListWithPaging(Criteria cri);

    public int getTotal(Criteria cri);

    public void insert(BoardVO board);

    public void insertSelectKey_bno(BoardVO board);

    public BoardVO read(Long bno);

    public int delete(Long bno);

    public int update(BoardVO board);

    public int updateReplyCnt(@Param("bno") Long bno, @Param("amount") int amount);


}

