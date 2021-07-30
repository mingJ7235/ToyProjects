package com.kakao.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DataDto {

    private String user_name;
    private String user_email;
    private String map_content;
    private String sender;
    private String sender_name;
    private String template_code;

    @Builder
    public DataDto (KakaoMemberDto memberDto, KakaoTemplateDto templateDto) {
        this.user_name = memberDto.getUser_name();
        this.user_email = memberDto.getUser_email();
        this.map_content = templateDto.getMap_content();
        this.template_code = templateDto.getTemplate_code();
    }


}
