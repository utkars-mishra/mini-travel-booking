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

        return travelService.search(from, to, date, type);
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