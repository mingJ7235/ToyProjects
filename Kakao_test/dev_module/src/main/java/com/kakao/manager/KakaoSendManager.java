package com.kakao.manager;

import com.kakao.dto.KakaoMemberDto;
import com.kakao.dto.KakaoTemplateDto;
import com.kakao.model.KakaoMember;
import com.kakao.model.KakaoTemplate;
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
        String sender = "";
        String sender_name = "";

        KakaoMember member = kakaoMemberRepository.findById(memberId)
                .orElseThrow(IllegalArgumentException::new);
        KakaoTemplate template = kakaoTemplateRepository.findById(templateId)
                .orElseThrow(IllegalArgumentException::new);

        DataDto dataDto = DataDto.builder()
                .memberDto(new KakaoMemberDto(member))
                .templateDto(new KakaoTemplateDto(template))
                .build();

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
