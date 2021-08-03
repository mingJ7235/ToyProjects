package com.core.notification;

import com.core.template.dto.MessageDto;

import java.util.Map;

public interface NotificationProvider {

    void sendMessage(String code, Map<String, String> criteria);



}
