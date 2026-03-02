package com.utkarsh.mini_travel_booking.controller;

import com.utkarsh.mini_travel_booking.dto.CreateBookingRequest;
import com.utkarsh.mini_travel_booking.dto.PaymentRequest;
import com.utkarsh.mini_travel_booking.entity.Booking;
import com.utkarsh.mini_travel_booking.service.TravelService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class TravelController {

    private final TravelService travelService;

    // SEARCH API (Dummy Data)
    @GetMapping("/search")
    public List<?> search(
            @RequestParam String from,
            @RequestParam String to,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
            @RequestParam String type) {

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

    //  CREATE BOOKING
    @PostMapping("/bookings")
    public Booking createBooking(@Valid @RequestBody CreateBookingRequest request) {
        return travelService.createBooking(request);
    }

    // PAY FOR BOOKING
    @PostMapping("/bookings/{bookingId}/pay")
    public Booking payForBooking(
            @PathVariable String bookingId,
            @Valid @RequestBody PaymentRequest request) {

        return travelService.payForBooking(bookingId, request);
    }
}