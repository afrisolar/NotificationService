package com.afrisol.NotificationService.controller;

import com.afrisol.NotificationService.dto.NotificationRequestDto;
import com.afrisol.NotificationService.service.NotificationService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping
    public ResponseEntity<String> sendNotification(@Valid @RequestBody NotificationRequestDto request) {
        notificationService.sendNotification(request);
        return ResponseEntity.ok("Notification sent successfully!");
    }
}
