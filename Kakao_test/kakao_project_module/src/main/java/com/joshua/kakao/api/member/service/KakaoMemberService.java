package com.joshua.kakao.api.member.service;

import com.joshua.kakao.api.template.dto.KakaoMemberDto;
import com.joshua.kakao.api.template.model.KakaoMember;
import com.joshua.kakao.api.template.repository.KakaoMemberRepository;
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
