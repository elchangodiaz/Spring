package com.coherent.solutions.HotelCalifornia.dao;

import com.coherent.solutions.HotelCalifornia.model.Guest;
import com.coherent.solutions.HotelCalifornia.model.Hospitality;
import com.coherent.solutions.HotelCalifornia.model.RegistryResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.security.SecureRandom;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

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
    public Mono<Guest> getReservation(String id){

        return Mono.just(dbGuestBuilder().stream()
                .filter(guest -> guest.getId().equals(id))
                .findFirst().orElse(new Guest()));

    }


    @Override
    public Mono<Integer> saveGuestReservation(Guest guest){

        //TODO ADD an ID to guest
        //guest.setId(UUID.randomUUID().toString());
        final AtomicInteger count = new AtomicInteger(0);
        guest.setId(count.incrementAndGet());

        dbGuestBuilder().add(guest);

        log.info("Registration {}", dbGuestBuilder());

        return Mono.just(guest.getId());

    }


    private Set<Hospitality> dbHospitalityBuilder(){
        //synchronized () {
            Hospitality h1 = new Hospitality(1, 1200.50, "basic", false);
            Hospitality h2 = new Hospitality(2, 2200, "pro", true);
            Hospitality h3 = new Hospitality(3, 5000, "suite", false);
            Hospitality h4 = new Hospitality(4, 1200.50, "basic", true);

            final Set<Hospitality> hospitalityDB = new HashSet<>();

            hospitalityDB.addAll(Arrays.asList(h1, h2, h3, h4));

            return hospitalityDB;
  //      }
    }

    private Set<Guest> dbGuestBuilder(){
        Set<Guest> guestsDB = new HashSet<>();

        return guestsDB;
    }


}
