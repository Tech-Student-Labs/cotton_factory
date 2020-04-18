package com.cottonfactory.products.controllers;

import com.cottonfactory.products.services.ShirtService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShirtController {
    ShirtService service;

    public ShirtController(ShirtService service) {
        this.service = service;
    }
}
