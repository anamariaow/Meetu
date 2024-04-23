package com.example.meetuteam2.controllers;

import com.example.meetuteam2.DTO.ExperienceDTO;
import com.example.meetuteam2.entities.Experience;
import com.example.meetuteam2.entities.enums.RecordStatusEnum;
import com.example.meetuteam2.services.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/experience")
public class ExperienceController {
    @Autowired
    private ExperienceService experienceService;

    @PostMapping("/createexperience/{userId}")
    public ResponseEntity<ExperienceDTO> addExperience(@PathVariable(name = "userId") Long userId,@RequestBody ExperienceDTO experienceDTO) {
        Optional<ExperienceDTO> experienceOptional = experienceService.addExperience(userId,experienceDTO);
        if (experienceOptional.isPresent()) {
            return ResponseEntity.ok(experienceOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/getexperiences")
    public ResponseEntity<List<ExperienceDTO>> findAllExperience() {
        return ResponseEntity.ok(experienceService.experienceList());
    }

    @GetMapping("/findexperience/{id}")
    public ResponseEntity<ExperienceDTO> findByIdBooking(@RequestParam Long id) {
        Optional<ExperienceDTO> experienceOptional = experienceService.findExperienceById(id);
        if (experienceOptional.isPresent()) {
            return ResponseEntity.ok(experienceOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/updateexperience/{id}")
    public ResponseEntity<ExperienceDTO> modifyBooking(@PathVariable Long id, @RequestBody ExperienceDTO experience) {
        Optional<ExperienceDTO> experienceOptional = experienceService.updateExperience(experience,id);
        if (experienceOptional.isPresent()) {
            return ResponseEntity.ok(experienceOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/deleteexperience/{id}")
    public ResponseEntity<ExperienceDTO> deleteExperience(@PathVariable Long id) {
        Optional<ExperienceDTO> experienceOptional = experienceService.deleteExperience(id);
        if (experienceOptional.isPresent()) {
            return ResponseEntity.ok(experienceOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
