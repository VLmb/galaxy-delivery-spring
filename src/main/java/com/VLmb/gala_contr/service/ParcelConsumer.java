//package com.VLmb.gala_contr.service;
//
//import com.VLmb.gala_contr.entity.Parcel;
//import com.VLmb.gala_contr.repository.ParcelRepository;
//import lombok.AllArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.List;
//import java.util.function.Consumer;
//
//@Configuration
//@AllArgsConstructor
//public class ParcelConsumer {
//
//    private final ParcelRepository parcelRepository;
//
//    @Bean
//    Consumer<List<Parcel>> consumeNewParcel() {
//        return parcels -> {
//            for (Parcel parcel: parcels) {
//                Parcel newParcel = new Parcel(parcel.getTrackingNumber(), parcel.getWeight(),
//                        parcel.getDestination(), parcel.getStatus(), parcel.getCreatedAt());
//                parcelRepository.save(newParcel);
//            }
//        };
//    }
//}
