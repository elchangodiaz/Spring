package com.coherent.solutions.HotelCalifornia.validation;

import com.coherent.solutions.HotelCalifornia.model.Guest;
import com.coherent.solutions.HotelCalifornia.model.RegistryRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.ObjectUtils;
import reactor.core.publisher.Mono;

@Slf4j
public class RegistryValidation {

    public static Mono<Boolean> validateRequest(Guest guest){

        if(ObjectUtils.isEmpty(guest)){
            throw new RuntimeException("Guest is required");
        }

        if(!StringUtils.isAlphanumericSpace(guest.getName())){
            throw new RuntimeException("Guest name bad format");
        }

        if(guest.getRoom()>100){
            throw new RuntimeException("Guest must choose a valid room");
        }

        if(guest.getReservationDates().isEmpty()){
            throw new RuntimeException("Guest must choose at least one reservationDate");
        }

        return Mono.just(true);

    }

}
