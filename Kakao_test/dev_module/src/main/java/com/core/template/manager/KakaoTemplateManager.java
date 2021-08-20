package com.core.template.manager;

import com.core.template.repository.TemplateSpecs;
import com.core.template.repository.KakaoTemplateRepository;
import com.core.template.model.KakaoTemplate;
import com.core.template.dto.KakaoTemplateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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


    public KakaoTemplate updateTemplate (String code, KakaoTemplateDto templateDto) {

        int check = kakaoTemplateRepository.checkDuplicateCode(code);
        KakaoTemplate kakaoTemplate = kakaoTemplateRepository.findByTemplateCode(code).orElseThrow(IllegalAccessError::new);


        if (!kakaoTemplate.getTemplateCode().equals(templateDto.getTemplateCode())) {
            if (check > 0) {
                //exception
            }
        }

        kakaoTemplate.setContent(templateDto.getContent());
        kakaoTemplate.setTemplateCode(templateDto.getTemplateCode());
        return kakaoTemplate;
    }

    public void deleteTemplate (Long templateId) {
        KakaoTemplate kakaoTemplate = findTemplate(templateId);
        kakaoTemplateRepository.delete(kakaoTemplate);
    }

    //Specification 활용한 검색 (같은 것 검색)
    public List<KakaoTemplate> searchTemplateList (String content) {
        Specification<KakaoTemplate> spec = Specification.where(TemplateSpecs.equalContent(content));
        return kakaoTemplateRepository.findAll(spec);
    }

    //비슷한것 검색
    public List<KakaoTemplate> searchLikeTemplateList (String content) {
        Specification<KakaoTemplate> spec = Specification.where(TemplateSpecs.likeContent(content));
        return kakaoTemplateRepository.findAll(spec);
    }

    // 내용 + 기간
    public List<KakaoTemplate> searchLikeAndPeriodTemplateList (String content, LocalDateTime startDateTime, LocalDateTime endDateTime) {
        Specification<KakaoTemplate> spec = Specification.where(TemplateSpecs.likeContent(content));
        spec.and(TemplateSpecs.betweenCreatedDateTim(startDateTime, endDateTime));
        return kakaoTemplateRepository.findAll(spec);
    }

    private KakaoTemplate findTemplate (Long templateId) {
        return kakaoTemplateRepository.findById(templateId).orElseThrow(IllegalArgumentException::new);
    }


}
