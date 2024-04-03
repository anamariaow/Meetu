package com.example.meetuteam2.controllers;

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
    public ResponseEntity<Experience> addExperience(@RequestBody Experience experience) {
        return ResponseEntity.ok(experienceService.addExperience(experience));
    }

    @GetMapping("/getexperience")
    public ResponseEntity<List<Experience>> findAllExperience() {
        return ResponseEntity.ok(experienceService.bookingList());
    }

    @GetMapping("/findexperience/{id}")
    public ResponseEntity<Optional<Experience>> findByIdBooking(@RequestParam Long id) {
        Optional<Experience> experienceOptional = experienceService.findExperienceById(id);
        if (experienceOptional.isPresent()) {
            return ResponseEntity.ok(experienceOptional);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/updateexperience")
    public ResponseEntity<Experience> modifyBooking(@PathVariable Long id, @RequestBody Experience experience) {
        Optional<Experience> experienceOptional = experienceService.updateExperience(experience,id);
        if (experienceOptional.isPresent()) {
            return ResponseEntity.ok(experienceOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/updateexperiencestatus")
    public ResponseEntity<Experience> updateBookingStatus(@PathVariable Long id, @RequestBody RecordStatusEnum recordStatusEnum) {
        Optional<Experience> experienceOptional= experienceService.updateExperienceRecordStatus(id, recordStatusEnum);
        if (experienceOptional.isPresent()) {
            return ResponseEntity.ok(experienceOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/deleteexperience")
    public ResponseEntity<Experience> deleteExperience(Long id) {
        Optional<Experience> experienceOptional = experienceService.deleteExperience(id);
        if (experienceOptional.isPresent()) {
            return ResponseEntity.ok(experienceOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
