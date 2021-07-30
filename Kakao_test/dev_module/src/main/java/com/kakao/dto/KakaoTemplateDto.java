package com.kakao.dto;

import com.kakao.domain.KakaoTemplates;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class KakaoTemplateDto {

    private String map_content;
    private String template_code;

    public KakaoTemplateDto(KakaoTemplates entity) {
        this.map_content = entity.getContent();
        this.template_code = entity.getTemplateCode();
    }

    public KakaoTemplates toEntity () {
        return  KakaoTemplates.builder()
                .content(map_content)
                .templateCode(template_code)
                .build();
    }


}
