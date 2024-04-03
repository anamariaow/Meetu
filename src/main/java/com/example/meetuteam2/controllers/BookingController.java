package com.example.meetuteam2.controllers;
import com.example.meetuteam2.entities.Booking;
import com.example.meetuteam2.entities.enums.RecordStatusEnum;
import com.example.meetuteam2.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @PostMapping("/createbooking")
    public ResponseEntity<Booking> addBooking(@RequestBody Booking booking) {
        return ResponseEntity.ok(bookingService.addBooking(booking));
    }

    @GetMapping("/getbookings")
    public ResponseEntity<List<Booking>> findAllBooking() {
        return ResponseEntity.ok(bookingService.bookingList());
    }

    @GetMapping("/findbooking/{id}")
    public ResponseEntity<Optional<Booking>> findByIdBooking(@RequestParam Long id) {
        Optional<Booking> bookingOptional = bookingService.findBookingById(id);
        if (bookingOptional.isPresent()) {
            return ResponseEntity.ok(bookingOptional);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/updatebooking")
    public ResponseEntity<Booking> modifyBooking(@PathVariable Long id, @RequestBody Booking booking) {
        Optional<Booking> bookingOptional = bookingService.updateBooking(booking,id);
        if (bookingOptional.isPresent()) {
            return ResponseEntity.ok(bookingOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/updatebookingstatus")
    public ResponseEntity<Booking> updateBookingStatus(@PathVariable Long id, @RequestBody RecordStatusEnum recordStatusEnum) {
        Optional<Booking> bookingOptional= bookingService.updateBookingRecordStatus(id, recordStatusEnum);
        if (bookingOptional.isPresent()) {
            return ResponseEntity.ok(bookingOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/deletebooking")
    public ResponseEntity<Booking> deleteBooking(Long id) {
        Optional<Booking> bookingOptional = bookingService.deleteBooking(id);
        if (bookingOptional.isPresent()) {
            return ResponseEntity.ok(bookingOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
