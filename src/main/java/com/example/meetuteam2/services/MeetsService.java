package com.example.meetuteam2.services;

import com.example.meetuteam2.entities.Meets;
import com.example.meetuteam2.repositories.MeetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeetsService {
    @Autowired
    private MeetsRepository meetsRepository;

    public Meets createMeets(Meets meets) {
        meetsRepository.save(meets);
        return meets;
    }

    public List<Meets> meetsList() {
        return meetsRepository.findAll();
    }
}
