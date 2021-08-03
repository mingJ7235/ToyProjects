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
    public DataDto (String map_content, String template_code) {
        this.map_content = map_content;
        this.template_code = template_code;
    }


}
