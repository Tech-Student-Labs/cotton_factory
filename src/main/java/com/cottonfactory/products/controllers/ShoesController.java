package com.cottonfactory.products.controllers;

import com.cottonfactory.products.entities.Shoes;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/shoes")
public class ShoesController {
    @PostMapping
    public Shoes createShoes(Shoes shoes) {
        return shoes;
    }

}