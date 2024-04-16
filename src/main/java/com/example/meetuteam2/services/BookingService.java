package com.example.meetuteam2.services;
import com.example.meetuteam2.DTO.BookingDTO;
import com.example.meetuteam2.entities.Booking;
import com.example.meetuteam2.entities.Experience;
import com.example.meetuteam2.entities.User;
import com.example.meetuteam2.entities.enums.RecordStatusEnum;
import com.example.meetuteam2.repositories.BookingRepository;
import com.example.meetuteam2.repositories.ExperienceRepository;
import com.example.meetuteam2.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ExperienceRepository experienceRepository;


    /**
     * questo metodo chiede un bookingDTO e la trasforma in Booking Entity per poi salvarla.crea una nuova prenotazione
     *
     * @param experienceId
     * @param bookingDTO
     * @return booking fatta
     * @author SS
     */
    public Optional<BookingDTO> addBooking(Long userId, Long experienceId, BookingDTO bookingDTO){
        Optional<User> userOptional = userRepository.findById(userId);
        Optional<Experience> experienceOptional= experienceRepository.findById(experienceId);
        if(userOptional.isPresent() && experienceOptional.isPresent()){
            Booking booking = new Booking();

            booking.setName(bookingDTO.getName());
            booking.setDescription(bookingDTO.getDescription());
            booking.setUser(userOptional.get());
            booking.setExperience(experienceOptional.get());

            Booking savedBooking = bookingRepository.save(booking);

            BookingDTO bookingResponseDTO = new BookingDTO();
            bookingResponseDTO.setId(savedBooking.getId());
            bookingResponseDTO.setName(savedBooking.getName());
            bookingResponseDTO.setDescription(savedBooking.getDescription());
            return Optional.of(bookingResponseDTO);
        }else{
            return Optional.empty();
        }
    }



    /**
     * questo metodo ritorna la lista degli BookingDto attivi
     * e dentro cicla per inserire all'interno della lista bookingDTO utilizzando gli oggetti presenti
     * nella lista di Booking richiesta
     * @return lista degli Booking attivi
     */
    public List<BookingDTO> bookingList(){
        List<Booking> bookingList = bookingRepository.findAllActiveBooking();
        List<BookingDTO> bookingDTOS = new ArrayList<>();
        for(Booking booking : bookingList){

            BookingDTO bookingResponseDTO = new BookingDTO();

            bookingResponseDTO.setId(booking.getId());
            bookingResponseDTO.setName(booking.getName());
            bookingResponseDTO.setDescription(booking.getDescription());
            bookingDTOS.add(bookingResponseDTO);
        }

        return bookingDTOS;
    }


    /**
     * questo metodo recupera un BookingDTO tramitte la  sua id e li assegna i parametri della Booking recuperata
     * @param id
     * @return Booking trovato (se presente) oppure non ritorna niente.
     */

    public Optional<BookingDTO> findBookingById(Long id){
       Optional<Booking> optionalBooking = bookingRepository.findById(id);
       if(optionalBooking.isPresent()){

           BookingDTO bookingResponseDTO = new BookingDTO();

           bookingResponseDTO.setId(optionalBooking.get().getId());
           bookingResponseDTO.setName(optionalBooking.get().getName());
           bookingResponseDTO.setDescription(optionalBooking.get().getDescription());
           return Optional.of(bookingResponseDTO);

       } else{
           return Optional.empty();
       }

    }
    /**
     * questo metodo ti permette aggiornare i field selezionati di un BookingDTO, recuperandolo attraverso l'id,cosi avere
     * una Booking aggiornata
     * @param id
     * @param bookingDTO
     * @return Booking aggiornato (se presente) oppure non ritorna niente
     */
    public Optional<BookingDTO> updateBooking(BookingDTO bookingDTO,Long id){
        Optional<Booking> optionalBooking= bookingRepository.findById(id);
        if (optionalBooking.isPresent()){
            optionalBooking.get().setName(bookingDTO.getName());
            optionalBooking.get().setDescription(bookingDTO.getDescription());

            Booking savedBooking = bookingRepository.save(optionalBooking.get());

            BookingDTO bookingResponseDTO = new BookingDTO();

            bookingResponseDTO.setId(savedBooking.getId());
            bookingResponseDTO.setName(savedBooking.getName());
            bookingResponseDTO.setDescription(savedBooking.getDescription());
            return Optional.of(bookingResponseDTO);
        }else {
            return Optional.empty();
        }

    }
    /**
     * questo metodo aggiorna lo status di una Booking in deleted, recuperandolo attraverso l'id
     * crea e ritorna una BookingDTO con i medesimi dati della Booking aggiornata
     * @param id
     * @return il Booking con stato aggiornato, se presente, oppure non ritorna niente.
     */
    public Optional<BookingDTO> deleteBookingRecordStatus(Long id){
        Optional<Booking> bookingOptional = bookingRepository.findById(id);
        if(bookingOptional.isPresent()){
            bookingOptional.get().setRecordStatus(RecordStatusEnum.D);
            Booking booking = bookingRepository.save(bookingOptional.get());
            BookingDTO bookingResponseDto= new BookingDTO();

            bookingResponseDto.setId(booking.getId());
            bookingResponseDto.setName(booking.getName());
            bookingResponseDto.setDescription(booking.getDescription());

            return Optional.of(bookingResponseDto);
        }else {
            return Optional.empty();
        }
    }


}
