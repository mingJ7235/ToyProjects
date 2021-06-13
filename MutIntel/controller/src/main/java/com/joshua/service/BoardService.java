package com.joshua.service;

import com.joshua.domain.BoardVO;
import com.joshua.domain.Criteria;

import java.util.List;

public interface BoardService {

    public List<BoardVO> getList();

    public List<BoardVO> getList(Criteria cri);

    public int getTotal (Criteria cri);

    public void register(BoardVO board);

    public BoardVO getBoard (Long bno);

    public int delete (Long bno);

    public int update(BoardVO board);

}
