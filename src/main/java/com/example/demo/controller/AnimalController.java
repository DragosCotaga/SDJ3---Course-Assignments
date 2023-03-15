package com.example.demo.controller;


import com.example.demo.model.Animal;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/animals")
public class AnimalController {

    private final Map<String, Animal> animals = new HashMap<>();

    @GetMapping
    public Collection<Animal> getAllAnimals() {
        return animals.values();
    }

    // Add animal
    @PostMapping
    public Animal addAnimal(@RequestBody Animal animal) {
        animals.put(animal.getRegistrationNumber(), animal);
        return animal;
    }

    // Get animal by registration number
    @GetMapping("/{registrationNumber}")
    public Animal getAnimal(@PathVariable String registrationNumber) {
        return animals.get(registrationNumber);
    }

    @GetMapping("/by-date/{date}")
    public List<Animal> getAnimalsByDate(@PathVariable("date") String dateString) {
        LocalDate date = LocalDate.parse(dateString);
        return animals.values().stream()
                .filter(animal -> animal.getDate().equals(date))
                .collect(Collectors.toList());
    }

    @GetMapping("/by-origin/{origin}")
    public List<Animal> getAnimalsByOrigin(@PathVariable("origin") String origin) {
        return animals.values().stream()
                .filter(animal -> animal.getOrigin().equalsIgnoreCase(origin))
                .collect(Collectors.toList());
    }

}
