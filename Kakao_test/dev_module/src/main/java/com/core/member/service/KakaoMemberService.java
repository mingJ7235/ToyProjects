package com.core.member.service;

import com.core.template.dto.KakaoMemberDto;
import com.core.template.model.KakaoMember;
import com.core.template.repository.KakaoMemberRepository;
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
