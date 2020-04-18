package com.cottonfactory.products.services;

import com.cottonfactory.products.entities.Jacket;
import com.cottonfactory.products.repositories.JacketRepository;
import org.springframework.stereotype.Service;

@Service
public class JacketService {
    JacketRepository jacketRepository;
    public JacketService (JacketRepository jacketRepository) {
        this.jacketRepository = jacketRepository;
    }
    public Jacket createJacket(Jacket jacket) {
        return jacketRepository.save(jacket);
    }
}
