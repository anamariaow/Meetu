package com.example.meetuteam2.services;

import com.example.meetuteam2.entities.User;
import com.example.meetuteam2.entities.Experience;
import com.example.meetuteam2.entities.enums.RecordStatusEnum;
import com.example.meetuteam2.repositories.ExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ExperienceService {
    @Autowired
    private ExperienceRepository experienceRepository;
    /**
     * questo metodo crea una nuova Experience
     * @param experience
     * @return Experience fatta
     * @author SS
     */
    public Experience addExperience(Experience experience){
        return experienceRepository.save(experience);
    }


    /**
     * questo metodo ritorna la lista degli Booking attivi
     * @return lista delle Experience attivi
     */
    public List<Experience> bookingList(){
        return experienceRepository.findAll();
    }


    /**
     * questo metodo recupera ti permette cercare un Experience partendo dalla sua id
     * @param id
     * @return Experience trovata (se presente) oppure non ritorna niente.
     */

    public Optional<Experience> findExperienceById(Long id){
        return experienceRepository.findById(id);
    }
    /**
     * questo metodo ti permette aggiornare i field selezionati di un Booking, recuperandolo attraverso l'id
     * @param id
     * @param experience
     * @return Experience aggiornato (se presente) oppure non ritorna niente
     */
    public Optional<Experience> updateExperience(Experience experience,Long id){
        Optional<Experience> optionalExperience= experienceRepository.findById(id);
        if (optionalExperience.isPresent()){
            optionalExperience.get().setName(experience.getName());
            optionalExperience.get().setDescription(experience.getDescription());
            optionalExperience.get().setPrice(experience.getPrice());
            optionalExperience.get().setTypeExperienceEnumList(experience.getTypeExperienceEnumList());
            optionalExperience.get().setExperienceValue(experience.getExperienceValue());
            optionalExperience.get().setUser(experience.getUser());
            optionalExperience.get().setBooking(experience.getBooking());
            optionalExperience.get().setRecordStatus(experience.getRecordStatus());
            experienceRepository.save(optionalExperience.get());
            return optionalExperience;
        }else {
            return Optional.empty();
        }

    }
    /**
     * questo metodo recupera un Experience  attraverso l'id e ne aggiorna lo status
     * @param id
     * @param recordStatusEnum
     * @return l' Experience con stato aggiornato, se presente, oppure non ritorna niente.
     */
    public Optional<Experience> updateExperienceRecordStatus(Long id, RecordStatusEnum recordStatusEnum){
        Optional<Experience> experienceOptional = findExperienceById(id);
        if(experienceOptional.isPresent()){
            experienceOptional.get().setRecordStatus(recordStatusEnum);
            Experience experience = experienceRepository.save(experienceOptional.get());
            return Optional.of(experience);
        }else {
            return Optional.empty();
        }
    }

    /**
     * questo metodo elimina una Experience, recuperandola attraverso il suo id
     * @param id
     * @return Experience appena eliminato, se presente, oppure non ritorna niente.
     */
    public Optional<Experience> deleteExperience(Long id){
        Optional<Experience> optionalExperience = experienceRepository.findById(id);
        if(optionalExperience.isPresent()){
            experienceRepository.delete(optionalExperience.get());
        }else{
            return Optional.empty();
        }
        return optionalExperience;
    }
}
