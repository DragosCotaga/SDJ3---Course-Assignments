package com.example.demo.controller;


import com.example.demo.model.Animal;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * AnimalController is a RESTful web service that manages Animal registration
 * and retrieval operations.
 */

@RestController
@RequestMapping("/api/animals")
public class AnimalController {

    private final Map<String, Animal> animals = new HashMap<>();

    /**
     * Retrieves all registered animals.
     *
     * @return a collection of all registered animals
     */

    @GetMapping
    public Collection<Animal> getAllAnimals() {
        return animals.values();
    }

    /**
     * Adds a new animal.
     *
     * @param animal the animal object to be added
     * @return the added animal object
     */
    @PostMapping
    public Animal addAnimal(@RequestBody Animal animal) {
        animals.put(animal.getRegistrationNumber(), animal);
        return animal;
    }

    /**
     * Retrieves an animal by registration number.
     *
     * @param registrationNumber the registration number of the animal
     * @return the animal object with the given registration number
     */
    @GetMapping("/{registrationNumber}")
    public Animal getAnimal(@PathVariable String registrationNumber) {
        return animals.get(registrationNumber);
    }

    /**
     * Retrieves animals by arrival date.
     *
     * @param dateString the arrival date in yyyy-MM-dd format
     * @return a list of animals that arrived on the given date
     */
    @GetMapping("/by-date/{date}")
    public List<Animal> getAnimalsByDate(@PathVariable("date") String dateString) {
        LocalDate date = LocalDate.parse(dateString);
        return animals.values().stream()
                .filter(animal -> animal.getDate().equals(date))
                .collect(Collectors.toList());
    }

    /**
     * Retrieves animals by origin (i.e., farm).
     *
     * @param origin the origin (i.e., farm) of the animals
     * @return a list of animals from the given origin
     */
    @GetMapping("/by-origin/{origin}")
    public List<Animal> getAnimalsByOrigin(@PathVariable("origin") String origin) {
        return animals.values().stream()
                .filter(animal -> animal.getOrigin().equalsIgnoreCase(origin))
                .collect(Collectors.toList());
    }

}
