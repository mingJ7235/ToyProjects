package com.kakao.provider;

import com.kakao.dto.DataDto;
import com.kakao.dto.KakaoMemberDto;
import com.kakao.dto.ReturnDto;
import com.kakao.model.KakaoMember;
import com.kakao.model.KakaoTemplate;
import com.kakao.repository.KakaoMemberRepository;
import com.kakao.repository.KakaoTemplateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

@Service
@RequiredArgsConstructor
public class DataMapper {

    private final KakaoTemplateRepository templateRepository;

    public String contentMapper (String templateCode, Map<String, String> criteria) {
        //템플릿 불러오기
        KakaoTemplate kakaoTemplate = templateRepository.findByTemplateCode(templateCode)
                .orElseThrow(IllegalArgumentException::new);

        AtomicReference<String> content = new AtomicReference<>(kakaoTemplate.getContent());
        criteria.forEach((String key, String value) -> {
            content.set(content.get().replaceAll("#\\{" + key + "}", value));
        });
        return content.get();
    }

}

//class NotificationSender() {
//    sendMessge(String templateCode, Map<String, String> criteria) {
//        ReturnDto.builder()
//                .auth_key()
//                .
//                .build();
//    }
//}
