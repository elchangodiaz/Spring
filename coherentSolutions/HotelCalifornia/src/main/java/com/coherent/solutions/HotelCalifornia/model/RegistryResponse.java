package com.coherent.solutions.HotelCalifornia.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
@Data
public class RegistryResponse {

    private String guestId;

    private String message;

    private String status;

    private String error;

}
