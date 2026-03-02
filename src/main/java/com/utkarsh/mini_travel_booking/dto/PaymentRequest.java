package com.utkarsh.mini_travel_booking.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class PaymentRequest {

    @NotBlank(message = "Card number is required")
    private String cardNumber;

    @Pattern(regexp = "^(0[1-9]|1[0-2])/\\d{2}$", message = "Expiry must be in MM/YY format")
    private String expiry;

    @NotBlank(message = "CVV is required")
    private String cvv;
}