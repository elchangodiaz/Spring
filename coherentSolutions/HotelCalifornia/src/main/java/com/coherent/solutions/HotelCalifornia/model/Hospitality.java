package com.coherent.solutions.HotelCalifornia.model;

import lombok.Data;

import java.util.List;

@Data
public class Hospitality {

    private Integer room;

    private long mount;

    private String type;

    private List<String> extras;


}
