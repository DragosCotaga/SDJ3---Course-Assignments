package com.example.demo.service;

import com.example.demo.model.Animal;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AnimalService {

    private final Map<Long, Animal> animals = new HashMap<>();
    private long nextId = 1;

    public Animal addAnimal(Animal animal){
        animal.setId(nextId++);
        animals.put(animal.getId(), animal);
        return animal;
    }

    public Animal getAnimalById(Long id){
        return animals.get(id);
    }

    public List<Animal> getAllAnimals(){
        return new ArrayList<>(animals.values());
    }

    public Animal updateAnimal(Long id, Animal animal){
        animal.setId(id);
        animals.put(id, animal);
        return animal;
    }

    public boolean deleteAnimal(Long id){
        return animals.remove(id) != null;
    }
}
