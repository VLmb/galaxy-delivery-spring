package com.VLmb.gala_contr.controller;

import com.VLmb.gala_contr.entity.Parcel;
import com.VLmb.gala_contr.service.LogisticService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class ViewController {

    private final LogisticService logisticService;

    @GetMapping("/")
    public String home(Model model) {
        Iterable<Parcel> parcels = logisticService.getAllParcelsForDisplay();

        model.addAttribute("parcels", parcels);

        return "index";
    }
}
