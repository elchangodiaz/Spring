package com.coherent.solutions.HotelCalifornia.dao;

import com.coherent.solutions.HotelCalifornia.config.FirebaseInitializer;
import com.coherent.solutions.HotelCalifornia.model.RegistryRequest;
import com.coherent.solutions.HotelCalifornia.model.Reservation;
import com.coherent.solutions.HotelCalifornia.model.Hospitality;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Repository
public class HotelDAO implements IHotelDAO{

    //TODO UPDATE ROOM STATUS

    public static final String COL_RESERVATIONS="reservations";

    public static final String COL_HOSPITALITY="hospitality";

    @Override
    public Mono<Reservation> getReservation(String id){

        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection(COL_RESERVATIONS).document(id);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        try {
            DocumentSnapshot document = null;
                document = future.get();


            Reservation reservation = null;

            if(document.exists()) {
                reservation = document.toObject(Reservation.class);
                return Mono.just(reservation);
            }else {
                return null;
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }


    public Mono<List<Reservation>> getAllReservations(){

        List<Reservation> reservations = new ArrayList<>();

        Firestore dbFirestore = FirestoreClient.getFirestore();
        dbFirestore.collection(COL_RESERVATIONS).listDocuments().forEach(documentReference -> {
            ApiFuture<DocumentSnapshot> future = documentReference.get();

            DocumentSnapshot document = null;
            try {
                document = future.get();

                Reservation reservation = null;

                if(document.exists()) {
                    reservation = document.toObject(Reservation.class);
                    reservations.add(reservation);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        });
        return Mono.just(reservations);
    }


    @Override
    public Mono<String> saveReservation(RegistryRequest request){

        if(roomAvailable(request.getReservation().getRoom())) {

            UUID uuid = UUID.randomUUID();
            String uuidAsString = uuid.toString();
            request.getReservation().setId(uuidAsString);

            Reservation reservation = request.getReservation();

            try {

                Firestore firestore = FirestoreClient.getFirestore();
                ApiFuture<WriteResult> apiFuture = firestore.collection(COL_RESERVATIONS)
                        .document(reservation.getId().toString())
                        .set(reservation);

                if (apiFuture.get() != null) {
                    return Mono.just(reservation.getId());
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
            return Mono.just("NO AVAILABLE");
        } else return Mono.just("NO AVAILABLE");
    }


    @Override
    public Mono<String> updateReservation(RegistryRequest request) {

        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COL_RESERVATIONS)
                .document(request.getReservation().getId()).set(request.getReservation());
        try {
            return Mono.just(collectionsApiFuture.get().getUpdateTime().toString());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    public Mono<String> deleteReservation(String id) {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResult = dbFirestore.collection(COL_RESERVATIONS)
                .document(id.toString()).delete();

        return Mono.just("Document with ReservationID "+id+" has been deleted");
    }



    private Boolean roomAvailable(Integer room){

        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection(COL_HOSPITALITY)
                .document(room.toString());
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        try {
            DocumentSnapshot document = null;
            document = future.get();


            Hospitality hospitality = null;

            if(document.exists()) {
                hospitality = document.toObject(Hospitality.class);
                return hospitality.isAvailable();
            }else {
                return false;
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Mono<String> createRoom(){

            Hospitality h1 = new Hospitality(1, 1200.50, "basic", false);
            Hospitality h2 = new Hospitality(2, 2200, "pro", true);
            Hospitality h3 = new Hospitality(3, 5000, "suite", false);
            Hospitality h4 = new Hospitality(4, 1200.50, "basic", true);

            final Set<Hospitality> hospitalityDB = new HashSet<>();

            hospitalityDB.addAll(Arrays.asList(h1, h2, h3, h4));

            for (Hospitality h:hospitalityDB) {
                Firestore firestore = FirestoreClient.getFirestore();

                ApiFuture<WriteResult> apiFuture = firestore.collection(COL_HOSPITALITY)
                        .document(h.getRoom().toString())
                        .set(h);
            }
        return null;
    }

}
