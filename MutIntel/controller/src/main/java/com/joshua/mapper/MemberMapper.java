package com.joshua.mapper;

import com.joshua.domain.MemberVO;
import org.apache.ibatis.annotations.Param;

public interface MemberMapper {

    public int join (MemberVO member);

    public int checkId (String memberId);

    public int checkEmail (String memberEmail);

    public int login (@Param("memberId") String memberId, @Param ("memberPw") String memberPw);

    public MemberVO readMember (String memberId);

    public int findIdCheck (@Param("memberName") String memberName, @Param("memberEmail") String memberEmail);

    public String findId (@Param("memberName") String memberName, @Param("memberEmail") String memberEmail);

    public int findPwCheck (@Param("memberId") String memberId, @Param("memberEmail") String memberEmail);

    public int updatePw (MemberVO member);
}