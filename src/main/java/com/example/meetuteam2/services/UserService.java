package com.example.meetuteam2.services;

import com.example.meetuteam2.entities.Meets;
import com.example.meetuteam2.entities.User;
import com.example.meetuteam2.entities.enums.RecordStatusEnum;
import com.example.meetuteam2.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * questo metodo crea un nuovo User
     * @param user
     * @return User inserito
     * @author ET
     */
    public User createUser(User user) {
        return userRepository.save(user);
    }

    /**
     * questo metodo ritorna la lista degli User attivi
     * @return lista degli User attivi
     */
    public List<User> getAllActiveUsers() {
        List<User> users = userRepository.findAllActiveUsers();
        return users;
    }

    /**
     * questo metodo recupera un User partendo dalla sua id
     * @param id
     * @return l'User trovato (se presente) oppure ritorna Optional.empty
     */
    public Optional<User> getUserById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if(userOptional.isPresent()) {
            return userOptional;
        } else {
            return Optional.empty();
        }
    }

    /**
     * questo metodo aggiorna i field selezionati di un User, recuperandolo attraverso l'id
     * @param id
     * @param user
     * @return l'User aggiornato (se presente) oppure ritorna Optional.empty
     */
    public Optional<User> updateUserById(Long id, User user) {
        Optional<User> userOptional = getUserById(id);
        if(userOptional.isPresent()) {
           userOptional.get().setName(user.getName());
           userOptional.get().setEmail(user.getEmail());
           userOptional.get().setPassword(user.getPassword());
           userOptional.get().setMoreInfo(user.getMoreInfo());
           userOptional.get().setInterestEnumList(user.getInterestEnumList());
           userOptional.get().setGenderEnum(user.getGenderEnum());
           userOptional.get().setZodiacSignEnum(user.getZodiacSignEnum());
           userOptional.get().setOrientationEnum(user.getOrientationEnum());
           userOptional.get().setExperienceList(user.getExperienceList());
           userOptional.get().setReviewList(user.getReviewList());
           userOptional.get().setMeets(user.getMeets());
           userOptional.get().setBookingList(user.getBookingList());
           userOptional.get().setRecordStatus(user.getRecordStatus());
           userRepository.save(userOptional.get());
           return userOptional;
        } else {
            return Optional.empty();
        }
    }

    /**
     * questo metodo aggiorna lo status di un User, recuperandolo attraverso l'id
     * @param id
     * @param recordStatusEnum
     * @return l'User con stato aggiornato (se presente) oppure ritorna Optional.empty
     */
    public Optional<User> updateUserRecordStatus(Long id, RecordStatusEnum recordStatusEnum) {
        Optional<User> userOptional = getUserById(id);
        if(userOptional.isPresent()) {
            userOptional.get().setRecordStatus(recordStatusEnum);
            User savedUser = userRepository.save(userOptional.get());
            return Optional.of(savedUser);
        } else {
            return Optional.empty();
        }
    }

    /**
     * questo metodo elimina un User, recuperandolo attraverso il suo id
     * @param id
     * @return l'User appena eliminato (se presente) oppure ritorna Optional.empty
     */
    public Optional<User> deleteUserById(Long id){
        Optional<User> userOptional = getUserById(id);
        if(userOptional.isPresent()){
            userRepository.deleteById(userOptional.get().getId());
            return Optional.of(userOptional.get());
        } else {
            return Optional.empty();
        }
    }
}
