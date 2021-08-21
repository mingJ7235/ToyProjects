package com.core.template.manager;

import com.core.template.dto.KakaoPageDto;
import com.core.template.dto.KakaoTemplateDto;
import com.core.template.dto.SearchCriteriaDto;
import com.core.template.exception.DuplicateException;
import com.core.template.model.KakaoTemplate;
import com.core.template.repository.KakaoTemplateRepository;
import com.core.template.repository.TemplateSpecs;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class KakaoTemplateManager {


    private final KakaoTemplateRepository kakaoTemplateRepository;

    public KakaoTemplateDto saveTemplate(KakaoTemplateDto templateDto) throws DuplicateException {
        int checkDuplicateCode = kakaoTemplateRepository.checkDuplicateCode(templateDto.getTemplateCode());


        if (checkDuplicateCode > 0) {
            throw new DuplicateException();
        }

        KakaoTemplate kakaoTemplate = templateDto.toEntity();
        return new KakaoTemplateDto(kakaoTemplate);
    }

    public KakaoTemplate getTemplate (Long templateId) {
        return findTemplate(templateId);
    }

    public List<KakaoTemplateDto> getListTemplate () {
        return kakaoTemplateRepository.findAll().stream().map(KakaoTemplateDto::new).collect(Collectors.toList());
    }


    public KakaoTemplateDto updateTemplate (String code, KakaoTemplateDto templateDto) throws DuplicateException {
        int check = kakaoTemplateRepository.checkDuplicateCode(code);
        KakaoTemplate kakaoTemplate = kakaoTemplateRepository.findByTemplateCode(code).orElseThrow(IllegalAccessError::new);

        if (!kakaoTemplate.getTemplateCode().equals(templateDto.getTemplateCode())) {
            if (check > 0) {
                throw new DuplicateException();
            }
        }

        kakaoTemplate.setSubject(templateDto.getSubject());
        kakaoTemplate.setContent(templateDto.getContent());
        kakaoTemplate.setTemplateCode(templateDto.getTemplateCode());
        return new KakaoTemplateDto(kakaoTemplate);
    }

    public int deleteTemplate (String templateCode) {
        return kakaoTemplateRepository.deleteByTemplateCode(templateCode);
    }

    public KakaoPageDto<KakaoTemplateDto> searchTemplate (SearchCriteriaDto criteria, Pageable pageable) {
        Page<KakaoTemplateDto> kakaoPage = kakaoTemplateRepository.findAll(TemplateSpecs.search(criteria), pageable).map(KakaoTemplateDto::new);
        return new KakaoPageDto<>(kakaoPage);
    }

    private KakaoTemplate findTemplate (Long templateId) {
        return kakaoTemplateRepository.findById(templateId).orElseThrow(IllegalArgumentException::new);
    }


}
