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
    public Booking addBooking(Booking booking){
        return bookingRepository.save(booking);
    }
    public List<Booking> bookingList(){
        return bookingRepository.findAll();
    }

    public Optional<Booking> findBookingById(Long id){
        return bookingRepository.findById(id);
    }
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
