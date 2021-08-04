package com.core.notification;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@Builder
public class SendNotiMessage {
    private String userName;

    private String userEmail;

    private String templateCode;

    private Map <String, String> criteria;
}
