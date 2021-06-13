package com.joshua.mapper;

import com.joshua.domain.Criteria;
import com.joshua.domain.ReplyVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReplyMapper {

    public int insert (ReplyVO reply) ;

    public ReplyVO read (Long rno);

    public int update (ReplyVO reply);

    public int delete (Long rno);

    public List<ReplyVO> getListWithPaging (@Param("cri") Criteria cri, @Param("bno") Long bno);

    public int getTotal(Long bno);
}
