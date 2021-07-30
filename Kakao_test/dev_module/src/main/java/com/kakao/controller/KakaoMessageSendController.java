package com.kakao.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping ("/api.tason.com/tas-api/")
public class KakaoMessageSendController {

    @PostMapping ("/kakaosend/")
    public void sendMessage (Long memberId, Long messageId) {

    }

}
