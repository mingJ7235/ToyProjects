package com.kakao.service.contract;

import com.kakao.dto.ReturnDto;

public interface ProjectKakaoService {

    ReturnDto sendKakaoMessage (Long memberId, Long templateId);
}
