package com.learning2learn.hotelapp.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

@Entity
@NoArgsConstructor
public class Hotel {

    @OneToMany
    private Long id;

    @Size(min = 2)
    private String name;
}
