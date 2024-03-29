package com.coherent.solutions.HotelCalifornia.controller;

import com.coherent.solutions.HotelCalifornia.model.GetGuestRequest;
import com.coherent.solutions.HotelCalifornia.model.RegistryRequest;
import com.coherent.solutions.HotelCalifornia.model.RegistryResponse;
import com.coherent.solutions.HotelCalifornia.service.IHotelService;
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
    IHotelService service;

    @PostMapping(value = "/registry",
                produces = {"application/json"},
                consumes = {"application/json"})
    public Mono<ResponseEntity<Object>> excecuteRegistry(
        final ServerWebExchange exchange,
        @RequestHeader(value = "Auth", required = false) String auth,
        @RequestBody(required = true) RegistryRequest request) {

        long initialMillis = System.currentTimeMillis();

        return service.registryGuest(request)
                .map(response -> {
                    log.info("Time response RegisterGuest {}", initialMillis);
                    if(!response.contains("NO AVAILABLE")) {
                        return new ResponseEntity<>(new RegistryResponse(response,
                                "Registro exitoso", "Created", null), HttpStatus.CREATED);
                    } else {
                        return new ResponseEntity<>(new RegistryResponse(response,
                                "ERROR", response, "REGISTRY-ERR"), HttpStatus.BAD_REQUEST);
                    }
                });
    }


    @GetMapping(value = "/get_guest",
            produces = {"application/json"},
            consumes = {"application/json"})
    public Mono<ResponseEntity<Object>> getRegistry(
            final ServerWebExchange exchange,
            @RequestHeader(value = "Auth", required = false) String auth,
            @RequestBody(required = true) GetGuestRequest request) {

        long initialMillis = System.currentTimeMillis();

        return service.getGuest(request)
                .map(registryResponse -> {
                    log.info("Time response RegisterGuest {}", initialMillis);
                    log.info("RegisterGuest Response {}", registryResponse.toString());
                    return new ResponseEntity<>(registryResponse, HttpStatus.CREATED);
                });
    }

    @GetMapping(value = "/getAll_guest",
            produces = {"application/json"},
            consumes = {"application/json"})
    public Mono<ResponseEntity<Object>> getAllRegistry(
            final ServerWebExchange exchange,
            @RequestHeader(value = "Auth", required = false) String auth) {

        long initialMillis = System.currentTimeMillis();

        return service.getAllGuest()
                .map(registryResponse -> {
                    log.info("Time response RegisterGuest {}", initialMillis);
                    log.info("RegisterGuest Response {}", registryResponse.toString());
                    return new ResponseEntity<>(registryResponse, HttpStatus.CREATED);
                });
    }


    @PutMapping(value = "/update_guest",
            produces = {"application/json"},
            consumes = {"application/json"})
    public Mono<ResponseEntity<Object>> updateRegistry(
            final ServerWebExchange exchange,
            @RequestHeader(value = "Auth", required = false) String auth,
            @RequestBody(required = true) RegistryRequest request) {

        long initialMillis = System.currentTimeMillis();

        return service.updateGuest(request)
                .map(registryResponse -> {
                    log.info("Time response RegisterGuest {}", initialMillis);
                    log.info("RegisterGuest Response {}", registryResponse.toString());
                    return new ResponseEntity<>(registryResponse, HttpStatus.CREATED);
                });
    }


    @DeleteMapping(value = "/delete_guest",
            produces = {"application/json"},
            consumes = {"application/json"})
    public Mono<ResponseEntity<Object>> deleteRegistry(
            final ServerWebExchange exchange,
            @RequestHeader(value = "Auth", required = false) String auth,
            @RequestBody(required = true) GetGuestRequest request) {

        long initialMillis = System.currentTimeMillis();

        return service.deleteGuest(request)
                .map(registryResponse -> {
                    log.info("Time response RegisterGuest {}", initialMillis);
                    log.info("RegisterGuest Response {}", registryResponse.toString());
                    return new ResponseEntity<>(registryResponse, HttpStatus.CREATED);
                });
    }



}
