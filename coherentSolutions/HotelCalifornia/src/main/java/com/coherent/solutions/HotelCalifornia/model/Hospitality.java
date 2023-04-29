package com.coherent.solutions.HotelCalifornia.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
public class Hospitality {

    private Integer room;

    private double mount;

    private String type;

    private boolean available;

}
