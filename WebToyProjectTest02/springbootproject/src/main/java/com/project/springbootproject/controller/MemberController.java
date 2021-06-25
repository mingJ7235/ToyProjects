package com.project.springbootproject.controller;

import com.project.springbootproject.dto.MemberDto;
import com.project.springbootproject.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Map;

@Controller
@AllArgsConstructor
public class MemberController {
    private MemberService memberService;

    //로그인, 로그아웃에대한 페이지 이동만있고 로직에 대한 것은 없다. 이것을 유념해서 보기

    //메인페이지
    @GetMapping("/")
    public String home() {
        return "member/mainpage";
    }

    //회원가입
    @GetMapping("/user/signup")
    public String dispSignup (MemberDto memberDto) {
        return "member/signup";
    }

    //회원가입 로직 처리
    @PostMapping("/user/signup")
    public String execSignup (@Valid MemberDto memberDto, Errors errors, Model model) {
        if(errors.hasErrors()) {
            //회원가입 실패시, 입력 데이터를 유지
            model.addAttribute("memberDto", memberDto);
            //유효성 통과 못한 필드와 메시지 핸들링
            Map<String, String> validatorResult = memberService.validateHandling(errors);

            for(String key : validatorResult.keySet()) {
                model.addAttribute(key, validatorResult.get(key));
            }
            return "member/signup";
        }
        //에러가 아니라면
        memberService.joinUser(memberDto);
        return "redirect:/user/login";
    }

    //로그인 페이지
    @GetMapping("/user/login")
    public String dispLogin() {
        return "member/login";
    }

    //로그인 결과 페이지
    @GetMapping("/user/login/result")
    public String dispLoginResult() {
        return "member/loginSuccess";
    }

    //로그아웃 결과 페이지
    @GetMapping("/user/logout/result")
    public String dispLogout() {
        return "member/logout";
    }

    //접근 거부 페이지
    @GetMapping("/user/denied")
    public String dispDenied() {
        return "member/denied";
    }

    //내정보 페이지
    @GetMapping ("/user/info")
    public String dispMyinfo() {
        return "member/myinfo";
    }

    //어드민 페이지
    @GetMapping("/admin")
    public String dispAdmin() {
        return "member/admin";
    }


}
