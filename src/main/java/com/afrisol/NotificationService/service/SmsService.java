package com.afrisol.NotificationService.service;

import org.springframework.stereotype.Service;

@Service
public class SmsService {

    public void sendSms(String phoneNumber, String message) {
        // Mock SMS sending (logging)
        System.out.println("=== Mock SMS ===");
        System.out.println("To: " + phoneNumber);
        System.out.println("Message: " + message);
        System.out.println("================");
    }
}