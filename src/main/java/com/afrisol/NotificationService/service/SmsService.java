package com.afrisol.NotificationService.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SmsService {

    public void sendSms(String phoneNumber, String message) {
        // Mock SMS sending (logging)
        log.info("=== Mock SMS ===");
        log.info("To: {}", phoneNumber);
        log.info("Message: {}", message);
        log.info("================");
    }
}