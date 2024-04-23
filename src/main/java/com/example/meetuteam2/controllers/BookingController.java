package com.example.meetuteam2.controllers;
import com.example.meetuteam2.DTO.BookingDTO;
import com.example.meetuteam2.services.BookingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@Tag(name = "Booking", description = "Controller delle APIs per le prenotazioni")
@RestController
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    private BookingService bookingService;


    @Operation(summary = "Crea e salva una prenotazione")
    @PostMapping("/createbooking/{userId}")
    public ResponseEntity<BookingDTO> addBooking(@PathVariable(name = "userId") Long userId, @RequestParam(name = "experienceId") Long experienceId, @RequestBody BookingDTO bookingDTO) {
        Optional<BookingDTO> optionalBookingDTO = bookingService.addBooking(userId, experienceId, bookingDTO);
        if (optionalBookingDTO.isPresent()) {
            return ResponseEntity.ok().body(optionalBookingDTO.get());
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @Operation(summary = "Mostra una lista con le prenotazione")
    @GetMapping("/getbookings")
    public ResponseEntity<List<BookingDTO>> findAllBooking() {
        return ResponseEntity.ok(bookingService.bookingList());
    }

    @Operation(summary = "Trova una prenotazione tramite l'id")
    @GetMapping("/findbooking/{id}")
    public ResponseEntity<BookingDTO> findByIdBooking(@RequestParam Long id) {
        Optional<BookingDTO> bookingOptional = bookingService.findBookingById(id);
        if (bookingOptional.isPresent()) {
            return ResponseEntity.ok(bookingOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Aggiorna una prenotazione tramite l'id")
    @PutMapping("/updatebooking/{id}")
    public ResponseEntity<BookingDTO> modifyBooking(@PathVariable Long id, @RequestBody BookingDTO bookingDTO) {
        Optional<BookingDTO> bookingOptional = bookingService.updateBooking(bookingDTO, id);
        if (bookingOptional.isPresent()) {
            return ResponseEntity.ok(bookingOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Elimina una prenotazione")
    @PutMapping("/deletebookingstatus/{id}")
    public ResponseEntity<BookingDTO> deleteBookingRecordStatus(@PathVariable Long id) {
        Optional<BookingDTO> bookingOptional= bookingService.deleteBookingRecordStatus(id);
        if (bookingOptional.isPresent()) {
            return ResponseEntity.ok(bookingOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
