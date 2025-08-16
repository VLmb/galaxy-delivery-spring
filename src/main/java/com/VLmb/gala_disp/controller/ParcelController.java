package com.VLmb.gala_disp.controller;

import com.VLmb.gala_disp.entity.Parcel;
import com.VLmb.gala_disp.service.DeliveryService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parcels")
@AllArgsConstructor
public class ParcelController {

    private final DeliveryService deliveryService;

    @GetMapping
    public Iterable<Parcel> getAllParcels(){
        return deliveryService.getAllParcels();
    }

    @GetMapping("/new")
    public List<Parcel> getNewParcels() {
        return deliveryService.findAndPrepareNewParcels();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Parcel addParcel(@RequestBody ParcelCreateRequest request) {
        return deliveryService.registerNewParcel(request.getDestination(), request.getWeight());
    }

    @Data
    static class ParcelCreateRequest {
        private String destination;
        private double weight;
    }

}


