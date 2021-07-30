package com.kakao.manager;

import com.kakao.domain.KakaoMember;
import com.kakao.domain.KakaoTemplates;
import com.kakao.dto.DataDto;
import com.kakao.dto.ReturnDto;
import com.kakao.repository.KakaoMemberRepository;
import com.kakao.repository.KakaoTemplateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class KakaoSendManager {
    private final KakaoMemberRepository kakaoMemberRepository;
    private final KakaoTemplateRepository kakaoTemplateRepository;

    public ReturnDto sendMessage (Long memberId, Long templateId) {

        String auth_key = "";

        KakaoMember member = kakaoMemberRepository.findById(memberId)
                .orElseThrow(IllegalArgumentException::new);
        KakaoTemplates message = kakaoTemplateRepository.findById(templateId)
                .orElseThrow(IllegalArgumentException::new);

        DataDto dataDto = DataDto.builder()
                .user_name(member.getUserName())
                .user_email(member.getUserEmail())
                .map_content(message.getContent())
                .sender(message.getSender())
                .sender_name(message.getSenderName())
                .template_code(message.getTemplateCode())
                .build();

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
