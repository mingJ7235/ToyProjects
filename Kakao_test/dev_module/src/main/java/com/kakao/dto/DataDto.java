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
    private String content;
    private String sender;
    private String sender_name;
    private String template_code;

    @Builder
    public DataDto (KakaoMemberDto memberDto, String content, String template_code) {
        this.user_name = memberDto.getUserName();
        this.user_email = memberDto.getUserEmail();
        this.content = content;
        this.template_code = template_code;
    }


}
