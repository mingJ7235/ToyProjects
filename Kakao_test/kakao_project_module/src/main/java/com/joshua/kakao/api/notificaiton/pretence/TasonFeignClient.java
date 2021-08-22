package com.joshua.kakao.api.notificaiton.pretence;

import com.joshua.kakao.api.dto.ReturnDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

@Component
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
