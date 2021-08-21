package com.core.notification.service.contract;

import com.core.notification.dto.ReturnDto;
import com.core.template.dto.KakaoPageDto;
import com.core.template.dto.SearchCriteriaDto;
import com.core.template.exception.DuplicateException;
import com.core.template.model.KakaoTemplate;
import com.core.template.dto.KakaoTemplateDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProjectKakaoService {

    //send message
    ReturnDto sendKakaoMessage (Long memberId, String templateCode);

    //manage templates

    KakaoTemplateDto saveTemplate (KakaoTemplateDto templateDto) throws DuplicateException;

    KakaoTemplate getTemplate (Long templateId);

    List<KakaoTemplateDto> getListTemplate ();

    KakaoTemplateDto updateTemplate (String code, KakaoTemplateDto templateDto) throws DuplicateException;

    int deleteTemplate (String code);

    KakaoPageDto<KakaoTemplateDto> searchTemplate (SearchCriteriaDto critria, Pageable pageable);



}
