package com.coherent.solutions.HotelCalifornia.validation;

import com.coherent.solutions.HotelCalifornia.model.Reservation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.ObjectUtils;
import reactor.core.publisher.Mono;

@Slf4j
public class RegistryValidation {

    public static Mono<Boolean> validateRequest(Reservation reservation){

        if(ObjectUtils.isEmpty(reservation)){
            throw new RuntimeException("Guest is required");
        }

        if(!StringUtils.isAlphanumericSpace(reservation.getName())){
            throw new RuntimeException("Guest name bad format");
        }

        if(reservation.getRoom()>100){
            throw new RuntimeException("Guest must choose a valid room");
        }

        if(reservation.getReservationDates().isEmpty()){
            throw new RuntimeException("Guest must choose at least one reservationDate");
        }

        return Mono.just(true);

    }

}
