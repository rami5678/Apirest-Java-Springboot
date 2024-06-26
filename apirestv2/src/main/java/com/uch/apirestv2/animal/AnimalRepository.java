package com.uch.apirestv2.animal;

import com.uch.apirestv2.animal.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal, Long> {
}
