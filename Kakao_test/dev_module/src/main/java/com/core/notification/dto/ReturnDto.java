package com.core.notification.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ReturnDto {

    private String tas_id;
    private String send_type;
    private String auth_key;
    private List<MessageDto> data;

    @Builder
    public ReturnDto(String tas_id, String send_type, String auth_key, List<MessageDto> data) {
        this.tas_id = tas_id;
        this.send_type = send_type;
        this.auth_key = auth_key;
        this.data = data;
    }

    public void addData(MessageDto message) {
        if(data == null) data = new ArrayList<>();
        data.add(message);
    }

    public void addData(MessageDto... message) {
        if(data == null) data = new ArrayList<>();
        data.addAll(Arrays.asList(message));
    }

    public void addData (List<MessageDto> messages) {
        if (data == null) data = new ArrayList<>();
        data.addAll(messages);
    }


}
