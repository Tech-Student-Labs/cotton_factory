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

    public Pants getById(Long id) {
        if(pantsRepository.findById(id).isPresent()){
            return pantsRepository.findById(id).get();
        }else{
            throw new RuntimeException("Pants not found");
        }
    }

    public boolean deleteById(Long id) {
        if(pantsRepository.findById(id).isPresent()){
            pantsRepository.deleteById(id);
            return true;
        }else{
            throw new RuntimeException("Pants not found");
        }
    }

}
