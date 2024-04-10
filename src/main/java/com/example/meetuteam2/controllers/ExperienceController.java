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
    @PostMapping("/createexperience")
    public ResponseEntity<ExperienceDTO> addExperience(@RequestBody ExperienceDTO experienceDTO) {
        return ResponseEntity.ok(experienceService.addExperience(experienceDTO));
    }

    @GetMapping("/getexperiences")
    public ResponseEntity<List<ExperienceDTO>> findAllExperience() {
        return ResponseEntity.ok(experienceService.experienceList());
    }

    @GetMapping("/findexperience/{id}")
    public ResponseEntity<Optional<ExperienceDTO>> findByIdBooking(@RequestParam Long id) {
        Optional<ExperienceDTO> experienceOptional = experienceService.findExperienceById(id);
        if (experienceOptional.isPresent()) {
            return ResponseEntity.ok(experienceOptional);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/updateexperience")
    public ResponseEntity<ExperienceDTO> modifyBooking(@PathVariable Long id, @RequestBody ExperienceDTO experience) {
        Optional<ExperienceDTO> experienceOptional = experienceService.updateExperience(experience,id);
        if (experienceOptional.isPresent()) {
            return ResponseEntity.ok(experienceOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/deleteexperience")
    public ResponseEntity<ExperienceDTO> deleteExperience(Long id) {
        Optional<ExperienceDTO> experienceOptional = experienceService.deleteExperience(id);
        if (experienceOptional.isPresent()) {
            return ResponseEntity.ok(experienceOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
