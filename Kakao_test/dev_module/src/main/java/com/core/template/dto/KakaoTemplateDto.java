package com.core.template.dto;

import com.core.template.model.KakaoTemplate;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class KakaoTemplateDto {

    private String subject;
    private String content;
    private String templateCode;
    private LocalDateTime createdAt;

    public KakaoTemplateDto(KakaoTemplate entity) {
        this.subject = entity.getSubject();
        this.content = entity.getContent();
        this.templateCode = entity.getTemplateCode();
        this.createdAt = entity.getCreatedAt();
    }

    public KakaoTemplate toEntity () {
        return KakaoTemplate.builder()
                .subject(subject)
                .content(content)
                .templateCode(templateCode)
                .build();
    }


}
