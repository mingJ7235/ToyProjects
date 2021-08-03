package com.core.notification.pretence;

import com.core.template.dto.MessageDto;
import com.core.template.dto.ReturnDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient (name = "TasonFeignClient", primary = false, url = "${tason.kakao.host:https://api.tason.com}")
public interface TasonFeignClient {

    @PostMapping (value = "/tas-api/send")
    public void sendSMS (

    );

    @PostMapping (value = "/tas-api/kakaosend")
    public void sendKakao(
            //Feign 의 파라미터는 한개만 들어갈 수 있다.
            ReturnDto returnDto
    );


}
