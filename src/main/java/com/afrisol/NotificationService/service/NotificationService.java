package com.afrisol.NotificationService.service;

import com.afrisol.NotificationService.dto.NotificationRequestDto;

public interface NotificationService {
    /**
     * Handles sending notifications, determining the type (email or SMS)
     * and ensuring appropriate validations.
     *
     * @param request the notification request containing details such as type, recipient, subject, and message
     */
    void sendNotification(NotificationRequestDto request);
}
