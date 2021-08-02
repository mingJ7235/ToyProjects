package com.kakao.provider;

import com.kakao.dto.DataDto;
import com.kakao.dto.KakaoMemberDto;
import com.kakao.model.KakaoMember;
import com.kakao.repository.KakaoMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentSucceedNotification implements DataProvider{

    private final KakaoMemberRepository memberRepository;

    @Override
    public DataDto getDataDto(Long memberId, String templateCode) {

        KakaoMember kakaoMember = memberRepository.findById(memberId).orElseThrow(IllegalArgumentException::new);
        KakaoMemberDto memberDto = new KakaoMemberDto(kakaoMember);

        String content = "[스파이더킴] 결제완료 안내\n" +
                "안녕하세요. 정상적으로 결제가 완료되었습니다.\n" +
                "\n" +
                "▶이용권 : " + memberDto.getUserName() + "\n" +
                "▶기간옵션 : #{고객정보1}\n" +
                "▶서비스 이용기간 : #{고객정보2}\n" +
                "▶결제 금액 : #{고객정보3}\n" +
                "\n" +
                "감사합니다.\n" +
                "\n";

        DataDto dataDto = DataDto.builder()
                .memberDto(memberDto)
                .content(content)
                .template_code(templateCode)
                .build();

        return dataDto;
    }
}
