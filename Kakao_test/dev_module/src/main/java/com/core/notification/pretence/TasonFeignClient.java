package com.core.notification.pretence;

import com.core.notification.dto.ReturnDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient (name = "TasonFeignClient", primary = false, url = "${tason.kakao.host:https://api.tason.com}")
public interface TasonFeignClient {

    @PostMapping (value = "/tas-api/send")
    public void sendSMS (

    );

    @PostMapping (value = "/tas-api/kakaosend")
    public void sendKakao(
            ReturnDto returnDto
    );


}
