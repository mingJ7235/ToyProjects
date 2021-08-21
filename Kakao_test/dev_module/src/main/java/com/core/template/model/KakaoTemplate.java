package com.core.template.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class KakaoTemplate extends BaseEntity{

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
