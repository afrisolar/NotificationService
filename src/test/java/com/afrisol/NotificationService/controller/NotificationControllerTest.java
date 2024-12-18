package com.afrisol.NotificationService.controller;

import com.afrisol.NotificationService.dto.NotificationRequestDto;
import com.afrisol.NotificationService.service.NotificationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class NotificationControllerTest {

    @Mock
    private NotificationService notificationService;

    @InjectMocks
    private NotificationController notificationController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void sendNotification_shouldReturnSuccessMessage_whenRequestIsValid() {
        // Arrange
        NotificationRequestDto request = new NotificationRequestDto();
        request.setType("email");
        request.setRecipient("test@example.com");
        request.setMessage("Test message");
        request.setSubject("Test Subject");

        doNothing().when(notificationService).sendNotification(request);

        // Act
        ResponseEntity<String> response = notificationController.sendNotification(request);

        // Assert
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Notification sent successfully!", response.getBody());
        verify(notificationService, times(1)).sendNotification(request);
    }


    @Test
    void sendNotification_shouldHandleMissingOptionalSubject() {
        // Arrange
        NotificationRequestDto request = new NotificationRequestDto();
        request.setType("email");
        request.setRecipient("test@example.com");
        request.setMessage("Message without subject");
        request.setSubject(null); // Subject is optional

        doNothing().when(notificationService).sendNotification(request);

        // Act
        ResponseEntity<String> response = notificationController.sendNotification(request);

        // Assert
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Notification sent successfully!", response.getBody());
        verify(notificationService, times(1)).sendNotification(request);
    }
}
