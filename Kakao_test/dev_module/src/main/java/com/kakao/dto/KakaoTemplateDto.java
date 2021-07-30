package com.kakao.dto;

import com.kakao.model.KakaoTemplate;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class KakaoTemplateDto {

    private String map_content;
    private String template_code;

    public KakaoTemplateDto(KakaoTemplate entity) {
        this.map_content = entity.getContent();
        this.template_code = entity.getTemplateCode();
    }

    public KakaoTemplate toEntity () {
        return  KakaoTemplate.builder()
                .content(map_content)
                .templateCode(template_code)
                .build();
    }


}
