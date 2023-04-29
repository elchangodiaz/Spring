package com.coherent.solutions.HotelCalifornia.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class Guest {

    @JsonIgnore
    private Integer id;

    private String name;

    private Integer room;

    private List<LocalDate> reservationDates;

    private List<String> extras;

}
