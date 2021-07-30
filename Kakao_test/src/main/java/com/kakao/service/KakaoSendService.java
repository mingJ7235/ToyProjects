package com.kakao.service;

import com.kakao.domain.KakaoMember;
import com.kakao.domain.KakaoMessage;
import com.kakao.dto.DataDto;
import com.kakao.dto.ReturnDto;
import com.kakao.repository.KakaoMemberRepository;
import com.kakao.repository.KakaoMessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class KakaoSendService {
    private final KakaoMemberRepository kakaoMemberRepository;
    private final KakaoMessageRepository kakaoMessageRepository;

    public ReturnDto sendMessage (Long memberId, Long messageId) {

        String auth_key = "";

        KakaoMember member = kakaoMemberRepository.findById(memberId)
                .orElseThrow(IllegalArgumentException::new);
        KakaoMessage message = kakaoMessageRepository.findById(messageId)
                .orElseThrow(IllegalArgumentException::new);

        DataDto dataDto = DataDto.builder()
                .user_name(member.getUserName())
                .user_email(member.getUserEmail())
                .map_content(message.getMapContent())
                .sender(message.getSender())
                .sender_name(message.getSenderName())
                .template_code(message.getTemplateCode())
                .build();

        List<DataDto> dataDtoList = new ArrayList<>();
        dataDtoList.add(dataDto);

        ReturnDto returnDto = ReturnDto.builder()
                .tas_id("support@spiderkim.com")
                .send_type("KA")
                .auth_key("auth_key")
                .data(dataDtoList)
                .build();
        return returnDto;
    }
}
