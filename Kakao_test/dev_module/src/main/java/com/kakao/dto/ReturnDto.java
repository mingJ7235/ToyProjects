package com.kakao.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class ReturnDto {

    private String tas_id;
    private String send_type;
    private String auth_key;
    private List<DataDto> data;

}
