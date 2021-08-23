package com.joshua.kakao.api.service;

import com.joshua.kakao.api.dto.ReturnDto;
import com.joshua.kakao.api.service.contract.ProjectKakaoService;
import com.joshua.kakao.api.template.dto.KakaoPageDto;
import com.joshua.kakao.api.template.dto.KakaoTemplateDto;
import com.joshua.kakao.api.template.dto.SearchCriteriaDto;
import com.joshua.kakao.api.template.exception.DuplicateException;
import com.joshua.kakao.api.template.manager.KakaoTemplateManager;
import com.joshua.kakao.api.template.model.KakaoTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ProjectKakaoServiceImpl implements ProjectKakaoService {

    private final KakaoTemplateManager kakaoTemplateManager;

    @Override
    public ReturnDto sendKakaoMessage(Long memberId, String templateCode) {

//        String auth_key = "";
//        String sender = "";
//        String sender_name = "";
//
//        Map<String, String> criteria = kakaoCriteriaMaker.makeCriteria(memberId);
//
//        //DataDTO 조립
//        KakaoMember kakaoMember = memberRepository.findById(memberId).orElseThrow(IllegalArgumentException::new);
//        KakaoMemberDto memberDto = new KakaoMemberDto(kakaoMember);
//
//        MessageDto messageDto = kakaoSendManager.sendMessage(templateCode, criteria);
//
//        messageDto.setUser_name(memberDto.getUserName());
//        messageDto.setUser_email(memberDto.getUserEmail());
//        messageDto.setSender(sender);
//        messageDto.setSender_name(sender_name);
//
//        List<MessageDto> messageDtoList = new ArrayList<>();
//        messageDtoList.add(messageDto);
//
//        //ReturnDTO 조립 후 리턴
//        return ReturnDto.builder()
//                .tas_id("support@spiderkim.com")
//                .send_type("KA")
//                .auth_key(auth_key)
//                .data(messageDtoList)
//                .build();
        return null;
    }

    @Override
    public KakaoTemplateDto saveTemplate(KakaoTemplateDto templateDto) throws DuplicateException {
        return kakaoTemplateManager.saveTemplate(templateDto);
    }

    @Override
    public KakaoTemplate getTemplate(Long templateId) {
        return kakaoTemplateManager.getTemplate(templateId);
    }

    @Override
    public List<KakaoTemplateDto> getListTemplate() {
        return kakaoTemplateManager.getListTemplate();
    }

    @Override
    public KakaoTemplateDto updateTemplate(String code, KakaoTemplateDto templateDto) throws DuplicateException {
        return kakaoTemplateManager.updateTemplate(code, templateDto);
    }

    @Override
    public int deleteTemplate(String code) {
        return kakaoTemplateManager.deleteTemplate(code);
    }

    @Override
    public KakaoPageDto<KakaoTemplateDto> searchTemplate(SearchCriteriaDto criteria, Pageable pageable) {
        return kakaoTemplateManager.searchTemplate(criteria, pageable);
    }
}
