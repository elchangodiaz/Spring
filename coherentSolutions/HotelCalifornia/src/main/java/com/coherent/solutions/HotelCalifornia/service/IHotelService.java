package com.coherent.solutions.HotelCalifornia.service;

import com.coherent.solutions.HotelCalifornia.model.RegistryRequest;
import com.coherent.solutions.HotelCalifornia.model.RegistryResponse;
import reactor.core.publisher.Mono;

public interface IHotelService {

    Mono<RegistryResponse> registryGuest(RegistryRequest request);

}
