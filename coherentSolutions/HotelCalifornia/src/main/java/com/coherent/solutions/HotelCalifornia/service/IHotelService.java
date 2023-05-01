package com.coherent.solutions.HotelCalifornia.service;

import com.coherent.solutions.HotelCalifornia.model.GetGuestRequest;
import com.coherent.solutions.HotelCalifornia.model.Guest;
import com.coherent.solutions.HotelCalifornia.model.RegistryRequest;
import com.coherent.solutions.HotelCalifornia.model.RegistryResponse;
import reactor.core.publisher.Mono;

public interface IHotelService {

    Mono<Integer> registryGuest(RegistryRequest request);

    Mono<Guest> getGuest(GetGuestRequest request);

}
