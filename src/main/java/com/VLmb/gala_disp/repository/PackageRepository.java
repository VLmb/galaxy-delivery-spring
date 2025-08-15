package com.VLmb.gala_disp.repository;

import com.VLmb.gala_disp.entity.Parcel;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PackageRepository extends CrudRepository<Parcel, Long> {
    Optional<Parcel> findByTrackingNumber(String trackingNumber);
}
