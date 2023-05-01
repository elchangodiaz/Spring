package com.coherent.solutions.HotelCalifornia.dao;

import com.coherent.solutions.HotelCalifornia.model.Guest;
import com.coherent.solutions.HotelCalifornia.model.RegistryResponse;
import reactor.core.publisher.Mono;

import java.util.Optional;

public interface IHotelDAO {

    Optional<Boolean> roomAvailable(Guest guest);

    Mono<Integer> saveGuestReservation(Guest guest);

    Mono<Guest> getReservation(String id);

}
