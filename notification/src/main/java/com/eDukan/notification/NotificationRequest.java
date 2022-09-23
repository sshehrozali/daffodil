package com.eDukan.notification;

public record NotificationRequest(
        String customerEmail,
        String registeredAt
) {
}
