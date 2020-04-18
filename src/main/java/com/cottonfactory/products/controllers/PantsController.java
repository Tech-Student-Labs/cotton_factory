package com.cottonfactory.products.controllers;

import com.cottonfactory.products.entities.Pants;
import com.cottonfactory.products.services.PantsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PantsController {

    @Autowired
    PantsService pantsService;

    @GetMapping("/api/pants")
    public List<Pants> getAllPants(){
        return pantsService.getAll();
    }

}
