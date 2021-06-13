package com.joshua.controller;


import com.joshua.domain.MemberVO;
import com.joshua.service.MemberService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
@Log4j
//@RequestMapping()
@RequestMapping("/member/*")
@AllArgsConstructor
public class MemberController {
    private MemberService service;

    private static final int KEY = 5;

    @GetMapping("/home")
    public void home () {

    }
    //@GetMapping("/member/join")
    @GetMapping("/join")
    public void join () {

    }


    @PostMapping("/join")
    public String join (MemberVO member, RedirectAttributes rttr) {
        member.setMemberPw(encrypt(member.getMemberPw()));
        service.join(member);
        return "redirect:/member/login";
    }

    @GetMapping("/login")
    public void login () {

    }

    @PostMapping("/login")
    public String login(String memberId, String memberPw, RedirectAttributes rttr) {

        memberPw = encrypt(memberPw);
        String result = "";
        //로그인 성공
        if (service.login(memberId, memberPw) > 0 ) {
            log.info("login 성공");
            rttr.addFlashAttribute("sessionID", memberId);
            result = "redirect:/member/home";
        }
        //로그인 실패
        else {
            log.info("login 실패");
            result = "redirect:/member/login";
        }

        return result ;

    }

    //암호화
    public String encrypt(String pw) {
        String en_pw = "";
        for (int i = 0; i < pw.length(); i++) {
            en_pw += (char)(pw.charAt(i) * KEY);
        }
        return en_pw;
    }

    //복호화
    public String decrypt(String en_pw) {
        String de_pw = "";
        for (int i = 0; i < en_pw.length(); i++) {
            de_pw += (char)(en_pw.charAt(i) / KEY);
        }
        return de_pw;
    }

    //아이디 찾기 페이지 이동
    @GetMapping("/findId")
    public void findId () {

    }

    @PostMapping (value = "/findId")
    public String findId(String memberName, String memberEmail, RedirectAttributes rttr) { //member객체 모든거 안보내도 매핑해서 해결하는지 테스트

        log.info("memberName : " + memberName);
        log.info("memberEmail : " + memberEmail);

        String result = "";
        String memberId = service.findId(memberName, memberEmail);

        //이름과 이메일 주소가 DB에 있을 때,
        if(memberId != "") {
            Map<String, String> map = new HashMap();
            map.put("memberId", memberId);
            map.put("memberName", memberName);

            memberId = service.findId(memberName, memberEmail);
            rttr.addFlashAttribute("map", map);
            result = "redirect:/member/findIdResult";
        }else {
            //일치하지 않을 때
            memberId = service.findId(memberName, memberEmail);
            result = "redirect:/member/findId";
        }
        return result;

    }
    //찾아진 아이디 나오는 페이지
    @GetMapping (value="/findIdResult")
    public void findIdResult () {

    }

    //비밀번호 변경 페이지 이동
    @GetMapping (value="/findPw")
    public void findPw () {

    }


    //ajax통신 -> 아이디 중복 체크
    @GetMapping (value = "/checkId", produces = "text/plain; charset=utf-8")
    @ResponseBody
    public ResponseEntity<String> checkId (String memberId) {
        log.info(memberId);
        return service.checkId(memberId) == 0 ? new ResponseEntity<String> ("1", HttpStatus.OK) : new ResponseEntity<String> ("0", HttpStatus.OK);

    }

    //ajax통신 -> 이메일 중복 체크
    @GetMapping (value ="/checkEmail", produces = {MediaType.TEXT_PLAIN_VALUE})
    @ResponseBody
    public ResponseEntity<String> checkEmail (String memberEmail) {
        log.info("checkEmail : " + memberEmail);
        String result = "";

        //이메일이 중복되지 않는 경우
        if (service.checkEmail(memberEmail) == 0) {
            result = "1";
        }else {
            result = "0";
        }
        log.info(result);


        return result != "" ? new ResponseEntity<String> (result, HttpStatus.OK) : new ResponseEntity<String> (HttpStatus.INTERNAL_SERVER_ERROR);
        //return service.checkEmail(memberEmail) == 0 ? new ResponseEntity<String> ("1", HttpStatus.OK) : new

    }

    /* 비밀번호 찾기 */
//	@RequestMapping(value = "/findpw", method = RequestMethod.GET)
    @GetMapping(value = "/findpw")
    public void findPwGET() throws Exception{

    }

    //	@RequestMapping(value = "/findpw", method = RequestMethod.POST)
    @PostMapping(value = "/findpw")
    public void findPwPOST(@ModelAttribute MemberVO member, HttpServletResponse response) throws Exception{
//	public void findPwPOST(String memberId, String memberEmail, HttpServletResponse response) throws Exception{
        log.info("post메핑 완료");
        //	log.info(memberId + "  " + memberEmail);
        log.info(response);
        log.info(response);
        service.findPw(response, member);
    }



//	@PostMapping("/findId")
//	public String findId () {
//
//	}



}



