package com.kakao.controller;

import com.kakao.dto.KakaoMemberDto;
import com.kakao.service.KakaoMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class KakaoMemberController {

    private final KakaoMemberService kakaoMemberService;

    @PostMapping ("kakao/test/members")
    public Long saveMember (@ModelAttribute @Valid KakaoMemberDto kakaoMemberDto) {
        Long saveMember = kakaoMemberService.saveMember(kakaoMemberDto);
        return saveMember;
    }
}
