package com.eDukan.notification;

import java.time.LocalDateTime;

public record NotificationRequest(
        String customerEmail,
        LocalDateTime registeredAt
) {
}
