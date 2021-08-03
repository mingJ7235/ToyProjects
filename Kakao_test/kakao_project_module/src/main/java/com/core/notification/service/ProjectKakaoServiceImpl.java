package com.core.notification.service;

import com.core.template.dto.KakaoMemberDto;
import com.core.template.dto.MessageDto;
import com.core.template.dto.KakaoTemplateDto;
import com.core.template.dto.ReturnDto;
import com.core.notification.kakao.provider.KakaoNotiProvider;
import com.core.notification.manager.KakaoTemplateManager;
import com.core.template.model.KakaoMember;
import com.core.template.model.KakaoTemplate;
import com.core.template.repository.KakaoMemberRepository;
import com.core.notification.service.contract.ProjectKakaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Transactional
public class ProjectKakaoServiceImpl implements ProjectKakaoService {

    private final KakaoMemberRepository memberRepository;
    private final KakaoNotiProvider kakaoSendManager;
    private final KakaoTemplateManager kakaoTemplateManager;
    private final KakaoCriteriaMaker kakaoCriteriaMaker;

    @Override
    public ReturnDto sendKakaoMessage(Long memberId, String templateCode) {

        String auth_key = "";
        String sender = "";
        String sender_name = "";

        Map<String, String> criteria = kakaoCriteriaMaker.makeCriteria(memberId);

        //DataDTO 조립
        KakaoMember kakaoMember = memberRepository.findById(memberId).orElseThrow(IllegalArgumentException::new);
        KakaoMemberDto memberDto = new KakaoMemberDto(kakaoMember);

        MessageDto messageDto = kakaoSendManager.sendMessage(templateCode, criteria);

        messageDto.setUser_name(memberDto.getUserName());
        messageDto.setUser_email(memberDto.getUserEmail());
        messageDto.setSender(sender);
        messageDto.setSender_name(sender_name);

        List<MessageDto> messageDtoList = new ArrayList<>();
        messageDtoList.add(messageDto);

        //ReturnDTO 조립 후 리턴
        return ReturnDto.builder()
                .tas_id("support@spiderkim.com")
                .send_type("KA")
                .auth_key(auth_key)
                .data(messageDtoList)
                .build();
    }

    @Override
    public Long saveTemplate(KakaoTemplateDto templateDto) {
        return kakaoTemplateManager.saveTemplate(templateDto);
    }

    @Override
    public KakaoTemplate getTemplate(Long templateId) {
        return kakaoTemplateManager.getTemplate(templateId);
    }

    @Override
    public List<KakaoTemplate> getListTemplate() {
        return kakaoTemplateManager.getListTemplate();
    }

    @Override
    public Long updateTemplate(Long templateId, KakaoTemplateDto templateDto) {
        return kakaoTemplateManager.updateTemplate(templateId, templateDto);
    }

    @Override
    public void deleteTemplate(Long templateID) {
        kakaoTemplateManager.deleteTemplate(templateID);
    }
}
