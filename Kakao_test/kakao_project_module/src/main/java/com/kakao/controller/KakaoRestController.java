package com.kakao.controller;

import com.kakao.dto.ReturnDto;
import com.kakao.service.contract.ProjectKakaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api.tason.com/tas-api/")
public class KakaoRestController {

    private final ProjectKakaoService service;

    @PostMapping("/kakaosend/")
    public ReturnDto sendMessage (@ModelAttribute @Valid Long memberId, Long templateId) {
        return service.sendKakaoMessage(memberId, templateId);
    }
}
