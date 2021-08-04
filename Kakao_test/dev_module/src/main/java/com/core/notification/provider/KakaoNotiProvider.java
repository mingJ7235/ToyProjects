package com.core.notification.provider;

import com.core.notification.NotificationProvider;
import com.core.notification.SendNotiMessage;
import com.core.notification.constant.SendType;
import com.core.notification.config.TasonKakaoProperties;
import com.core.notification.pretence.TasonFeignClient;
import com.core.notification.dto.MessageMapper;
import com.core.notification.dto.MessageDto;
import com.core.notification.dto.ReturnDto;
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

        System.out.println(">>>>>>>tas_id : "+returnDto.getTas_id());
        System.out.println(">>>>>>>send_type : "+returnDto.getSend_type());
        System.out.println(">>>>>>>auth_key : "+returnDto.getAuth_key());
        System.out.println(">>>>>>>data-name : "+returnDto.getData().get(0).getUser_name());
        System.out.println(">>>>>>>data-num : "+returnDto.getData().get(0).getUser_email());
        System.out.println(">>>>>>>data-content : "+returnDto.getData().get(0).getMap_content());
        System.out.println(">>>>>>>data-sender : "+returnDto.getData().get(0).getSender_name());
        System.out.println(">>>>>>>data-senderNum : "+returnDto.getData().get(0).getSender());
        System.out.println(">>>>>>>data-templateCode : "+returnDto.getData().get(0).getTemplate_code());

        tason.sendKakao(returnDto);

    }



}
