package com.afrisol.NotificationService.service;

import com.afrisol.NotificationService.dto.NotificationRequestDto;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Override
    public void sendNotification(NotificationRequestDto request) {
        String type = request.getType().toLowerCase();
        String recipient = request.getRecipient();
        String message = request.getMessage();

        switch (type) {
            case "email":
                sendEmail(recipient, request.getSubject(), message);
                break;
            case "sms":
                sendSms(recipient, message);
                break;
            default:
                throw new IllegalArgumentException("Invalid notification type. Use 'email' or 'sms'.");
        }
    }

    private void sendEmail(String recipient, String subject, String message) {
        if (recipient == null || recipient.isBlank()) {
            throw new IllegalArgumentException("Recipient email cannot be null or empty.");
        }
        if (subject == null || subject.isBlank()) {
            throw new IllegalArgumentException("Email subject cannot be null or empty.");
        }
        if (message == null || message.isBlank()) {
            throw new IllegalArgumentException("Message cannot be null or empty.");
        }

        // Mock email sending by logging
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(recipient);
        mailMessage.setSubject(subject);
        mailMessage.setText(message);

        // Uncomment for real email sending
        // mailSender.send(mailMessage);

        System.out.println("Mock Email Sent to " + recipient + " with subject: " + subject);
    }

    private void sendSms(String phoneNumber, String message) {
        if (phoneNumber == null || phoneNumber.isBlank()) {
            throw new IllegalArgumentException("Phone number cannot be null or empty.");
        }
        if (message == null || message.isBlank()) {
            throw new IllegalArgumentException("Message cannot be null or empty.");
        }

        // Mock SMS sending by logging
        System.out.println("Mock SMS Sent to " + phoneNumber + ": " + message);
    }
}
