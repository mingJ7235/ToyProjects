package com.joshua.kakao.api.member.controller;

import com.joshua.kakao.api.member.service.KakaoMemberService;
import com.joshua.kakao.api.template.dto.KakaoMemberDto;
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
