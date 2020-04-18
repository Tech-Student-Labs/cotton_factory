package com.cottonfactory.products.controllers;

import com.cottonfactory.products.entities.Jacket;
import com.cottonfactory.products.services.JacketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products/jackets")
public class JacketController {
    JacketService jacketService;
    public JacketController(JacketService jacketService) {
        this.jacketService = jacketService;
    }
    @PostMapping
    public ResponseEntity<Jacket> createJacket(@RequestBody Jacket jacket) {
        Jacket saved;
        try {
            saved =  jacketService.createJacket(jacket);
        } catch(Exception e) {
            return ResponseEntity.badRequest().header("message", e.getMessage()).build();
        }
        return ResponseEntity.ok(saved);
    }

//    POST. /api/products/jackets
//    GET /api/products/jackets (list)
//    GET /api/products/jackets/:id
//    PATCH /api/products/jackets/:id
//    PUT /api/products/jackets/:id
}
