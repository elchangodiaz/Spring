package com.coherent.solutions.HotelCalifornia.dao;

import com.coherent.solutions.HotelCalifornia.model.Guest;
import reactor.core.publisher.Mono;

import java.util.Optional;

public interface IHotelDAO {

    Optional<Boolean> roomAvailable(Guest guest);

    Mono<Boolean> saveGuestReservation(Guest guest);

}
