package com.kakao.service;

import com.kakao.dto.ReturnDto;
import com.kakao.manager.KakaoSendManager;
import com.kakao.manager.KakaoTemplateManager;
import com.kakao.service.contract.ProjectKakaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ProjectKakaoServiceImpl implements ProjectKakaoService {

    private final KakaoSendManager kakaoSendManager;
    private final KakaoTemplateManager kakaoTemplateManager;

    @Override
    public ReturnDto sendKakaoMessage(Long memberId, Long templateId) {
        ReturnDto messageResult = kakaoSendManager.sendMessage(memberId, templateId);
        return messageResult;
    }
}
