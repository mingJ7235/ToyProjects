package com.joshua.service;

import com.joshua.domain.MemberVO;

import javax.servlet.http.HttpServletResponse;

public interface MemberService {

    public int join (MemberVO member);

    public int checkId (String memberId);

    public int checkEmail (String memberEmail);

    public int login (String memberId, String memberPw);

    public String findId (String memberName, String memberEmail);

    //이메일발송
    public void sendEmail(MemberVO vo, String div) throws Exception;

    //비밀번호찾기
    public void findPw(HttpServletResponse resp, MemberVO vo) throws Exception;

}
