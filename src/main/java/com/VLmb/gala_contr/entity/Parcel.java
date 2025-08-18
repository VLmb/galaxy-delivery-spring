package com.VLmb.gala_contr.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties(value = { "id" }, allowSetters = true)
public class Parcel {

    @Id
    @GeneratedValue
    private Long id;
    private String trackingNumber;
    private  double weight;
    private String destination;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Parcel(String trackingNumber, double weight, String destination, String status, LocalDateTime createdAt) {
        this.trackingNumber = trackingNumber;
        this.weight = weight;
        this.destination = destination;
        this.status = status;
        this.updatedAt = LocalDateTime.now();
        this.createdAt = createdAt;
    }
}
