package com.example.meetuteam2.services;

import com.example.meetuteam2.entities.Booking;
import com.example.meetuteam2.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;


    public Booking createBooking(Booking booking){
        bookingRepository.save(booking);
        return booking;
    }

    public List<Booking> bookingList (){
        return bookingRepository.findAll();
    }
}
