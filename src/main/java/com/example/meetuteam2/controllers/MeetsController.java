package com.example.meetuteam2.controllers;

import com.example.meetuteam2.entities.Meets;
import com.example.meetuteam2.services.MeetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/meets")
public class MeetsController {
    @Autowired
    private MeetsService meetsService;

    @PostMapping("/addmeets")
    public ResponseEntity<Meets> addmeets(@RequestBody Meets meets) {
        meetsService.createMeets(meets);
        return ResponseEntity.ok().body(meets);
    }

    @GetMapping("/selectmeets")
    public ResponseEntity<List<Meets>> selectmeets() {
        List<Meets> selectmeetslist = meetsService.meetsList();
        return ResponseEntity.ok().body(selectmeetslist);
    }
}
