package com.coherent.solutions.HotelCalifornia.service;

import com.coherent.solutions.HotelCalifornia.dao.IHotelDAO;
import com.coherent.solutions.HotelCalifornia.model.RegistryRequest;
import com.coherent.solutions.HotelCalifornia.model.RegistryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import static com.coherent.solutions.HotelCalifornia.validation.RegistryValidation.validateRequest;

@Service
public class HotelService implements IHotelService {

    @Autowired
    IHotelDAO iHotelDAO;

    public Mono<RegistryResponse> registryGuest(RegistryRequest request) {

        return validateRequest(request.getGuest())
                .map(aBoolean -> {
                    return iHotelDAO.roomAvailable(request.getGuest())
                            .map(available -> iHotelDAO.saveGuestReservation(request.getGuest()));
                }).map(booleanMono -> new RegistryResponse());


    }


}
