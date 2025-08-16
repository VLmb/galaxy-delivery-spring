package com.VLmb.gala_contr.service;

import com.VLmb.gala_contr.entity.Parcel;
import com.VLmb.gala_contr.repository.ParcelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class LogisticService {

    public final ParcelRepository parcelRepository;
    public final WebClient dispWebClient;

    public Iterable<Parcel> getAllParcelsForDisplay() {
        return parcelRepository.findAll();
    }

    @Scheduled(fixedRate = 10000)
    public void fetchNewParcels() {
        Flux<Parcel> newParcelsFlux = dispWebClient.get()
                .uri("/api/parcels/new")
                .retrieve()
                .bodyToFlux(Parcel.class);

        newParcelsFlux.toIterable().forEach(parcel -> {
            parcelRepository.save(parcel);
        });
    }
}
