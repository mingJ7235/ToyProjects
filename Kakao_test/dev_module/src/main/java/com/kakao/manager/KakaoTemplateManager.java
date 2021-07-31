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

    //템플릿들의 매개변수 관리는??

    //관리할 수 있는 api도 개발하면 좋을것같다.

    //specification 을 통해 검색기능 -> 관리자 입장에서 템플릿 관리를 위한 검색 기능

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
