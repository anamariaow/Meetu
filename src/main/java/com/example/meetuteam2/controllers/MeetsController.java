package com.example.meetuteam2.controllers;

import com.example.meetuteam2.DTO.MeetsDTO;
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
    public ResponseEntity<MeetsDTO> createMeets(@RequestBody MeetsDTO meetsDTO) {
        return ResponseEntity.ok(meetsService.createMeets(meetsDTO));
    }

    @GetMapping("/getmeets")
    public ResponseEntity<List<MeetsDTO>> findAllMeets() {
        return ResponseEntity.ok(meetsService.getActiveMeetsList());
    }

    @GetMapping("/findmeets/{id}")
    public ResponseEntity<Optional<MeetsDTO>> findByIdMeets(@RequestParam Long id) {
        Optional<MeetsDTO> meetsOptional = meetsService.getMeetsById(id);
        if (meetsOptional.isPresent()) {
            return ResponseEntity.ok(meetsOptional);
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
