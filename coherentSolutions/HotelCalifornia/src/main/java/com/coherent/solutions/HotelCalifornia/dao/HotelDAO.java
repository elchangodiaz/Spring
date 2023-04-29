package com.coherent.solutions.HotelCalifornia.dao;

import com.coherent.solutions.HotelCalifornia.model.Guest;
import com.coherent.solutions.HotelCalifornia.model.Hospitality;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Repository
public class HotelDAO implements IHotelDAO{

    @Override
    public Optional<Boolean> roomAvailable(Guest guest){

        return dbHospitalityBuilder().stream()
                .filter(hospitality -> hospitality.getRoom().equals(guest.getRoom()))
                .findFirst().filter(Hospitality::isAvailable).map(hospitality -> hospitality.isAvailable());

    }


    @Override
    public Mono<Boolean> saveGuestReservation(Guest guest){

        //TODO ADD an ID to guest
        SecureRandom secureRandom = new SecureRandom();

        dbGuestBuilder().add(guest);

        log.info("Registration {}", dbGuestBuilder());

        return Mono.just(true);

    }


    private Set<Hospitality> dbHospitalityBuilder(){
        Hospitality h1 = new Hospitality(1, 1200.50, "basic", false);
        Hospitality h2 = new Hospitality(2, 2200, "pro", true);
        Hospitality h3 = new Hospitality(3, 5000, "suite", false);
        Hospitality h4 = new Hospitality(4, 1200.50, "basic", true);

        Set<Hospitality> hospitalityDB = new HashSet<>();

        hospitalityDB.addAll(Arrays.asList(h1, h2, h3, h4));

        return hospitalityDB;
    }

    private Set<Guest> dbGuestBuilder(){
        Set<Guest> guestsDB = new HashSet<>();

        return guestsDB;
    }


}
