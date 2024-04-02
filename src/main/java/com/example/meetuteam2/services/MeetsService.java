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

    /**
     * questo metodo crea un nuovo Meets
     * @param meets
     * @return Meets inserito
     * @author anamariaow
     */

    public Meets createMeets(Meets meets){
        Meets savedMeets = meetsRepository.save(meets);
        return savedMeets;
    }

    /**
     * questo metodo trova la lista dei Meets attivi
     * @return lista dei Meets attivi
     */

    public List<Meets> getActiveMeetsList(){
        List<Meets> meetsList = meetsRepository.findAllActiveMeets();
        return meetsList;
    }

    /**
     * questo metodo recupera un Meets partendo dall'id
     * @param id
     * @return il Meets trovato, se presente, oppure ritorna un Optional vuoto
     */
    public Optional<Meets> getMeetsById(Long id){
        Optional<Meets> meetsOptional = meetsRepository.findById(id);
        if(meetsOptional.isPresent()){
            return meetsOptional;
        }else {
            return Optional.empty();
        }
    }

    /**
     * questo metodo riprende un Meets attraverso l'id e ne aggiorna i field selezionati
     * @param id
     * @param meets
     * @return il Meets aggiornato, se presente, oppure ritorna un Optional vuoto
     */
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

    /**
     * questo metodo recupera un Meets attraverso l'id e ne aggiorna lo status come Deleted
     * @param id
     * @return il Meets con stato aggiornato, se presente, oppure ritorna un Optional vuoto
     */
    public Optional<Meets> deleteMeetsRecordStatus(Long id){
        Optional<Meets> meetsOptional = getMeetsById(id);
        if(meetsOptional.isPresent()){
            meetsOptional.get().setRecordStatus(RecordStatusEnum.D);
            Meets savedMeets = meetsRepository.save(meetsOptional.get());
            return Optional.of(savedMeets);
        }else {
            return Optional.empty();
        }
    }

}
