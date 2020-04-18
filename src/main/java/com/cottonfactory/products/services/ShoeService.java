package com.cottonfactory.products.services;

import com.cottonfactory.products.entities.Shoes;
import com.cottonfactory.products.repositories.ShoeRepository;
import org.springframework.stereotype.Service;

@Service
public class ShoeService {

    private ShoeRepository shoeRepository;

    public ShoeService(ShoeRepository shoeRepository){
        this.shoeRepository = shoeRepository;
    }

    public Shoes createShoe(Shoes shoes) {
        return shoeRepository.save(shoes);
    }
}
