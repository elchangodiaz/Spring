package com.coherent.solutions.HotelCalifornia.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Hospitality {

    private Integer room;

    private double mount;

    private String type;

    private boolean available;

}
