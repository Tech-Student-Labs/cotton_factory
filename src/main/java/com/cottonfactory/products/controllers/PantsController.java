package com.cottonfactory.products.controllers;

import com.cottonfactory.products.entities.Pants;
import com.cottonfactory.products.services.PantsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping("/api/pants")
    public Pants save(@RequestBody Pants pants){
        return pantsService.save(pants);

    }

}
