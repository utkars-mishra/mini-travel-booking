package com.utkarsh.mini_travel_booking.service;

import com.utkarsh.mini_travel_booking.dto.CreateBookingRequest;
import com.utkarsh.mini_travel_booking.dto.PaymentRequest;
import com.utkarsh.mini_travel_booking.entity.Booking;
import com.utkarsh.mini_travel_booking.entity.BookingStatus;
import com.utkarsh.mini_travel_booking.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
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

    public List<?> search(String from, String to, LocalDate date, String type) {

        if (from.equalsIgnoreCase(to)) {
            throw new IllegalArgumentException("Source and destination cannot be the same");
        }

        return List.of(
                new Object() {
                    public final String optionId = UUID.randomUUID().toString();
                    public final String travelType = type;
                    public final String fromLocation = from;
                    public final String toLocation = to;
                    public final LocalDate travelDate = date;
                    public final LocalTime departureTime = LocalTime.of(10, 30);
                    public final LocalTime arrivalTime = LocalTime.of(12, 30);
                    public final double price = 4500.0;
                }
        );
    }
}