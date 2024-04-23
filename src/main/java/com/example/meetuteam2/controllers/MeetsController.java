package com.example.meetuteam2.controllers;

import com.example.meetuteam2.DTO.MeetsDTO;
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

    @PostMapping("/createmeets/{userId}")
    public ResponseEntity<MeetsDTO> createMeets(@PathVariable(name = "userId") Long userId, @RequestBody MeetsDTO meetsDTO) {
        Optional<MeetsDTO> meetsResponseOptional = meetsService.createMeets(userId,meetsDTO);
        if (meetsResponseOptional.isPresent()) {
            return ResponseEntity.ok().body(meetsResponseOptional.get());
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/getmeets")
    public ResponseEntity<List<MeetsDTO>> findAllMeets() {
        return ResponseEntity.ok(meetsService.getActiveMeetsList());
    }

    @GetMapping("/findmeets/{id}")
    public ResponseEntity<MeetsDTO> findByIdMeets(@RequestParam Long id) {
        Optional<MeetsDTO> meetsOptional = meetsService.getMeetsById(id);
        if (meetsOptional.isPresent()) {
            return ResponseEntity.ok(meetsOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/updatemeets/{id}")
    public ResponseEntity<MeetsDTO> modifyMeets(@PathVariable Long id, @RequestBody MeetsDTO meetsDTO) {
        Optional<MeetsDTO> meetsOptional = meetsService.updateMeets(id, meetsDTO);
        if (meetsOptional.isPresent()) {
            return ResponseEntity.ok(meetsOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/deletemeets/{id}")
    public ResponseEntity<MeetsDTO> deleteMeetsStatus(@PathVariable Long id) {
        Optional<MeetsDTO> meetsOptional = meetsService.deleteMeetsRecordStatus(id);
        if (meetsOptional.isPresent()) {
            return ResponseEntity.ok(meetsOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
