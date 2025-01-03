package com.afrisol.NotificationService.service;

import com.afrisol.NotificationService.dto.NotificationRequestDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class NotificationServiceImpl implements NotificationService {

    @Override
    public Mono<Void> sendNotification(NotificationRequestDto request) {
        String type = request.getType().toLowerCase();
        String recipient = request.getRecipient();
        String message = request.getMessage();

        if (type == "email" ) sendEmail(recipient, request.getSubject(), message);
        else if (type == "sms") sendSms(recipient, message);
        else throw new IllegalArgumentException("Invalid notification type. Use 'email' or 'sms'.");

        return Mono.empty();
    }

    private void sendEmail(String recipient, String subject, String message) {

        // Mock email sending by logging
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(recipient);
        mailMessage.setSubject(subject);
        mailMessage.setText(message);

        // Uncomment for real email sending
        // mailSender.send(mailMessage);

        log.info("Mock Email Sent to {} with subject: {}", recipient, subject);
    }

    private void sendSms(String phoneNumber, String message) {

        // Mock SMS sending by logging
        log.info("Mock SMS Sent to {}: {} ", phoneNumber, message);
    }
}
