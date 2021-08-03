package com.core.notification.kakao.provider;

import com.core.notification.NotificationProvider;
import com.core.notification.kakao.config.TasonKakaoProperties;
import com.core.notification.pretence.TasonFeignClient;
import com.core.notification.provider.MessageMapper;
import com.core.template.dto.MessageDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@Service ("KakaoNotiProvider")
@RequiredArgsConstructor
public class KakaoNotiProvider implements NotificationProvider {

    private final MessageMapper messageMapper;

    private final TasonKakaoProperties props;

    private final TasonFeignClient tason;

    @Override
    public void sendMessage (String templateCode, Map<String, String> criteria) {
        List<MessageDto> data = new ArrayList<>();

        data.add(MessageDto.builder()
                .map_content(messageMapper.contentMapper(templateCode, criteria))
                .template_code(templateCode)
                .build());

        tason.sendKakao(
                props.getTasId(),
                props.getSendType(),
                props.getAuthKey(),
                data
        );

    }

//    @Override
//    public boolean sendMessage(MessageDto messageDto) {
//        // Kakao API 호출 코드
//        // FeignClient
//
//        tason.sendKakao();
//
//        return false;
//    }


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
