package com.core.notification.sms.provider;

import com.core.notification.NotificationProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class SmsNotiProvider implements NotificationProvider {
    @Override
    public void sendMessage(String code, Map<String, String> criteria) {

    }
}
