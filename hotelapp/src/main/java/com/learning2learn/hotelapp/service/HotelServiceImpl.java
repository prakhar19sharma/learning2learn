package com.learning2learn.hotelapp.service;

import com.learning2learn.hotelapp.model.Hotel;
import com.learning2learn.hotelapp.respository.HotelRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Optional;

@Service
@AllArgsConstructor
public class HotelServiceImpl {
    private final HotelRepository repository;

    public Hotel findHotelById(Long id) {
        Optional<Hotel> hotel =  repository.findById(id);
        if(hotel.isPresent()) {
            return hotel.get();
        } else throw new RuntimeException("Not found");
    }
}
