package com.kakao.controller;

import com.kakao.dto.ReturnDto;
import com.kakao.service.contract.ProjectKakaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/kakao/test")
public class KakaoRestController {

    private final ProjectKakaoService service;

    @PostMapping ("/kakaosend")
    public ReturnDto sendMessage (Long memberId, String templateCode, Map<String, String> criteria) {
        return service.sendKakaoMessage(memberId, templateCode, criteria);
    }

}
