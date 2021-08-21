package com.core.notification.service.contract;

import com.core.notification.dto.ReturnDto;
import com.core.template.exception.DuplicateException;
import com.core.template.model.KakaoTemplate;
import com.core.template.dto.KakaoTemplateDto;

import java.util.List;

public interface ProjectKakaoService {

    //send message
    ReturnDto sendKakaoMessage (Long memberId, String templateCode);

    //manage templates

    Long saveTemplate (KakaoTemplateDto templateDto);

    KakaoTemplate getTemplate (Long templateId);

    List<KakaoTemplate> getListTemplate ();

    KakaoTemplateDto updateTemplate (String code, KakaoTemplateDto templateDto) throws DuplicateException;

    void deleteTemplate (Long templateID);



}
