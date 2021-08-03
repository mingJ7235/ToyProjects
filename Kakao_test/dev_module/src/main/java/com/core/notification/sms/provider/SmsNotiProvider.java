package com.core.notification.sms.provider;

import com.core.notification.NotificationProvider;
import com.core.notification.pretence.TasonFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class SmsNotiProvider implements NotificationProvider {

    private final TasonFeignClient tasonFeignClient;

    @Override
    public void sendMessage(String code, Map<String, String> criteria) {

    }
}
