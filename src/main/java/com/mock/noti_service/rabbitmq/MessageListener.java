package com.mock.noti_service.rabbitmq;

import com.mock.noti_service.model.PushNotificationRequest;
import com.mock.noti_service.services.NotificationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class MessageListener {

    private final NotificationService notificationService;

    @RabbitListener(queues = MQConfig.QUEUE)
    public void listener(PushNotificationRequest request) throws InterruptedException {
        notificationService.sendPushNotificationToToken(request);
        log.info(request.toString());
    }
}
