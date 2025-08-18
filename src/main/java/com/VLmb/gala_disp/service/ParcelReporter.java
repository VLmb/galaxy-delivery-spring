package com.VLmb.gala_disp.service;

import com.VLmb.gala_disp.entity.Parcel;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Supplier;

@Configuration
@AllArgsConstructor
public class ParcelReporter {

    private final DeliveryService deliveryService;

    @Bean
    Supplier<Iterable<Parcel>> reportNewParcels() {
        return () -> {
             return deliveryService.findAndPrepareNewParcels();
        };
    }
}
