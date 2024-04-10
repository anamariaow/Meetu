package com.example.meetuteam2.services;

import com.example.meetuteam2.DTO.MeetsDTO;
import com.example.meetuteam2.DTO.ReviewDTO;
import com.example.meetuteam2.entities.Meets;
import com.example.meetuteam2.entities.Review;
import com.example.meetuteam2.entities.enums.RecordStatusEnum;
import com.example.meetuteam2.repositories.MeetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MeetsService {
    @Autowired
    private MeetsRepository meetsRepository;

    /**
     * questo metodo richiede un MeetsDTO, lo trasforma in Meets Entity per poi salvarlo,
     * crea e poi ritorna un MeetsDTO come response utilizzando i dati della Meets Entity appena salvata.
     * @param meetsRequestDTO
     * @return MeetsDTO inserito
     * @author anamariaow
     */

    public MeetsDTO createMeets(MeetsDTO meetsRequestDTO){
        Meets meets = new Meets();
        meets.setQuantity(meetsRequestDTO.getQuantity());
        meets.setReleaseDate(LocalDate.now().atStartOfDay());
        meets.setRecordStatus(RecordStatusEnum.A);
        Meets savedMeets = meetsRepository.save(meets);

        MeetsDTO meetsResponseDTO = new MeetsDTO();
        meetsResponseDTO.setId(savedMeets.getId());
        meetsResponseDTO.setQuantity(savedMeets.getQuantity());
        meetsResponseDTO.setReleaseDate(savedMeets.getReleaseDate());
        return meetsRequestDTO;
    }

    /**
     * questo metodo trova la lista dei Meets attivi,
     * crea una lista di MeetsDTO,
     * cicla per inserire all'interno della lista i meetsDTO utilizzando gli oggetti presenti
     * nella lista di Meets richiesta.
     * @return lista dei Meets attivi
     */

    public List<MeetsDTO> getActiveMeetsList(){
        List<Meets> meetsList = meetsRepository.findAllActiveMeets();
        List<MeetsDTO> meetsDTOList = new ArrayList<>();
        for(Meets meets : meetsList){
            MeetsDTO meetsResponseDTO = new MeetsDTO();
            meetsResponseDTO.setId(meets.getId());
            meetsResponseDTO.setQuantity(meets.getQuantity());
            meetsResponseDTO.setReleaseDate(meets.getReleaseDate());
            meetsDTOList.add(meetsResponseDTO);
        }
        return meetsDTOList;
    }

    /**
     * questo metodo recupera un Meets partendo dal suo id, se presente,
     * crea e ritorna un MeetsDTO e gli assegna i parametri del Meets recuperato.
     * @param id
     * @return il MeetsDTO con i dati del Meets recuperato
     */
    public Optional<MeetsDTO> getMeetsById(Long id){
        Optional<Meets> meetsOptional = meetsRepository.findById(id);
        if(meetsOptional.isPresent()){
            MeetsDTO meetsResponseDTO = new MeetsDTO();
            meetsResponseDTO.setId(meetsOptional.get().getId());
            meetsResponseDTO.setQuantity(meetsOptional.get().getQuantity());
            meetsResponseDTO.setReleaseDate(meetsOptional.get().getReleaseDate());
            return Optional.of(meetsResponseDTO);
        } else {
            return Optional.empty();
        }
    }

    /**
     * questo metodo riprende un Meets attraverso l'id e ne aggiorna i field selezionati
     * crea e ritorna un MeetsDTO con i dati del Meets aggiornato
     * @param id
     * @param meetsDTO
     * @return il MeetsDTO aggiornato, se presente, oppure ritorna un Optional vuoto
     */
    public Optional<MeetsDTO> updateMeets(Long id,MeetsDTO meetsDTO){
        Optional<Meets> meetsOptional = meetsRepository.findById(id);
        if(meetsOptional.isPresent()){
            meetsOptional.get().setQuantity(meetsDTO.getQuantity());
            meetsOptional.get().setReleaseDate(meetsDTO.getReleaseDate());
            Meets savedMeets = meetsRepository.save(meetsOptional.get());

            MeetsDTO meetsResponseDTO = new MeetsDTO();
            meetsResponseDTO.setId(savedMeets.getId());
            meetsResponseDTO.setQuantity(savedMeets.getQuantity());
            meetsResponseDTO.setReleaseDate(savedMeets.getReleaseDate());
            return Optional.of(meetsResponseDTO);
        } else {
            return Optional.empty();
        }
    }

    /**
     * questo metodo recupera un Meets attraverso l'id e ne aggiorna lo status come Deleted
     * crea e ritorna un MeetsDTO con i medesimi dati del Meets aggiornato
     * @param id
     * @return il MeetsDTO aggiornato, se presente, oppure ritorna un Optional vuoto
     */
    public Optional<MeetsDTO> deleteMeetsRecordStatus(Long id){
        Optional<Meets> meetsOptional = meetsRepository.findById(id);
        if(meetsOptional.isPresent()){
            meetsOptional.get().setRecordStatus(RecordStatusEnum.D);
            Meets savedMeets = meetsRepository.save(meetsOptional.get());

            MeetsDTO meetsResponseDTO = new MeetsDTO();
            meetsResponseDTO.setId(savedMeets.getId());
            meetsResponseDTO.setQuantity(savedMeets.getQuantity());
            meetsResponseDTO.setReleaseDate(savedMeets.getReleaseDate());
            return Optional.of(meetsResponseDTO);
        } else {
            return Optional.empty();
        }
    }

}
