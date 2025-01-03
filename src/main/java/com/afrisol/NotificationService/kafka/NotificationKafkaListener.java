package com.afrisol.NotificationService.kafka;

import com.afrisol.NotificationService.dto.NotificationRequestDto;
import com.afrisol.NotificationService.service.NotificationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class NotificationKafkaListener {

    private final NotificationService notificationService;
    private final ObjectMapper objectMapper; // For JSON deserialization

    public NotificationKafkaListener(NotificationService notificationService, ObjectMapper objectMapper) {
        this.notificationService = notificationService;
        this.objectMapper = objectMapper;
    }

    @KafkaListener(topics = "notification", groupId = "notification-service-group")
    public void consume(ConsumerRecord<String, String> record) {
        try {
            // Deserialize the message into NotificationRequestDto
            NotificationRequestDto notificationRequest = objectMapper.readValue(record.value(), NotificationRequestDto.class);

            // Call the service to process the notification
            notificationService.sendNotification(notificationRequest);
        } catch (Exception e) {
            // Log the error for debugging purposes
            log.error("Failed to process message: {}", record.value());
            e.printStackTrace();
        }
    }
}
