package com.example.demo.service;

import com.example.demo.model.AnimalPart;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AnimalPartService {

    private final Map<Long, AnimalPart> animalParts = new HashMap<>();
    private long nextId = 1;

    public AnimalPart addAnimalPart(AnimalPart animalPart) {
        animalPart.setId(nextId++);
        animalParts.put(animalPart.getId(), animalPart);
        return animalPart;
    }

    public AnimalPart getAnimalPart(Long id) {
        return animalParts.get(id);
    }

    public List<AnimalPart> getAllAnimalParts() {
        return new ArrayList<>(animalParts.values());
    }

    public AnimalPart updateAnimalPart(Long id, AnimalPart animalPart) {
        animalPart.setId(id);
        animalParts.put(id, animalPart);
        return animalPart;
    }

    public boolean deleteAnimalPart(Long id) {
        return animalParts.remove(id) != null;
    }
}
