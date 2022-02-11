package com.mock.noti_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PushNotificationRequest {

    private String title;
    private String message;
    private String topic;
    private String token;
}