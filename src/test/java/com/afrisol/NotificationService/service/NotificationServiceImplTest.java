package com.afrisol.NotificationService.service;

import com.afrisol.NotificationService.dto.NotificationRequestDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;
@SpringBootTest
class NotificationServiceImplTest {

    @InjectMocks
    private NotificationServiceImpl notificationService;

    @Test
    void testSendEmailNotification() {
        NotificationRequestDto request = new NotificationRequestDto();
        request.setType("email");
        request.setRecipient("test@example.com");
        request.setSubject("Test Subject");
        request.setMessage("Test email message.");

        notificationService.sendNotification(request);
        // Verify by checking logs or manually ensuring no exception is thrown
    }

    @Test
    void testSendSmsNotification() {
        NotificationRequestDto request = new NotificationRequestDto();
        request.setType("sms");
        request.setRecipient("+1234567890");
        request.setMessage("Test SMS message.");

        notificationService.sendNotification(request);
        // Verify by checking logs or manually ensuring no exception is thrown
    }

    @Test
    void testSendNotificationWithInvalidType() {
        NotificationRequestDto request = new NotificationRequestDto();
        request.setType("push"); // Invalid type
        request.setRecipient("test@example.com");
        request.setMessage("Invalid notification type test.");

        assertThrows(IllegalArgumentException.class, () -> notificationService.sendNotification(request));
    }

}
