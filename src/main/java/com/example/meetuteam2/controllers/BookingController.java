package com.example.meetuteam2.controllers;
import com.example.meetuteam2.DTO.BookingDTO;
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
    public ResponseEntity<BookingDTO> addBooking(@PathVariable(name = "userId") Long userId, @PathVariable(name = "experienceId") Long experienceId, @RequestBody BookingDTO bookingDTO) {
        Optional<BookingDTO> optionalBookingDTO = bookingService.addBooking(userId, experienceId, bookingDTO);
        if (optionalBookingDTO.isPresent()) {
            return ResponseEntity.ok().body(optionalBookingDTO.get());
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/getbookings")
    public ResponseEntity<List<BookingDTO>> findAllBooking() {
        return ResponseEntity.ok(bookingService.bookingList());
    }

    @GetMapping("/findbooking/{id}")
    public ResponseEntity<Optional<BookingDTO>> findByIdBooking(@RequestParam Long id) {
        Optional<BookingDTO> bookingOptional = bookingService.findBookingById(id);
        if (bookingOptional.isPresent()) {
            return ResponseEntity.ok(bookingOptional);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/updatebooking")
    public ResponseEntity<BookingDTO> modifyBooking(@PathVariable Long id, @RequestBody BookingDTO bookingDTO) {
        Optional<BookingDTO> bookingOptional = bookingService.updateBooking(bookingDTO, id);
        if (bookingOptional.isPresent()) {
            return ResponseEntity.ok(bookingOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/deletebookingstatus")
    public ResponseEntity<BookingDTO> deleteBookingRecordStatus(@PathVariable Long id) {
        Optional<BookingDTO> bookingOptional= bookingService.deleteBookingRecordStatus(id);
        if (bookingOptional.isPresent()) {
            return ResponseEntity.ok(bookingOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
