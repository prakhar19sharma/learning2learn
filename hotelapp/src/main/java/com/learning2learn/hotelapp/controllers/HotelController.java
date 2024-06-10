package com.learning2learn.hotelapp.controllers;

import com.learning2learn.hotelapp.model.Hotel;
import com.learning2learn.hotelapp.service.HotelServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.websocket.server.PathParam;
import java.net.URI;

@RestController
@RequestMapping("/hotel")
@AllArgsConstructor
public class HotelController {

    private final HotelServiceImpl hotelService;

    @GetMapping("/{id}")
    public ResponseEntity<Hotel> getHotel(@PathParam("id") Long id) {


        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
        return ResponseEntity.ok().build();
    }
}
