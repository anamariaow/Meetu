package com.example.meetuteam2.controllers;

import com.example.meetuteam2.entities.Meets;
import com.example.meetuteam2.services.MeetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/meets")
public class MeetsController {

    @Autowired
    private MeetsService meetsService;

    @PostMapping("/createmeets")
    public ResponseEntity<Meets> createMeets(@RequestBody Meets meets) {
        return ResponseEntity.ok(meetsService.createMeets(meets));
    }

    @GetMapping("/getmeets")
    public ResponseEntity<List<Meets>> findAllMeets() {
        return ResponseEntity.ok(meetsService.getActiveMeetsList());
    }

    @GetMapping("/findmeets/{id}")
    public ResponseEntity<Optional<Meets>> findByIdMeets(@RequestParam Long id) {
        Optional<Meets> meetsOptional = meetsService.getMeetsById(id);
        if (meetsOptional.isPresent()) {
            return ResponseEntity.ok(meetsOptional);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/updatemeets")
    public ResponseEntity<Meets> modifyMeets(@PathVariable Long id, @RequestBody Meets meets) {
        Optional<Meets> meetsOptional = meetsService.updateMeets(id, meets);
        if (meetsOptional.isPresent()) {
            return ResponseEntity.ok(meetsOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deletemeets")
    public ResponseEntity<Meets> deleteMeetsStatus(@PathVariable Long id) {
        Optional<Meets> meetsOptional = meetsService.deleteMeetsRecordStatus(id);
        if (meetsOptional.isPresent()) {
            return ResponseEntity.ok(meetsOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
