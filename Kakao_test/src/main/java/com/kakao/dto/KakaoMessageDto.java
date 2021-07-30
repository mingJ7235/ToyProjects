package com.kakao.dto;

import com.kakao.domain.KakaoMessage;
import jdk.nashorn.internal.runtime.regexp.joni.constants.internal.EncloseType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class KakaoMessageDto {

    private String map_content;
    private String sender;
    private String sender_name;
    private String template_code;

    public KakaoMessageDto (KakaoMessage entity) {
        this.map_content = entity.getMapContent();
        this.sender = entity.getSender();
        this.sender_name = entity.getSenderName();
        this.template_code = entity.getTemplateCode();
    }

    public KakaoMessage toEntity () {
        return  KakaoMessage.builder()
                .mapContent(map_content)
                .sender(sender)
                .senderName(sender_name)
                .templateCode(template_code)
                .build();
    }


}
