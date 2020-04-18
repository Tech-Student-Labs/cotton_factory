package com.cottonfactory.products.services;

import com.cottonfactory.products.entities.Pants;
import com.cottonfactory.products.repositories.PantsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PantsService {

    PantsRepository pantsRepository;

    public PantsService(PantsRepository pantsRepository) {
        this.pantsRepository = pantsRepository;
    }

    public List<Pants> getAll(){
        return pantsRepository.findAll();
    }


    public Pants save(Pants pants) {
        return pantsRepository.save(pants);
    }
}
