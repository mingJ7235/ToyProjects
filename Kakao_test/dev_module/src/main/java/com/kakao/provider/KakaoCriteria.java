package com.kakao.provider;

import com.kakao.repository.KakaoMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class KakaoCriteria {

    private final KakaoMemberRepository memberRepository;

    public Map<String, String> makeCriteria (String key, String value) {

        Map<String, String> criteria = new HashMap<>();
        criteria.put(key, value);

        return criteria;
    }
}
