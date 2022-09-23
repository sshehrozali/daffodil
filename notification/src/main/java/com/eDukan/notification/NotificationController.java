package com.eDukan.notification;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/notification")
@AllArgsConstructor
@Slf4j
public class NotificationController {
    private final NotificationService notificationService;

    @PostMapping
    public NotificationResponse publishNotification(@RequestBody NotificationRequest request) {
        log.info("New Notification: " + request.customerEmail() + "registered at " + request.registeredAt());
        return notificationService.send(request);
    }
}
