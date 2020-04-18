package com.cottonfactory.products.controllers;

import com.cottonfactory.products.entities.Pants;
import com.cottonfactory.products.services.PantsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PantsController {

    @Autowired
    PantsService pantsService;

    @GetMapping("/api/pants")
    public List<Pants> getAll(){
        return pantsService.getAll();
    }

    @PostMapping("/api/pants")
    public Pants save(@RequestBody Pants pants){
        return pantsService.save(pants);

    }

    @GetMapping("/api/pants/{id}")
    public Pants getById(@PathVariable Long id){
        return pantsService.getById(id);
    }

    @DeleteMapping("/api/pants/{id}")
    public boolean deleteById(@PathVariable Long id){
        return pantsService.deleteById(id);
    }

}
