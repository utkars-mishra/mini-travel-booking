package com.utkarsh.mini_travel_booking.repository;

import com.utkarsh.mini_travel_booking.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, String> {
}