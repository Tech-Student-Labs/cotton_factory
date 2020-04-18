package com.cottonfactory.products.services;

import com.cottonfactory.products.entities.Jacket;
import com.cottonfactory.products.repositories.JacketRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JacketService {
    JacketRepository jacketRepository;
    public JacketService (JacketRepository jacketRepository) {
        this.jacketRepository = jacketRepository;
    }
    public Jacket createJacket(Jacket jacket) {
        return jacketRepository.save(jacket);
    }

    public List<Jacket> findAllJackets() {
        return jacketRepository.findAll();
    }

    public Optional<Jacket> findById(Long id) {
        return jacketRepository.findById(id);
    }
}
