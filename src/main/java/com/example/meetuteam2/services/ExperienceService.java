package com.example.meetuteam2.services;

import com.example.meetuteam2.DTO.BookingDTO;
import com.example.meetuteam2.DTO.ExperienceDTO;
import com.example.meetuteam2.entities.Booking;
import com.example.meetuteam2.entities.User;
import com.example.meetuteam2.entities.Experience;
import com.example.meetuteam2.entities.enums.RecordStatusEnum;
import com.example.meetuteam2.repositories.ExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class ExperienceService {
    @Autowired
    private ExperienceRepository experienceRepository;
    /**
     * questo metodo crea una nuova Experience
     * @param experienceDTO
     * @return Experience fatta
     * @author SS
     */
    public ExperienceDTO addExperience(ExperienceDTO experienceDTO){
        Experience experience = new Experience();
        experience.setName(experience.getName());
        experience.setDescription(experience.getDescription());
        experience.setPrice(experience.getPrice());

        Experience savedExperience = experienceRepository.save(experience);

        ExperienceDTO experienceResponseDTO = new ExperienceDTO();

        experienceResponseDTO.setId(savedExperience.getId());
        experienceResponseDTO.setName(savedExperience.getName());
        experienceResponseDTO.setDescription(savedExperience.getDescription());
        experienceResponseDTO.setPrice(savedExperience.getPrice());
        return experienceResponseDTO;
    }


    /**
     * questo metodo ritorna la lista delle Experiences attive
     * @return lista delle Experience attive
     */
    public List<ExperienceDTO> experienceList(){
        List<Experience> experienceList = experienceRepository.findAllActiveExperiences();
        List<ExperienceDTO> experienceDTOS = new ArrayList<>();
        for(Experience experience : experienceList){

            ExperienceDTO experienceResponseDTO = new ExperienceDTO();

            experienceResponseDTO.setId(experience.getId());
            experienceResponseDTO.setName(experience.getName());
            experienceResponseDTO.setDescription(experience.getDescription());
            experienceResponseDTO.setPrice(experience.getPrice());

            experienceDTOS.add(experienceResponseDTO);
        }

        return experienceDTOS;
    }


    /**
     * questo metodo recupera ti permette cercare un Experience partendo dalla sua id
     * @param id
     * @return Experience trovata (se presente) oppure non ritorna niente.
     */

    public Optional<ExperienceDTO> findExperienceById(Long id){
        Optional<Experience> optionalExperience = experienceRepository.findById(id);
        if(optionalExperience.isPresent()){

            ExperienceDTO experienceResponseDTO = new ExperienceDTO();

            experienceResponseDTO.setId(optionalExperience.get().getId());
            experienceResponseDTO.setName(optionalExperience.get().getName());
            experienceResponseDTO.setDescription(optionalExperience.get().getDescription());
            experienceResponseDTO.setPrice(optionalExperience.get().getPrice());
            return Optional.of(experienceResponseDTO);

        } else{
            return Optional.empty();
        }

    }
    /**
     * questo metodo ti permette aggiornare i field selezionati di un Experience, recuperandolo attraverso l'id
     * @param id
     * @param experienceDTO
     * @return Experience aggiornato (se presente) oppure non ritorna niente
     */
    public Optional<ExperienceDTO> updateExperience(ExperienceDTO experienceDTO,Long id){
        Optional<Experience> optionalExperience= experienceRepository.findById(id);
        if (optionalExperience.isPresent()){
            optionalExperience.get().setName(experienceDTO.getName());
            optionalExperience.get().setDescription(experienceDTO.getDescription());
            optionalExperience.get().setPrice(experienceDTO.getPrice());

            Experience savedExperience =experienceRepository.save(optionalExperience.get());

            ExperienceDTO experienceResponseDTO = new ExperienceDTO();

            experienceResponseDTO.setId(savedExperience.getId());
            experienceResponseDTO.setName(savedExperience.getName());
            experienceResponseDTO.setDescription(savedExperience.getDescription());
            experienceResponseDTO.setPrice(savedExperience.getPrice());

            return Optional.of(experienceResponseDTO);
        }else {
            return Optional.empty();
        }

    }

    /**
     * questo metodo elimina una Experience, recuperandola attraverso il suo id
     * @param id
     * @return Experience appena eliminato, se presente, oppure non ritorna niente.
     */
    public Optional<ExperienceDTO> deleteExperience(Long id){
        Optional<Experience> experienceOptional = experienceRepository.findById(id);
        if(experienceOptional.isPresent()){
            experienceOptional.get().setRecordStatus(RecordStatusEnum.D);
            Experience experience = experienceRepository.save(experienceOptional.get());
            ExperienceDTO experienceResponseDto= new ExperienceDTO();

            experienceResponseDto.setId(experience.getId());
            experienceResponseDto.setName(experience.getName());
            experienceResponseDto.setDescription(experience.getDescription());
            experienceResponseDto.setPrice(experience.getPrice());

            return Optional.of(experienceResponseDto);
        }else {
            return Optional.empty();
        }
    }
}
