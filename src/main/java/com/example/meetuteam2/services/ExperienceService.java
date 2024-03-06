package com.example.meetuteam2.services;

import com.example.meetuteam2.entities.Experience;
import com.example.meetuteam2.repositories.ExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienceService {
    @Autowired
    private ExperienceRepository experienceRepository;

    public Experience createExperience(Experience experience) {
        experienceRepository.save(experience);
        return experience;
    }
    public List<Experience> ExperienceList() {
        return experienceRepository.findAll();
    }
}
