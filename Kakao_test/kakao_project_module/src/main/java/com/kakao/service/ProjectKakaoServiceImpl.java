package com.kakao.service;

import com.kakao.manager.KakaoSendManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ProjectKakaoServiceImpl {

    private final KakaoSendManager kakaoSendManager;


}
