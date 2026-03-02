package com.utkarsh.mini_travel_booking.service;

import com.utkarsh.mini_travel_booking.dto.CreateBookingRequest;
import com.utkarsh.mini_travel_booking.dto.PaymentRequest;
import com.utkarsh.mini_travel_booking.entity.Booking;
import com.utkarsh.mini_travel_booking.entity.BookingStatus;
import com.utkarsh.mini_travel_booking.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TravelService {

    private final BookingRepository bookingRepository;

    public Booking createBooking(CreateBookingRequest request) {

        Booking booking = Booking.builder()
                .optionId(request.getOptionId())
                .passengerName(request.getPassengerName())
                .email(request.getEmail())
                .phone(request.getPhone())
                .status(BookingStatus.HOLD)
                .amount(4500.0)   // dummy fixed amount
                .build();

        return bookingRepository.save(booking);
    }

    public Booking payForBooking(String bookingId, PaymentRequest request) {

        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        if (request.getCardNumber().endsWith("0")) {
            booking.setStatus(BookingStatus.FAILED);
            bookingRepository.save(booking);
            throw new RuntimeException("Payment failed");
        }

        booking.setStatus(BookingStatus.CONFIRMED);
        booking.setTransactionId(UUID.randomUUID().toString());

        return bookingRepository.save(booking);
    }
}