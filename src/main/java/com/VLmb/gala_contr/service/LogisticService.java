package com.VLmb.gala_contr.service;

import com.VLmb.gala_contr.entity.Parcel;
import com.VLmb.gala_contr.repository.ParcelRepository;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

@Service
@RequiredArgsConstructor
public class LogisticService {

    public final ParcelRepository parcelRepository;
    private final Random random = new Random();
//    public final WebClient dispWebClient;

    public Iterable<Parcel> getAllParcelsForDisplay() {
        return parcelRepository.findAll();
    }

//    @Transactional
//    @Scheduled(fixedRate = 50000)
//    public void fetchNewParcels() {
//        Flux<Parcel> newParcelsFlux = dispWebClient.get()
//                .uri("/api/parcels/new")
//                .retrieve()
//                .bodyToFlux(Parcel.class);
//
//        newParcelsFlux.toIterable().forEach(parcel -> {
//            Parcel newParcel = new Parcel(parcel.getTrackingNumber(), parcel.getWeight(),
//                    parcel.getDestination(), parcel.getStatus(), parcel.getCreatedAt());
//            parcelRepository.save(newParcel);
//        });
//    }

    @Bean
    Consumer<List<Parcel>> consumeNewParcel() {
        return parcels -> {
            for (Parcel parcel: parcels) {
                Parcel newParcel = new Parcel(parcel.getTrackingNumber(), parcel.getWeight(),
                        parcel.getDestination(), parcel.getStatus(), parcel.getCreatedAt());
                parcelRepository.save(newParcel);
                System.out.println("===PARCEL " + parcel.getTrackingNumber() + "CREATED SUCCESSFULLY");
            }
        };
    }

    private void processParcelsWithStatus(String currentStatus, String nextStatus) {
        List<Parcel> parcels = parcelRepository.findAllByStatus(currentStatus);

        if (parcels.isEmpty()) {
            return;
        }

        for (Parcel parcel : parcels) {
            int delayInSeconds = 5 + random.nextInt(46); // nextInt(46) даст число от 0 до 45

            LocalDateTime timeThreshold = LocalDateTime.now().minusSeconds(delayInSeconds);

            if (parcel.getUpdatedAt().isBefore(timeThreshold)) {
                parcel.setStatus(nextStatus);
                parcel.setUpdatedAt(LocalDateTime.now());
                parcelRepository.save(parcel);
            }
        }
    }

    @Scheduled(fixedRate = 5000)
    @Transactional
    public void updateParcelStatuses() {

        processParcelsWithStatus("WITH COURIER", "ON THE WAY");
        processParcelsWithStatus("ON THE WAY", "ARRIVED SOON");
        processParcelsWithStatus("ARRIVED SOON", "DELIVERED");

    }

    @PostConstruct
    public void dropTable() {
        parcelRepository.deleteAll();
    }
}
