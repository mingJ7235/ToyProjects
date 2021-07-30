package com.kakao.manager;

import com.kakao.domain.KakaoTemplates;
import com.kakao.dto.KakaoTemplateDto;
import com.kakao.repository.KakaoTemplateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KakaoTemplateManager {

    private final KakaoTemplateRepository kakaoTemplateRepository;

    public Long saveTemplate(KakaoTemplateDto templateDto) {
        KakaoTemplates kakaoTemplates = templateDto.toEntity();
        Long savedTemplateId = kakaoTemplateRepository.save(kakaoTemplates).getId();
        return savedTemplateId;
    }
}
