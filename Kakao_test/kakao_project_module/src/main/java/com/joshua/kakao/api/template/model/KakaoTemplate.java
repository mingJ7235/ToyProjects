package com.joshua.kakao.api.template.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class KakaoTemplate extends BaseEntity {

    private String subject;

    private String content;

    private String templateCode;

    @Builder
    public KakaoTemplate(String subject, String content, String templateCode) {
        this.subject = subject;
        this.content = content;
        this.templateCode = templateCode;
    }
}
