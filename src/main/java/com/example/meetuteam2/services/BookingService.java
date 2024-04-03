package com.example.meetuteam2.services;
import com.example.meetuteam2.entities.Booking;
import com.example.meetuteam2.entities.enums.RecordStatusEnum;
import com.example.meetuteam2.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;


    /**
     * questo metodo crea una nuova prenotazione
     * @param booking
     * @return booking fatta
     * @author SS
     */
    public Booking addBooking(Booking booking){
        return bookingRepository.save(booking);
    }


    /**
     * questo metodo ritorna la lista degli Booking attivi
     * @return lista degli Booking attivi
     */
    public List<Booking> bookingList(){
        return bookingRepository.findAll();
    }


    /**
     * questo metodo recupera ti permette cercare un Booking partendo dalla sua id
     * @param id
     * @return Booking trovato (se presente) oppure non ritorna niente.
     */

    public Optional<Booking> findBookingById(Long id){
        return bookingRepository.findById(id);
    }
    /**
     * questo metodo ti permette aggiornare i field selezionati di un Booking, recuperandolo attraverso l'id
     * @param id
     * @param booking
     * @return Booking aggiornato (se presente) oppure non ritorna niente
     */
    public Optional<Booking> updateBooking(Booking booking,Long id){
        Optional<Booking> optionalBooking= bookingRepository.findById(id);
        if (optionalBooking.isPresent()){
            optionalBooking.get().setName(booking.getName());
            optionalBooking.get().setDescription(booking.getDescription());
            optionalBooking.get().setUser(booking.getUser());
            optionalBooking.get().setExperience(booking.getExperience());
            optionalBooking.get().setRecordStatus(booking.getRecordStatus());
            bookingRepository.save(optionalBooking.get());
            return optionalBooking;
        }else {
            return Optional.empty();
        }

    }
    /**
     * questo metodo recupera un Booking  attraverso l'id e ne aggiorna lo status
     * @param id
     * @param recordStatusEnum
     * @return il Booking con stato aggiornato, se presente, oppure non ritorna niente.
     */
    public Optional<Booking> updateBookingRecordStatus(Long id, RecordStatusEnum recordStatusEnum){
        Optional<Booking> bookingOptional = findBookingById(id);
        if(bookingOptional.isPresent()){
            bookingOptional.get().setRecordStatus(recordStatusEnum);
            Booking booking = bookingRepository.save(bookingOptional.get());
            return Optional.of(booking);
        }else {
            return Optional.empty();
        }
    }

    /**
     * questo metodo elimina booking, recuperandolo attraverso il suo id
     * @param id
     * @return booking appena eliminato, se presente, oppure non ritorna niente.
     */
    public Optional<Booking> deleteBooking(Long id){
        Optional<Booking> optionalBooking = bookingRepository.findById(id);
        if(optionalBooking.isPresent()){
            bookingRepository.delete(optionalBooking.get());
        }else{
            return Optional.empty();
        }
        return optionalBooking;
    }
}
