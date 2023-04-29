package com.coherent.solutions.HotelCalifornia.controller;

import com.coherent.solutions.HotelCalifornia.model.RegistryRequest;
import com.coherent.solutions.HotelCalifornia.service.IRegistryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("hotel")
public class RegistryController {

    @Autowired
    IRegistryService service;

    @PostMapping(value = "/registry",
                produces = {"application/json"},
                consumes = {"application/json"})
    public Mono<ResponseEntity<Object>> excecuteRegistry(
        final ServerWebExchange exchange,
        @RequestHeader(value = "Auth", required = true) String auth,
        @RequestBody(required = true) RegistryRequest request) {

        long initialMillis = System.currentTimeMillis();

        return service.registryGuest(request)
                .map(registryResponse -> {
                    log.info("Time response RegisterGuest {}", initialMillis);
                    log.info("RegisterGuest Response {}", registryResponse.toString());
                    return new ResponseEntity<>(registryResponse, HttpStatus.CREATED);
                });
    }
}
