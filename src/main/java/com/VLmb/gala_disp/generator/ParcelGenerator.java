package com.VLmb.gala_disp.generator;

import com.VLmb.gala_disp.service.DeliveryService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@AllArgsConstructor
public class ParcelGenerator {

    private final DeliveryService deliveryService;
    private final Random random = new Random();

    private static final String[] DESTINATIONS = {
            "Mars, Elysium Planitia",
            "Titan, Kraken Mare",
            "Europa, Conamara Chaos",
            "Colony 'New Shenzhen', Proxima Centauri b",
            "Ganymede, Galileo Regio",
            "Alpha Station, Alpha Centauri A",
            "Kepler-442b, Emerald Basin",
            "Luna, Shackleton Crater",
            "Enceladus, Samarkand Sulci",
            "Vulcan Outpost, 40 Eridani A"
    };

    @Scheduled(fixedRate = 20000)
    public void generateParcel() {
        String destination = DESTINATIONS[random.nextInt(DESTINATIONS.length)];
        double weight = 0.1 + (49.9 * random.nextDouble());
        weight = Math.round(weight * 10.0) / 10.0;
        deliveryService.registerNewParcel(destination, weight);
    }

}
