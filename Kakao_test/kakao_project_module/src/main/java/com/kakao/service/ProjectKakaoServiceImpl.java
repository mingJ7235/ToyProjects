package com.kakao.service;

import com.kakao.dto.KakaoTemplateDto;
import com.kakao.dto.ReturnDto;
import com.kakao.manager.KakaoSendManager;
import com.kakao.manager.KakaoTemplateManager;
import com.kakao.model.KakaoTemplate;
import com.kakao.service.contract.ProjectKakaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ProjectKakaoServiceImpl implements ProjectKakaoService {

    private final KakaoSendManager kakaoSendManager;
    private final KakaoTemplateManager kakaoTemplateManager;

    @Override
    public ReturnDto sendKakaoMessage(Long memberId, String templateCode) {
        ReturnDto messageResult = kakaoSendManager.sendMessage(memberId, templateCode);
        return messageResult;
    }

    @Override
    public Long saveTemplate(KakaoTemplateDto templateDto) {
        return kakaoTemplateManager.saveTemplate(templateDto);
    }

    @Override
    public KakaoTemplate getTemplate(Long templateId) {
        return kakaoTemplateManager.getTemplate(templateId);
    }

    @Override
    public List<KakaoTemplate> getListTemplate() {
        return kakaoTemplateManager.getListTemplate();
    }

    @Override
    public Long updateTemplate(Long templateId, KakaoTemplateDto templateDto) {
        return kakaoTemplateManager.updateTemplate(templateId, templateDto);
    }

    @Override
    public void deleteTemplate(Long templateID) {
        kakaoTemplateManager.deleteTemplate(templateID);
    }
}
