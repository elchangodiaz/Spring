package com.coherent.solutions.HotelCalifornia.service;

import com.coherent.solutions.HotelCalifornia.dao.IHotelDAO;
import com.coherent.solutions.HotelCalifornia.model.GetGuestRequest;
import com.coherent.solutions.HotelCalifornia.model.Reservation;
import com.coherent.solutions.HotelCalifornia.model.RegistryRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

import static com.coherent.solutions.HotelCalifornia.validation.RegistryValidation.validateRequest;

@Service
public class HotelService implements IHotelService {

    @Autowired
    IHotelDAO iHotelDAO;

    public Mono<String> registryGuest(RegistryRequest request) {

        return validateRequest(request.getReservation())
                .flatMap(aBoolean -> {
                    return iHotelDAO.saveReservation(request);
                }).flatMap(stringMono -> {
                            return Mono.just(stringMono);
                });

    }


    public Mono<Reservation> getGuest(GetGuestRequest request) {

        return iHotelDAO.getReservation(request.getId());

    }

    public Mono<List<Reservation>> getAllGuest() {
        return iHotelDAO.getAllReservations();
    }


    public Mono<Reservation> updateGuest(RegistryRequest request) {

        return validateRequest(request.getReservation())
                .map(aBoolean -> {
                    return iHotelDAO.saveReservation(request);
                }).flatMap(stringMono -> {
                    return Mono.just(request.getReservation());
                });
    }


    public Mono<String> deleteGuest(GetGuestRequest request) {

        return iHotelDAO.deleteReservation(request.getId());

    }

}
