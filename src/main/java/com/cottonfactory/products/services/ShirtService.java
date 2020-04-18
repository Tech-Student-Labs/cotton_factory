package com.cottonfactory.products.services;

import com.cottonfactory.products.entities.Shirt;
import com.cottonfactory.products.repositories.ShirtRepository;
import org.springframework.stereotype.Service;

@Service
public class ShirtService {
    private ShirtRepository shirtRepository;

    public ShirtService(ShirtRepository shirtRepository) {
        this.shirtRepository = shirtRepository;
    }

    public Shirt postShirt(Shirt input) {
        return shirtRepository.save(input);
    }
}
