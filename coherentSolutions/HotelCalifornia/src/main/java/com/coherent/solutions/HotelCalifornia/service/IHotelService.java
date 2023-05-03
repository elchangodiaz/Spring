package com.coherent.solutions.HotelCalifornia.service;

import com.coherent.solutions.HotelCalifornia.model.GetGuestRequest;
import com.coherent.solutions.HotelCalifornia.model.Reservation;
import com.coherent.solutions.HotelCalifornia.model.RegistryRequest;
import reactor.core.publisher.Mono;

import java.util.List;

public interface IHotelService {

    Mono<String> registryGuest(RegistryRequest request);

    Mono<Reservation> getGuest(GetGuestRequest request);

    Mono<Reservation> updateGuest(RegistryRequest request);

    Mono<String> deleteGuest(GetGuestRequest request);

    Mono<List<Reservation>> getAllGuest();

}
