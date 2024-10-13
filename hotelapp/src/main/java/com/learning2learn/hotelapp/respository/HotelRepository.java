package com.learning2learn.hotelapp.respository;

import com.learning2learn.hotelapp.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface HotelRepository extends JpaRepository<Hotel, Long> {
}
