package com.coherent.solutions.HotelCalifornia.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class RegistryResponse {

    private String code;

    private String message;

    private String status;

    private String error;

}
