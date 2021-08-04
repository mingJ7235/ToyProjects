package com.core.template.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MessageDto {

    private String user_name;
    private String user_email;
    private String map_content;
    private String sender;
    private String sender_name;
    private String template_code;

    @Builder
    public MessageDto(String map_content, String sender, String sender_name, String template_code) {
        this.map_content = map_content;
        this.sender = sender;
        this.sender_name = sender_name;
        this.template_code = template_code;
    }


}
