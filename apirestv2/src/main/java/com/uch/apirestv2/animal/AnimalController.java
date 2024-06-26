package com.uch.apirestv2.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AnimalController {

    private final AnimalService animalService;
    private final HabitatService habitatService;

    @Autowired
    public AnimalController(AnimalService animalService, HabitatService habitatService) {
        this.animalService = animalService;
        this.habitatService = habitatService;
    }

    @GetMapping("/greeting")
    public String greeting() {
        return "Hello World in API REST";
    }

    @GetMapping("/animals")
    public List<Animal> getAnimals() {
        Habitat savannah = new Habitat("Savannah", "Africa");
        Habitat forest = new Habitat("Forest", "Asia");
        Habitat antarctica = new Habitat("Antarctica", "Antarctica");

        habitatService.saveHabitat(savannah);
        habitatService.saveHabitat(forest);
        habitatService.saveHabitat(antarctica);

        Animal[] animals = new Animal[3];
        animals[0] = new Animal("Lion", "Panthera leo", 5, 190.5, 1.2, savannah);
        animals[1] = new Animal("Elephant", "Loxodonta africana", 10, 5400, 3.3, forest);
        animals[2] = new Animal("Penguin", "Aptenodytes forsteri", 3, 30, 1.1, antarctica);

        List<Animal> animalList = List.of(animals);

        animalList.forEach(animal -> {
            animal.setName("Updated " + animal.getName());
            animal.setAge(animal.getAge() + 1);
        });

        return animalList;
    }
}

