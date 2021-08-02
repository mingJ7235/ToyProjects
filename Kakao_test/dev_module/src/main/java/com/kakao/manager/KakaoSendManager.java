package com.kakao.manager;

import com.kakao.dto.DataDto;
import com.kakao.dto.ReturnDto;
import com.kakao.provider.ExpiredNotification;
import com.kakao.provider.PaymentSucceedNotification;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class KakaoSendManager {
    private final PaymentSucceedNotification paymentSucceedNotification;
    private final ExpiredNotification expiredNotification;

    public ReturnDto sendMessage (Long memberId, String templateCode) {

        String auth_key = "";
        String sender = "";
        String sender_name = "";

        DataDto dataDto = null;

        //알림톡 별 분기 처리
        switch (templateCode) {
            case "code1" :
                dataDto = expiredNotification.getDataDto(memberId, templateCode);
                break;
            case "code2" :
                dataDto = paymentSucceedNotification.getDataDto(memberId, templateCode);
                break;
            default:
                throw new RuntimeException("알맞는 템플릿이 아닙니다.");
        }

        dataDto.setSender(sender);
        dataDto.setSender_name(sender_name);

        List<DataDto> dataDtoList = new ArrayList<>();
        dataDtoList.add(dataDto);

        ReturnDto returnDto = ReturnDto.builder()
                .tas_id("support@spiderkim.com")
                .send_type("KA")
                .auth_key(auth_key)
                .data(dataDtoList)
                .build();
        return returnDto;
    }
}
