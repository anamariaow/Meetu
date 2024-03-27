package com.example.meetuteam2.services;

import com.example.meetuteam2.entities.Meets;
import com.example.meetuteam2.entities.enums.RecordStatusEnum;
import com.example.meetuteam2.repositories.MeetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MeetsService {
    @Autowired
    private MeetsRepository meetsRepository;

    public Meets createMeets(Meets meets){
        Meets savedMeets = meetsRepository.save(meets);
        return savedMeets;
    }

    public List<Meets> getActiveMeetsList(){
        List<Meets> meetsList = meetsRepository.findAllActiveMeets();
        return meetsList;
    }
    public Optional<Meets> getMeetsById(Long id){
        Optional<Meets> meetsOptional = meetsRepository.findById(id);
        if(meetsOptional.isPresent()){
            return meetsOptional;
        }else {
            return Optional.empty();
        }
    }
    public Optional<Meets> updateMeets(Long id,Meets meets){
        Optional<Meets> meetsOptional = getMeetsById(id);
        if(meetsOptional.isPresent()){
            meetsOptional.get().setQuantity(meets.getQuantity());
            meetsOptional.get().setReleaseDate(meets.getReleaseDate());
            meetsOptional.get().setUser(meets.getUser());
            meetsOptional.get().setRecordStatus(meets.getRecordStatus());
            Meets savedMeets = meetsRepository.save(meetsOptional.get());
            return Optional.of(savedMeets);
        }else {
            return Optional.empty();
        }
    }
    public Optional<Meets> updateMeetsRecordStatus(Long id, RecordStatusEnum recordStatusEnum){
        Optional<Meets> meetsOptional = getMeetsById(id);
        if(meetsOptional.isPresent()){
            meetsOptional.get().setRecordStatus(recordStatusEnum);
            Meets meetsReview = meetsRepository.save(meetsOptional.get());
            return Optional.of(meetsReview);
        }else {
            return Optional.empty();
        }
    }
    public Optional<Meets> deleteMeets(Long id){
        Optional<Meets> meetsOptional = getMeetsById(id);
        if(meetsOptional.isPresent()){
            meetsRepository.deleteById(meetsOptional.get().getId());
            return Optional.of(meetsOptional.get());
        }else {
            return Optional.empty();
        }
    }
}
