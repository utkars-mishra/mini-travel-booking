package com.utkarsh.mini_travel_booking.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String bookingId;

    private String optionId;
    private String passengerName;
    private String email;
    private String phone;

    @Enumerated(EnumType.STRING)
    private BookingStatus status;

    private Double amount;

    private String transactionId;
}