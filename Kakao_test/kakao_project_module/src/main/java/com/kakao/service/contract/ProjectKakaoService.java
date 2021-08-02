package com.kakao.service.contract;

import com.kakao.dto.KakaoTemplateDto;
import com.kakao.dto.ReturnDto;
import com.kakao.model.KakaoTemplate;

import java.util.List;

public interface ProjectKakaoService {

    //send message
    ReturnDto sendKakaoMessage (Long memberId, String templateCode);

    //manage templates

    Long saveTemplate (KakaoTemplateDto templateDto);

    KakaoTemplate getTemplate (Long templateId);

    List<KakaoTemplate> getListTemplate ();

    Long updateTemplate (Long templateId, KakaoTemplateDto templateDto);

    void deleteTemplate (Long templateID);



}
