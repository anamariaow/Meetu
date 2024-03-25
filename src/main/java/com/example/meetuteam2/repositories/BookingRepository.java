package com.example.meetuteam2.repositories;
import com.example.meetuteam2.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BookingRepository extends JpaRepository<Booking,Long> {
    @Query("SELECT b FROM Booking b WHERE recordStatus = 'A'")
    List<Booking> findAllActiveBooking();
    @Query("SELECT b FROM Booking b WHERE recordStatus = 'A' AND id = ?1")
    List<Booking> findActiveBookingById(Long id);
}
