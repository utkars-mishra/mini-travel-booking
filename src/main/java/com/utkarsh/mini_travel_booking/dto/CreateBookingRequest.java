package com.utkarsh.mini_travel_booking.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateBookingRequest {

    @NotBlank(message = "Option ID is required")
    private String optionId;

    @NotBlank(message = "Passenger name is required")
    private String passengerName;

    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Phone number is required")
    private String phone;
}