package com.example.demo.mapper;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.print.attribute.standard.MediaSize;

@Repository
public class MemberMapper {
    protected static final String NAMESPACE = "com.example.demo.mapper.";

    @Autowired
    private SqlSession sqlSession;

    public String selectMemberID () {
        return sqlSession.selectOne(NAMESPACE + "selectMemberID");
    }
}
