package com.afrisol.NotificationService.service;


import org.springframework.stereotype.Service;

@Service
public class EmailService {

    public void sendEmail(String recipient, String subject, String message) {
        // Mock email sending (logging)
        System.out.println("=== Mock Email ===");
        System.out.println("To: " + recipient);
        System.out.println("Subject: " + subject);
        System.out.println("Message: " + message);
        System.out.println("==================");
    }
}
