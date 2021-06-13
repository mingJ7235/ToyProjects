package com.joshua.service;

import com.joshua.domain.MemberVO;
import com.joshua.mapper.MemberMapper;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.apache.commons.mail.HtmlEmail;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@Service
@Log4j
@AllArgsConstructor
public class MemberServiceImple implements MemberService{
    private MemberMapper mapper;

    @Override
    public int join(MemberVO member) {
        log.info("join .....");

        return mapper.join(member);
    }

    @Override
    public int checkId(String memberId) {
        log.info("checkID for join --- ");
        return mapper.checkId(memberId);
    }
    @Override
    public int checkEmail(String memberEmail) {
        log.info("checkEmail-----");
        return mapper.checkEmail(memberEmail);
    }

    @Override
    public int login(String memberId, String memberPw) {
        log.info("login ----");
        return mapper.login(memberId, memberPw);
    }

    @Override
    public String findId(String memberName, String memberEmail) {
        String result = "";
        if (mapper.findIdCheck(memberName, memberEmail) == 1) {
            result = mapper.findId(memberName, memberEmail);
        } else {

        }

        return result;
    }

    @Override
    public void sendEmail(MemberVO vo, String div) throws Exception {
        // Mail Server 설정
        String charSet = "utf-8";
        String hostSMTP = "smtp.gmail.com"; //네이버 이용시 smtp.naver.com
        String hostSMTPid = "mutpeople@gmail.com";
        String hostSMTPpwd = "mut1234@";

        // 보내는 사람 EMail, 제목, 내용
        String fromEmail = "mutpeople@gmail.com";
        String fromName = "멋진사람들";
        String subject = "";
        String msg = "";

        if(div.equals("findpw")) {
            subject = "멋진사람들 임시 비밀번호 입니다.";
            msg += "<div align='center' style='border:1px solid black; font-family:verdana'>";
            msg += "<h3 style='color: blue;'>";
            msg += vo.getMemberId() + "님의 임시 비밀번호 입니다. 비밀번호를 변경하여 사용하세요.</h3>";
            msg += "<p>임시 비밀번호 : ";
            msg += vo.getMemberPw() + "</p></div>";
        }

        // 받는 사람 E-Mail 주소
        String mail = vo.getMemberEmail();
        try {
            HtmlEmail email = new HtmlEmail();
            email.setDebug(true);
            email.setCharset(charSet);
            email.setSSL(true);
            email.setHostName(hostSMTP);
            email.setSmtpPort(465); //네이버 이용시 587 구글은 465

            email.setAuthentication(hostSMTPid, hostSMTPpwd);
            email.setTLS(true);
            email.addTo(mail, charSet);
            email.setFrom(fromEmail, fromName, charSet);
            email.setSubject(subject);
            email.setHtmlMsg(msg);
            email.send();
        } catch (Exception e) {
            System.out.println("메일발송 실패 : " + e);
        }

    }

    @Override
    public void findPw(HttpServletResponse response, MemberVO vo) throws Exception {
        log.info("들어옴1");
        response.setContentType("text/html;charset=utf-8");
        MemberVO ck = mapper.readMember(vo.getMemberId());
        PrintWriter out = response.getWriter();
        // 가입된 아이디가 없으면
        if(mapper.checkId(vo.getMemberId()) == 0) {
            log.info("들어옴2");
            out.print("등록되지 않은 아이디입니다.");
            out.close();
        }
        // 가입된 이메일이 아니면
        else if(!vo.getMemberEmail().equals(ck.getMemberEmail())) {
            log.info("들어옴3");
            out.print("등록되지 않은 이메일입니다.");
            out.close();
        }else {
            log.info("들어옴4");
            // 임시 비밀번호 생성
            String pw = "";
            for (int i = 0; i < 12; i++) {
                pw += (char) ((Math.random() * 26) + 97);
            }
            vo.setMemberPw(pw);
            // 비밀번호 변경
            mapper.updatePw(vo);
            // 비밀번호 변경 메일 발송
            sendEmail(vo, "findpw");

            out.print("이메일로 임시 비밀번호를 발송하였습니다.");
            out.close();
        }

    }






}
