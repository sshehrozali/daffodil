package com.eDukan.customer;

import java.time.LocalDateTime;

public record NotificationRequest(
        String customerEmail,
        LocalDateTime registeredAt
) {
}
