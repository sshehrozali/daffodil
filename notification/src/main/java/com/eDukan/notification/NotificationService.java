package com.eDukan.notification;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class NotificationService {
    private final NotificationRepository notificationRepository;
    public NotificationResponse send(NotificationRequest request) {
        Notification notification = Notification.builder()
                .customerEmail(request.customerEmail())
                .registeredAt(request.registeredAt())
                .sentAt(LocalDateTime.now())
                .build();
        notificationRepository.save(notification);
        return new NotificationResponse(true);
    }
}
