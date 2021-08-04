package com.core.notification.sms.provider;

import com.core.notification.NotificationProvider;
import com.core.notification.kakao.config.TasonKakaoProperties;
import com.core.notification.pretence.TasonFeignClient;
import com.core.notification.provider.MessageMapper;
import com.core.template.dto.MessageDto;
import lombok.RequiredArgsConstructor;

import java.util.Map;

//@Service
@RequiredArgsConstructor
public class SmsNotiProvider implements NotificationProvider {

    private final MessageMapper messageMapper;

    private final TasonKakaoProperties props;

    private final TasonFeignClient tasonFeignClient;

    @Override
    public void sendMessage(String code, Map<String, String> criteria) {
        MessageDto messageDto = MessageDto.builder()
                .user_name(criteria.get("고객이름"))
                .user_email(criteria.get("고객번호"))
                .map_content(messageMapper.contentMapper(code, criteria))
                .sender(0 + props.getSender())
                .sender_name(props.getSenderName())
                .build();

    }

}
