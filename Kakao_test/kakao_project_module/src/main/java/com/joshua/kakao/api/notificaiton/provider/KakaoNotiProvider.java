package com.joshua.kakao.api.notificaiton.provider;

import com.joshua.kakao.api.dto.ReturnDto;
import com.joshua.kakao.api.notificaiton.NotificationProvider;
import com.joshua.kakao.api.notificaiton.SendNotiMessage;
import com.joshua.kakao.api.notificaiton.config.TasonKakaoProperties;
import com.joshua.kakao.api.notificaiton.constant.SendType;
import com.joshua.kakao.api.notificaiton.dto.MessageDto;
import com.joshua.kakao.api.notificaiton.dto.MessageMapper;
import com.joshua.kakao.api.notificaiton.pretence.TasonFeignClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service("KakaoNotiProvider")
//@ConditionalOnExpression("${tason.kakao.enable:false}")
@RequiredArgsConstructor
public class KakaoNotiProvider implements NotificationProvider {

    private final MessageMapper messageMapper;

    private final TasonKakaoProperties props;

    private final TasonFeignClient tason;

    @Override
    public void sendMessage(SendNotiMessage message) {
        sendMessage(message.getUserName(),
                    message.getUserEmail(),
                    message.getTemplateCode(),
                    message.getCriteria()
        );
    }

    @Override
    public void sendMessage (String userName, String userEmail, String templateCode, Map<String, String> criteria) {

        MessageDto messageDto = MessageDto.builder()
                .user_name(userName)
                .user_email(userEmail)
                .map_content(messageMapper.contentMapper(templateCode, criteria))
                .sender(0+props.getSender())
                .sender_name(props.getSenderName())
                .template_code(templateCode)
                .build();


        ReturnDto returnDto = ReturnDto.builder()
                .tas_id(props.getTasId())
                .auth_key(props.getAuthKey())
                .send_type(SendType.KA.toString())
                .build();

        returnDto.addData(messageDto);


        tason.sendKakao(returnDto);

    }



}
