package com.mock.noti_service.services;


import com.mock.noti_service.model.PushNotificationRequest;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class NotificationService {

    private Logger logger = LoggerFactory.getLogger(NotificationService.class);

    private FCMService fcmService;

    public NotificationService(FCMService fcmService) {
        this.fcmService = fcmService;
    }


    public void sendPushNotificationToToken(PushNotificationRequest request) {
        try {
            fcmService.sendMessageToToken(request);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }
}
