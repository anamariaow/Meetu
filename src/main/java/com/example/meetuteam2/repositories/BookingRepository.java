package com.example.meetuteam2.repositories;

import com.example.meetuteam2.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking,Long> {
}
