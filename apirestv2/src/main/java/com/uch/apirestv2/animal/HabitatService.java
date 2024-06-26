package com.uch.apirestv2.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabitatService {
    private final HabitatRepository habitatRepository;

    @Autowired
    public HabitatService(HabitatRepository habitatRepository) {
        this.habitatRepository = habitatRepository;
    }

    public List<Habitat> getAllHabitats() {
        return habitatRepository.findAll();
    }

    public Habitat getHabitatById(Long id) {
        return habitatRepository.findById(id).orElseThrow(() -> new RuntimeException("Habitat not found"));
    }

    public Habitat saveHabitat(Habitat habitat) {
        return habitatRepository.save(habitat);
    }

    public void deleteHabitat(Long id) {
        habitatRepository.deleteById(id);
    }
}
