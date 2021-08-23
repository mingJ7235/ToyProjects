package com.joshua.kakao.api.controller;

import com.joshua.kakao.api.dto.ReturnDto;
import com.joshua.kakao.api.service.contract.ProjectKakaoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/kakao/test")
@Slf4j
public class KakaoRestController {

    private final ProjectKakaoService service;

    @PostMapping ("/kakaosend")
    public ReturnDto sendMessage (Long memberId, String templateCode) {
        return service.sendKakaoMessage(memberId, templateCode);
    }


}
