package com.kakao.manager;

import com.kakao.dto.DataDto;
import com.kakao.provider.CriteriaMaker;
import com.kakao.provider.DataMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class KakaoSendManager {

    private final DataMapper dataMapper;

    public DataDto sendMessage (String templateCode, Map<String, String> criteria) {

        String content = dataMapper.contentMapper(templateCode, criteria);

        return DataDto.builder()
                .content(content)
                .template_code(templateCode)
                .build();
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
