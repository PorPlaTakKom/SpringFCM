package com.mock.noti_service.controller;

import com.mock.noti_service.model.PushNotificationRequest;
import com.mock.noti_service.model.PushNotificationResponse;
import com.mock.noti_service.rabbitmq.MQConfig;
import com.mock.noti_service.services.NotificationService;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@CrossOrigin
@AllArgsConstructor
public class FCMPushNotificationController {

    private final NotificationService notificationService;

    private final RabbitTemplate template;

    @PostMapping("/send/notification")
    public ResponseEntity<?> sendTokenNotification(@RequestBody PushNotificationRequest request) {
        template.convertAndSend(MQConfig.EXCHANGE,
                MQConfig.ROUTING_KEY, request);
        return new ResponseEntity<>(new PushNotificationResponse(HttpStatus.OK.value(), "Notification has been sent."), HttpStatus.OK);
    }
}
