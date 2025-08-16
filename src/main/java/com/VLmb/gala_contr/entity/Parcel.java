package com.VLmb.gala_contr.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class Parcel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String trackingNumber;
    private  double weight;
    private String destination;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Parcel(String trackingNumber, double weight, String destination, String status) {
        this.trackingNumber = trackingNumber;
        this.weight = weight;
        this.destination = destination;
        this.status = status;
    }
}
