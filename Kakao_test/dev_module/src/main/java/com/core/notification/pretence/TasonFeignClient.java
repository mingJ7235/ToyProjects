package com.core.notification.pretence;

import com.core.template.dto.MessageDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient (name = "TasonFeignClient", primary = false, url = "https://api.tason.com")
public interface TasonFeignClient {

    @PostMapping (value = "/tas-api/send")
    public void sendSMS (

    );

    @PostMapping (value = "/tas-api/kakaosend")
    public void sendKakao(
            String tas_id,
            String send_type,
            String auth_key,
            List<MessageDto> data
    );


}
