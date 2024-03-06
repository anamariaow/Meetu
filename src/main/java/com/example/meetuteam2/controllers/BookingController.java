package com.example.meetuteam2.controllers;

import com.example.meetuteam2.entities.Booking;
import com.example.meetuteam2.entities.Meets;
import com.example.meetuteam2.servicies.BookingService;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @PostMapping("/addbooking")
    public ResponseEntity<Booking> addbooking(@RequestBody Booking booking) {
        bookingService.createBooking(booking);
        return ResponseEntity.ok().body(booking);

    }
    @GetMapping("/selectbooking")
    public ResponseEntity<List<Booking>> selectbooking() {
        List<Booking> bookingList = bookingService.bookingList();
        return ResponseEntity.ok().body(bookingList);
    }


}

