package com.core.notification.kakao.provider;

import com.core.notification.NotificationProvider;
import com.core.notification.kakao.config.TasonKakaoProperties;
import com.core.notification.pretence.TasonFeignClient;
import com.core.notification.provider.MessageMapper;
import com.core.template.dto.MessageDto;
import com.core.template.dto.ReturnDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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
    public void sendMessage (String templateCode, Map<String, String> criteria) {
        List<MessageDto> data = new ArrayList<>();

        data.add(MessageDto.builder()
                .user_name(criteria.get("고객이름"))
                .user_email(criteria.get("고객번호"))
                .map_content(messageMapper.contentMapper(templateCode, criteria))
                .sender(0+props.getSender())
                .sender_name(props.getSenderName())
                .template_code(templateCode)
                .build());

        ReturnDto returnDto = ReturnDto.builder()
                .tas_id(props.getTasId())
                .auth_key(props.getAuthKey())
                .send_type(props.getSendType().get("send-kakao"))
                .data(data)
                .build();

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



//    private final PaymentSucceedNotification paymentSucceedNotification;
//    private final ExpiredNotification expiredNotification;
//
//    public ReturnDto sendMessage (Long memberId, String templateCode) {
//
//        String auth_key = "";
//        String sender = "";
//        String sender_name = "";
//
//        DataDto dataDto = null;
//
//        //알림톡 별 분기 처리
//        switch (templateCode) {
//            case "code1" :
//                dataDto = expiredNotification.getDataDto(memberId, templateCode);
//                break;
//            case "code2" :
//                dataDto = paymentSucceedNotification.getDataDto(memberId, templateCode);
//                break;
//            default:
//                throw new RuntimeException("알맞는 템플릿이 아닙니다.");
//        }
//
//        dataDto.setSender(sender);
//        dataDto.setSender_name(sender_name);
//
//        List<DataDto> dataDtoList = new ArrayList<>();
//        dataDtoList.add(dataDto);
//
//        ReturnDto returnDto = ReturnDto.builder()
//                .tas_id("support@spiderkim.com")
//                .send_type("KA")
//                .auth_key(auth_key)
//                .data(dataDtoList)
//                .build();
//        return returnDto;
//    }
}
