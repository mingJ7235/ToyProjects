package com.core.notification.kakao.provider;

import com.core.notification.NotificationProvider;
import com.core.template.model.KakaoMember;
import com.core.template.model.KakaoTemplate;
import com.core.template.repository.KakaoMemberRepository;
import com.core.template.repository.KakaoTemplateRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
@Transactional
class KakaoNotiProviderTest {

    @Autowired
    @Qualifier("KakaoNotiProvider")
    NotificationProvider sendManager;

    @Autowired
    KakaoMemberRepository memberRepository;

    @Autowired
    KakaoTemplateRepository templateRepository;


    @Test
    @SuppressWarnings("serial")
    void KakaoSendTest() {
        //given
        KakaoMember member = new KakaoMember();
        KakaoTemplate template = new KakaoTemplate();

        member.setUserName("kim01");
        member.setUserEmail("029999");
        memberRepository.save(member);

        template.setContent("#{고객이름}님 안녕하세요 반갑습니다.");
        template.setTemplateCode("기간만료안내");
        templateRepository.save(template);

        Map<String, String> criteria = new HashMap<>();
        criteria.put("고객이름", memberRepository.findById(1L)
                .orElseThrow(IllegalArgumentException::new).getUserName());

        //when

        sendManager.sendMessage("기간만료안내", criteria);

        //then
    }

}