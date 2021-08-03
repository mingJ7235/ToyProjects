package com.kakao.provider;

import com.kakao.model.KakaoMember;
import com.kakao.repository.KakaoMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class KakaoCriteriaMaker {

    private final KakaoMemberRepository memberRepository;

    public Map<String, String> makeCriteria (Long memberId) {
        Map<String, String> criteria = new HashMap<>();

        KakaoMember member = memberRepository.findById(memberId).orElseThrow(IllegalArgumentException::new);

        //tas on 변수들
        criteria.put("고객이름", member.getUserName());
        criteria.put("고객번호", member.getUserEmail());

        return criteria;
    }
}
