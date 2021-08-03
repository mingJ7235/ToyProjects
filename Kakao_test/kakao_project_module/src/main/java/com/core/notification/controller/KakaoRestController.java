package com.core.notification.controller;

import com.core.template.dto.ReturnDto;
import com.core.notification.service.contract.ProjectKakaoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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
