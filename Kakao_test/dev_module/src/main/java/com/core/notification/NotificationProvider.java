package com.core.notification;

import java.util.Map;

public interface NotificationProvider {

    void sendMessage (SendNotiMessage message);

    void sendMessage(String userName, String userEmail, String code, Map<String, String> criteria);

}
