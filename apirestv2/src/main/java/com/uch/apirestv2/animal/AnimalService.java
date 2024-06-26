package com.uch.apirestv2.animal;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnimalService {
    private final AnimalRepository animalrepo;

    public void createAnimal(Animal animal){
        animalrepo.save(animal);
    }
}
