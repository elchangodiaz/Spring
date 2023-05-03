package com.coherent.solutions.HotelCalifornia.dao;

import com.coherent.solutions.HotelCalifornia.model.Hospitality;
import com.coherent.solutions.HotelCalifornia.model.RegistryRequest;
import com.coherent.solutions.HotelCalifornia.model.Reservation;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

public interface IHotelDAO {

    //Optional<Boolean> roomAvailable(Reservation reservation);

    Mono<String> saveReservation(RegistryRequest request);

    Mono<Reservation> getReservation(String id);

    Mono<String> updateReservation(RegistryRequest request);

    Mono<String> deleteReservation(String id);

    Mono<String> createRoom();

    Mono<List<Reservation>> getAllReservations();

}
