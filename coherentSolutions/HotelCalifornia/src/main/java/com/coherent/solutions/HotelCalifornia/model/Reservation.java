package com.coherent.solutions.HotelCalifornia.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Reservation {

    @JsonIgnore
    private String id;

    private String name;

    private Integer room;

    private List<String> reservationDates;
    //private List<LocalDate> reservationDates;

    private List<String> extras;

}
