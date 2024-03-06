package com.example.meetuteam2.controllers;

import com.example.meetuteam2.entities.Experience;
import com.example.meetuteam2.services.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("experience")
public class ExperienceController {
    @Autowired
    private ExperienceService experienceService;

    @PostMapping("/addExperience")
    public ResponseEntity<Experience> addExperience(@RequestBody Experience experience){
        experienceService.createExperience(experience);
        return ResponseEntity.ok().body(experience);
    }
}
