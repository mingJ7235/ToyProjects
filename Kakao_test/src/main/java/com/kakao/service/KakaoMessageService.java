package com.kakao.service;

import com.kakao.domain.KakaoMessage;
import com.kakao.dto.KakaoMessageDto;
import com.kakao.repository.KakaoMessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KakaoMessageService {

    private final KakaoMessageRepository kakaoMessageRepository;

    public Long saveMessage (KakaoMessageDto messageDto) {
        KakaoMessage kakaoMessage = messageDto.toEntity();
        Long savedMessageId = kakaoMessageRepository.save(kakaoMessage).getId();
        return savedMessageId;
    }
}
