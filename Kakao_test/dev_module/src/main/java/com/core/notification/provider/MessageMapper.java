package com.core.notification.provider;

import com.core.template.model.KakaoTemplate;
import com.core.template.repository.KakaoTemplateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

@Service
@RequiredArgsConstructor
public class MessageMapper {

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
