package com.kakao.service;

import com.kakao.domain.KakaoMember;
import com.kakao.dto.KakaoMemberDto;
import com.kakao.repository.KakaoMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KakaoMemberService {

    private final KakaoMemberRepository kakaoMemberRepository;

    public Long saveMember (KakaoMemberDto memberDto) {
        KakaoMember member = memberDto.toEntity();
        Long savedMemberId = kakaoMemberRepository.save(member).getId();
        return  savedMemberId;
    }
}
