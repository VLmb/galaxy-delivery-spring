package com.VLmb.gala_disp.repository;

import com.VLmb.gala_disp.entity.Parcel;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ParcelRepository extends CrudRepository<Parcel, Long> {
    Optional<Parcel> findByTrackingNumber(String trackingNumber);
    List<Parcel> findAllByStatus(String status);
    List<Parcel> findAllByStatusAndUpdatedAtBefore(String status, LocalDateTime time);
}
