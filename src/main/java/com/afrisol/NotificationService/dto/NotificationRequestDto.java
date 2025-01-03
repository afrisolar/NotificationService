package com.afrisol.NotificationService.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotificationRequestDto {

    @NotBlank(message = "Type is mandatory and must be 'email' or 'sms'")
    @Pattern(regexp = "^(email|sms)$", message = "Type must be either 'email' or 'sms'")
    private String type;

    @NotBlank(message = "Recipient is mandatory")
    @Pattern(regexp = "^(\\+?[1-9]\\d{1,14}|[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,})$",
            message = "Recipient must be a valid email or phone number")
    private String recipient;

    @Size(max = 100, message = "Subject must not exceed 100 characters")
    private String subject; // Optional, validated only if type is 'email'

    @NotBlank(message = "Message is mandatory")
    @Size(max = 500, message = "Message must not exceed 500 characters")
    private String message;

}
