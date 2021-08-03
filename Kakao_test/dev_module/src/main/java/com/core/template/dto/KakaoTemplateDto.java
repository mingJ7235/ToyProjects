package com.core.template.dto;

import com.core.template.model.KakaoTemplate;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class KakaoTemplateDto {

    private String content;
    private String templateCode;

    public KakaoTemplateDto(KakaoTemplate entity) {
        this.content = entity.getContent();
        this.templateCode = entity.getTemplateCode();
    }

    public KakaoTemplate toEntity () {
        return  KakaoTemplate.builder()
                .content(content)
                .templateCode(templateCode)
                .build();
    }


}
