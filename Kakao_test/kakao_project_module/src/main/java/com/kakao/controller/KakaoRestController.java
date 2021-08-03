package com.kakao.controller;

import com.kakao.dto.ReturnDto;
import com.kakao.service.contract.ProjectKakaoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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
