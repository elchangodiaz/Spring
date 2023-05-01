package com.coherent.solutions.HotelCalifornia.service;

import com.coherent.solutions.HotelCalifornia.dao.IHotelDAO;
import com.coherent.solutions.HotelCalifornia.model.GetGuestRequest;
import com.coherent.solutions.HotelCalifornia.model.Guest;
import com.coherent.solutions.HotelCalifornia.model.RegistryRequest;
import com.coherent.solutions.HotelCalifornia.model.RegistryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.function.Function;

import static com.coherent.solutions.HotelCalifornia.validation.RegistryValidation.validateRequest;

@Service
public class HotelService implements IHotelService {

    @Autowired
    IHotelDAO iHotelDAO;

    public Mono<Integer> registryGuest(RegistryRequest request) {

        return validateRequest(request.getGuest())
                .map(aBoolean -> {
                            return iHotelDAO.roomAvailable(request.getGuest());
                }).flatMap(available -> {
                    return iHotelDAO.saveGuestReservation(request.getGuest());
                }).map(o -> o);
    }


    public Mono<Guest> getGuest(GetGuestRequest request) {

        return iHotelDAO.getReservation(request.getId());

    }


}
