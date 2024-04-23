package com.example.meetuteam2.controllers;
import com.example.meetuteam2.DTO.BookingDTO;
import com.example.meetuteam2.services.BookingService;
import io.swagger.v3.oas.annotations.Operation;
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


    @Operation(summary = "Crea e Salva una Prenotazione")
    @PostMapping("/createbooking")
    public ResponseEntity<BookingDTO> addBooking(@PathVariable(name = "userId") Long userId, @PathVariable(name = "experienceId") Long experienceId, @RequestBody BookingDTO bookingDTO) {
        Optional<BookingDTO> optionalBookingDTO = bookingService.addBooking(userId, experienceId, bookingDTO);
        if (optionalBookingDTO.isPresent()) {
            return ResponseEntity.ok().body(optionalBookingDTO.get());
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @Operation(summary = "Mostra una Lista con le Prenotazione")
    @GetMapping("/getbookings")
    public ResponseEntity<List<BookingDTO>> findAllBooking() {
        return ResponseEntity.ok(bookingService.bookingList());
    }

    @Operation(summary = "Trova una Prenotazione Tramitte l'Id")
    @GetMapping("/findbooking/{id}")
    public ResponseEntity<Optional<BookingDTO>> findByIdBooking(@RequestParam Long id) {
        Optional<BookingDTO> bookingOptional = bookingService.findBookingById(id);
        if (bookingOptional.isPresent()) {
            return ResponseEntity.ok(bookingOptional);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Aggiorna una Prenotazione Tramite l'Id")
    @PutMapping("/updatebooking/{id}")
    public ResponseEntity<BookingDTO> modifyBooking(@PathVariable Long id, @RequestBody BookingDTO bookingDTO) {
        Optional<BookingDTO> bookingOptional = bookingService.updateBooking(bookingDTO, id);
        if (bookingOptional.isPresent()) {
            return ResponseEntity.ok(bookingOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Elimina una Prenotazione")
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
