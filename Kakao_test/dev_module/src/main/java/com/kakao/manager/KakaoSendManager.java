package com.kakao.manager;

import com.kakao.dto.KakaoMemberDto;
import com.kakao.dto.KakaoTemplateDto;
import com.kakao.model.KakaoMember;
import com.kakao.model.KakaoTemplate;
import com.kakao.dto.DataDto;
import com.kakao.dto.ReturnDto;
import com.kakao.provider.DataProvider;
import com.kakao.provider.ExpiredNotification;
import com.kakao.provider.SucceedPaymentNotification;
import com.kakao.repository.KakaoMemberRepository;
import com.kakao.repository.KakaoTemplateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class KakaoSendManager {
    private final SucceedPaymentNotification succeedPaymentNotification;
    private final ExpiredNotification expiredNotification;

    public ReturnDto sendMessage (Long memberId, int templateId) {

        String auth_key = "";
        String sender = "";
        String sender_name = "";

        DataDto dataDto = null;

        //알림톡 별 분기 처리
        switch (templateId) {
            case 1 :
                dataDto = expiredNotification.getDataDto(memberId);
                break;
            case 2:
                dataDto = succeedPaymentNotification.getDataDto(memberId);
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
