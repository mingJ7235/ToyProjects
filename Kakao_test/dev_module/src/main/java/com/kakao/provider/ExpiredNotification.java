package com.kakao.provider;

import com.kakao.dto.DataDto;
import com.kakao.dto.KakaoMemberDto;
import com.kakao.model.KakaoMember;
import com.kakao.repository.KakaoMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExpiredNotification implements DataProvider{

    private final KakaoMemberRepository memberRepository;

    @Override
    public DataDto getDataDto(Long memberId) {

        KakaoMember kakaoMember = memberRepository.findById(memberId)
                .orElseThrow(IllegalArgumentException::new);
        KakaoMemberDto memberDto = new KakaoMemberDto(kakaoMember);

        String content = "[스파이더킴] 안녕하세요. 회원님의 이용권 만료 3일 전입니다.\n" +
                "\n" +
                "▶이용권 : " + memberDto.getUserName() +"\n" +
                "▶기간옵션 : #{고객정보2}\n" +
                "▶서비스 이용기간 : #{고객정보3}\n" +
                "\n" +
                "이용권 만료 시점에 베이직 요금제로 변경됩니다. 감사합니다.";

        String templateCode = "";

        DataDto dataDto = DataDto.builder()
                .memberDto(memberDto)
                .content(content)
                .template_code(templateCode)
                .build();

        return dataDto;

    }
}
