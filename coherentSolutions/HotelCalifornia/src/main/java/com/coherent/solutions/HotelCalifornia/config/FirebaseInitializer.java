package com.coherent.solutions.HotelCalifornia.config;

import com.google.auth.Credentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Service
public class FirebaseInitializer{

    @PostConstruct
    public void initializeFirebaseConection() {
        try {

            InputStream serviceAccount = getClass().getClassLoader()
                    .getResourceAsStream("hotelcalifornia-90408-firebase-adminsdk-c662k-d8c369f828.json");


            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://hotelcalifornia-90408-default-rtdb.firebaseio.com/")
                    .build();

            FirebaseApp.initializeApp(options);

            Firestore db = FirestoreClient.getFirestore();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
