package com.joshua.kakao.api.service.contract;

import com.joshua.kakao.api.dto.ReturnDto;
import com.joshua.kakao.api.template.dto.KakaoPageDto;
import com.joshua.kakao.api.template.dto.KakaoTemplateDto;
import com.joshua.kakao.api.template.dto.SearchCriteriaDto;
import com.joshua.kakao.api.template.exception.DuplicateException;
import com.joshua.kakao.api.template.model.KakaoTemplate;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProjectKakaoService {

    ReturnDto sendKakaoMessage (Long memberId, String templateCode);

    KakaoTemplateDto saveTemplate (KakaoTemplateDto templateDto) throws DuplicateException;

    KakaoTemplate getTemplate (Long templateId);

    List<KakaoTemplateDto> getListTemplate ();

    KakaoTemplateDto updateTemplate (String code, KakaoTemplateDto templateDto) throws DuplicateException;

    int deleteTemplate (String code);

    KakaoPageDto<KakaoTemplateDto> searchTemplate (SearchCriteriaDto critria, Pageable pageable);



}
