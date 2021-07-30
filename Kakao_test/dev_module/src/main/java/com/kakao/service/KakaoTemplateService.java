package com.kakao.service;

import com.kakao.domain.KakaoTemplates;
import com.kakao.dto.KakaoTemplateDto;
import com.kakao.repository.KakaoTemplateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KakaoTemplateService {

    private final KakaoTemplateRepository kakaoTemplateRepository;

    public Long saveMessage (KakaoTemplateDto messageDto) {
        KakaoTemplates kakaoTemplates = messageDto.toEntity();
        Long savedMessageId = kakaoTemplateRepository.save(kakaoTemplates).getId();
        return savedMessageId;
    }
}
