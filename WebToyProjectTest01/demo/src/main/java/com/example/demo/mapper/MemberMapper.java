package com.example.demo.mapper;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.print.attribute.standard.MediaSize;

@Repository
public class MemberMapper {
    protected static final String NAMESPACE = "com.example.demo.mapper.";

    private SqlSession sqlSession;

    public String test () {
        return sqlSession.selectOne(NAMESPACE + "test");
    }
}
