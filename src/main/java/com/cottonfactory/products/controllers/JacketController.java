package com.cottonfactory.products.controllers;

import com.cottonfactory.products.entities.Jacket;
import com.cottonfactory.products.services.JacketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products/jackets")
public class JacketController {
    JacketService jacketService;
    public JacketController(JacketService jacketService) {
        this.jacketService = jacketService;
    }
    //    POST. /api/products/jackets
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
    //    GET /api/products/jackets (list)
    @GetMapping
    public ResponseEntity<List<Jacket>> getAllJackets() {
        List<Jacket> jackets = new ArrayList();
        try {
            jackets = jacketService.findAllJackets();
        } catch(Exception e) {
            return ResponseEntity.badRequest().header("message", e.getMessage()).build();
        }
        return ResponseEntity.ok(jackets);
    }
    //    GET /api/products/jackets/:id
    @GetMapping("/{id}")
    public ResponseEntity<Optional<List<Jacket>>> getJacketById(@PathVariable Long id) {
        List<Jacket> jackets = new ArrayList();

        try {
            jacketService.findById(id).map(jacket -> jackets.add(jacket));
        } catch(Exception e) {
            return ResponseEntity.badRequest().header("message", e.getMessage()).build();
        }
        return ResponseEntity.ok(Optional.of(jackets));
    }
    //    PATCH /api/products/jackets/:id
    //    PUT /api/products/jackets/:id
}
