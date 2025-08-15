package com.VLmb.gala_disp.controller;

import com.VLmb.gala_disp.service.DeliveryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
@AllArgsConstructor
public class ParcelController {

    private final DeliveryService deliveryService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("parcels", deliveryService.getAllParcels());
        return "index";
    }

    // Обновляем метод, чтобы он принимал и вес
    @PostMapping("/add")
    public String addParcel(@RequestParam String destination, @RequestParam double weight) {
        deliveryService.registerNewParcel(destination, weight);
        return "redirect:/";
    }

}
