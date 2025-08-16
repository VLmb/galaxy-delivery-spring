package com.VLmb.gala_disp.service;

import com.VLmb.gala_disp.entity.Parcel;
import com.VLmb.gala_disp.repository.ParcelRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class DeliveryService {

    private final ParcelRepository repo;

    public Parcel registerNewParcel(String destination, double weight) {
        String trackingNumber = "GD-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        return repo.save(new Parcel(trackingNumber, weight, destination, "ACCEPTED"));
    }

    public Iterable<Parcel> getAllParcels() {
        return repo.findAll();
    }
    public Optional<Parcel> findByTrackingNumber(String trackingNumber) {
        return repo.findByTrackingNumber(trackingNumber);
    }

}
