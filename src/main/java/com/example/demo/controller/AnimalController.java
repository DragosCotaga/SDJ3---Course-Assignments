package com.example.demo.controller;

import com.example.demo.model.Animal;
import com.example.demo.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The AnimalController class handles HTTP requests related to animal resources, such as creating, retrieving, updating,
 * and deleting animal records. It is a RESTful web service endpoint class that maps to the "/api/animals" path.
 */

@RestController
@RequestMapping("/api/animals")
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    @GetMapping
    public List<Animal> getAllAnimals() {
        return animalService.getAllAnimals();
    }

    @PostMapping
    public ResponseEntity<Animal> addAnimal(@RequestBody Animal animal) {
        Animal createdAnimal = animalService.addAnimal(animal);
        return ResponseEntity.ok(createdAnimal);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Animal> getAnimal(@PathVariable Long id) {
        Animal animal = animalService.getAnimalById(id);
        if (animal != null) {
            return ResponseEntity.ok(animal);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/by-date/{date}")
    public List<Animal> getAnimalsByDate(@PathVariable("date") String dateString) {
        LocalDate date = LocalDate.parse(dateString);
        return animalService.getAllAnimals().stream()
                .filter(animal -> animal.getDate().equals(date))
                .collect(Collectors.toList());
    }

    @GetMapping("/by-origin/{origin}")
    public List<Animal> getAnimalsByOrigin(@PathVariable("origin") String origin) {
        return animalService.getAllAnimals().stream()
                .filter(animal -> animal.getOrigin().equalsIgnoreCase(origin))
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Animal> updateAnimal(@PathVariable Long id, @RequestBody Animal animal) {
        Animal updatedAnimal = animalService.updateAnimal(id, animal);
        if (updatedAnimal != null) {
            return ResponseEntity.ok(updatedAnimal);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAnimal(@PathVariable Long id) {
        boolean deleted = animalService.deleteAnimal(id);
        if (deleted) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
