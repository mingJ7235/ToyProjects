package com.joshua.service;

import com.joshua.domain.Criteria;
import com.joshua.domain.ReplyPageDTO;
import com.joshua.domain.ReplyVO;
import com.joshua.mapper.BoardMapper;
import com.joshua.mapper.ReplyMapper;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Log4j
@AllArgsConstructor
public class ReplyServiceImple implements ReplyService{

    private ReplyMapper mapper;
    private BoardMapper boardMapper;

    @Transactional
    @Override
    public int register(ReplyVO reply) {
        boardMapper.updateReplyCnt(reply.getBno(), 1);
        return mapper.insert(reply);
    }

    @Override
    public ReplyVO getReply(Long rno) {
        return mapper.read(rno);
    }

    @Override
    public ReplyPageDTO getListWithPaging(Criteria cri, Long bno) {
        return new ReplyPageDTO(mapper.getTotal(bno), mapper.getListWithPaging(cri, bno));
    }

    @Override
    public int update(ReplyVO reply) {
        return mapper.update(reply);
    }

    @Transactional
    @Override
    public int delete(Long rno) {
        boardMapper.updateReplyCnt(mapper.read(rno).getBno(), -1);
        return mapper.delete(rno);
    }
}
