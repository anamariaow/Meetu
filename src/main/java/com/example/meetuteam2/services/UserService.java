package com.example.meetuteam2.services;

import com.example.meetuteam2.DTO.UserRequestDTO;
import com.example.meetuteam2.DTO.UserResponseDTO;
import com.example.meetuteam2.entities.Meets;
import com.example.meetuteam2.entities.User;
import com.example.meetuteam2.entities.enums.RecordStatusEnum;
import com.example.meetuteam2.repositories.MeetsRepository;
import com.example.meetuteam2.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MeetsRepository meetsRepository;
    @Autowired
    private FileStorageService fileStorageService;

    /**
     * questo metodo richiede un UserDTO, lo trasforma in User Entity per poi salvarlo.
     * crea e poi ritorna un UserDTO come response utilizzando i dati dell'User Entity appena salvato
     *
     * @param userRequestDTO
     * @return UserDTO creato.
     * @author ET
     */
    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {
        Meets meets = new Meets();
        meets.setQuantity(5);
        meets.setReleaseDate(LocalDateTime.now());
        meets.setRecordStatus(RecordStatusEnum.A);
        Meets savedMeets = meetsRepository.save(meets);

        User user = new User();
        user.setName(userRequestDTO.getName());
        user.setEmail(userRequestDTO.getEmail());
        user.setPassword(userRequestDTO.getPassword());
        user.setMoreInfo(user.getMoreInfo());
        user.setInterestEnumList(userRequestDTO.getInterestEnumList());
        user.setMoreInfo(userRequestDTO.getMoreInfo());
        user.setGenderEnum(userRequestDTO.getGenderEnum());
        user.setZodiacSignEnum(userRequestDTO.getZodiacSignEnum());
        user.setOrientationEnum(userRequestDTO.getOrientationEnum());
        user.setRecordStatus(RecordStatusEnum.A);
        user.setMeets(savedMeets);

        User savedUser = userRepository.save(user);

        UserResponseDTO userResponseDTO = new UserResponseDTO();

        userResponseDTO.setId(savedUser.getId());
        userResponseDTO.setName(savedUser.getName());
        userResponseDTO.setEmail(savedUser.getEmail());
        userResponseDTO.setMoreInfo(savedUser.getMoreInfo());
        userResponseDTO.setInterestEnumList(savedUser.getInterestEnumList());
        userResponseDTO.setGenderEnum(savedUser.getGenderEnum());
        userResponseDTO.setZodiacSignEnum(savedUser.getZodiacSignEnum());
        userResponseDTO.setOrientationEnum(savedUser.getOrientationEnum());

        return userResponseDTO;
    }

    /**
     * questo metodo richiede la lista degli User attivi.
     * crea una lista di UserDTO
     * cicla per inserire all'interno della lista gli UserDTO utilizzando gli oggetti presenti nella lista di User richiesta.
     *
     * @return lista degli UserDTO attivi
     * @author ET
     */
    public List<UserResponseDTO> getAllActiveUsers() {
        List<User> userList = userRepository.findAllActiveUsers();
        List<UserResponseDTO> userDTOList = new ArrayList<>();
        for (User user : userList) {
            UserResponseDTO userResponseDTO = new UserResponseDTO();

            userResponseDTO.setId(user.getId());
            userResponseDTO.setName(user.getName());
            userResponseDTO.setEmail(user.getEmail());
            userResponseDTO.setMoreInfo(user.getMoreInfo());
            userResponseDTO.setInterestEnumList(user.getInterestEnumList());
            userResponseDTO.setGenderEnum(user.getGenderEnum());
            userResponseDTO.setZodiacSignEnum(user.getZodiacSignEnum());
            userResponseDTO.setOrientationEnum(user.getOrientationEnum());

            userDTOList.add(userResponseDTO);
        }
        return userDTOList;
    }

    /**
     * questo metodo recupera un User partendo dalla sua id, se presente crea e ritorna un User DTO
     * e gli assegna i parametri dell'User recuperato.
     *
     * @param id
     * @return l'UserDTO con i dati dell'User recuperato.
     * @author ET
     */
    public Optional<UserResponseDTO> getUserById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            UserResponseDTO userResponseDTO = new UserResponseDTO();

            userResponseDTO.setId(userOptional.get().getId());
            userResponseDTO.setName(userOptional.get().getName());
            userResponseDTO.setEmail(userOptional.get().getEmail());
            userResponseDTO.setMoreInfo(userOptional.get().getMoreInfo());
            userResponseDTO.setInterestEnumList(userOptional.get().getInterestEnumList());
            userResponseDTO.setGenderEnum(userOptional.get().getGenderEnum());
            userResponseDTO.setZodiacSignEnum(userOptional.get().getZodiacSignEnum());
            userResponseDTO.setOrientationEnum(userOptional.get().getOrientationEnum());

            return Optional.of(userResponseDTO);
        } else {
            return Optional.empty();
        }
    }

    /**
     * questo metodo aggiorna i field selezionati di un User, recuperandolo attraverso l'id
     * crea e ritorna un UserDTO con i dati dell'User aggiornato
     *
     * @param id
     * @param userDTO
     * @return l'UserDTO aggiornato (se presente) oppure ritorna Optional.empty
     * @author ET
     */
    public Optional<UserResponseDTO> updateUserById(Long id, UserRequestDTO userDTO) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            userOptional.get().setName(userDTO.getName());
            userOptional.get().setEmail(userDTO.getEmail());
            userOptional.get().setPassword(userDTO.getPassword());
            userOptional.get().setMoreInfo(userDTO.getMoreInfo());
            userOptional.get().setInterestEnumList(userDTO.getInterestEnumList());
            userOptional.get().setGenderEnum(userDTO.getGenderEnum());
            userOptional.get().setZodiacSignEnum(userDTO.getZodiacSignEnum());
            userOptional.get().setOrientationEnum(userDTO.getOrientationEnum());

            User savedUser = userRepository.save(userOptional.get());

            UserResponseDTO userResponseDTO = new UserResponseDTO();

            userResponseDTO.setId((savedUser.getId()));
            userResponseDTO.setName(savedUser.getName());
            userResponseDTO.setEmail(savedUser.getEmail());
            userResponseDTO.setMoreInfo(savedUser.getMoreInfo());
            userResponseDTO.setInterestEnumList(savedUser.getInterestEnumList());
            userResponseDTO.setGenderEnum(savedUser.getGenderEnum());
            userResponseDTO.setZodiacSignEnum(savedUser.getZodiacSignEnum());
            userResponseDTO.setOrientationEnum(savedUser.getOrientationEnum());

            return Optional.of(userResponseDTO);
        } else {
            return Optional.empty();
        }
    }

    /**
     * questo metodo aggiorna lo status di un User in "deleted", recuperandolo attraverso l'id
     * crea e ritorna un UserDTO con i medesimi dati dell'User aggiornato
     *
     * @param id
     * @return l'UserDTO con stato aggiornato (se presente) oppure ritorna un Optional vuoto.
     * @author ET
     */
    public Optional<UserResponseDTO> updateUserRecordStatus(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            userOptional.get().setRecordStatus(RecordStatusEnum.D);

            User savedUser = userRepository.save(userOptional.get());

            UserResponseDTO userResponseDTO = new UserResponseDTO();

            userResponseDTO.setId(savedUser.getId());
            userResponseDTO.setName(savedUser.getName());
            userResponseDTO.setEmail(savedUser.getEmail());
            userResponseDTO.setMoreInfo(savedUser.getMoreInfo());
            userResponseDTO.setInterestEnumList(savedUser.getInterestEnumList());
            userResponseDTO.setGenderEnum(savedUser.getGenderEnum());
            userResponseDTO.setZodiacSignEnum(savedUser.getZodiacSignEnum());
            userResponseDTO.setOrientationEnum(savedUser.getOrientationEnum());

            return Optional.of(userResponseDTO);
        } else {
            return Optional.empty();
        }
    }
    public Optional<String> addProfilePicture(Long id, MultipartFile picture) throws IOException {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            userOptional.get().setProfilePicture(fileStorageService.uploadFirebase(picture));
            userRepository.save(userOptional.get());
            return Optional.of("profile picture succesfully added!");
        } else {
            return Optional.empty();
        }
    }
}
