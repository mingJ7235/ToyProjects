package com.kakao.manager;

import com.kakao.dto.ReturnDto;
import com.kakao.model.KakaoTemplate;
import com.kakao.dto.KakaoTemplateDto;
import com.kakao.repository.KakaoTemplateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class KakaoTemplateManager {

    private final KakaoTemplateRepository kakaoTemplateRepository;

    public Long saveTemplate(KakaoTemplateDto templateDto) {
        KakaoTemplate kakaoTemplate = templateDto.toEntity();
        Long savedTemplateId = kakaoTemplateRepository.save(kakaoTemplate).getId();
        return savedTemplateId;
    }

    public KakaoTemplate getTemplate (Long templateId) {
        return findTemplate(templateId);
    }

    public List<KakaoTemplate> getListTemplate () {
        List<KakaoTemplate> templateList = kakaoTemplateRepository.findAll();
        return templateList;
    }


    public Long updateTemplate (Long templateId, KakaoTemplateDto templateDto) {
        KakaoTemplate kakaoTemplate = findTemplate(templateId);
        kakaoTemplate.setContent(templateDto.getMap_content());
        kakaoTemplate.setTemplateCode(templateDto.getTemplate_code());
        return templateId;
    }

    public void deleteTemplate (Long templateId) {
        KakaoTemplate kakaoTemplate = findTemplate(templateId);
        kakaoTemplateRepository.delete(kakaoTemplate);
    }

    private KakaoTemplate findTemplate (Long templateId) {
        return kakaoTemplateRepository.findById(templateId).orElseThrow(IllegalArgumentException::new);
    }
}
