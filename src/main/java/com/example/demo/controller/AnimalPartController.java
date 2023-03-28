package com.example.demo.controller;

import com.example.demo.model.AnimalPart;
import com.example.demo.service.AnimalPartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The AnimalPartController class is a RESTful web service endpoint that handles HTTP requests for managing animal parts.
 * It maps to the "/api/animal-parts" path and includes methods for creating, retrieving, updating, and deleting AnimalPart objects.
 *
 * @see AnimalPart
 * @see AnimalPartService
 */

@RestController
@RequestMapping("/api/animal-parts")
public class AnimalPartController {

    private static final int ONE_HEAD = 1;
    private static final int TWO_LEGS = 2;
    private static final int FOUR_LEGS = 4;
    private static final int ONE_CHEST = 1;
    private static final int ONE_BACK = 1;

    @Autowired
    private AnimalPartService animalPartService;

    public static void setAnimalAttributes(String animalType, AnimalPart animalPart, double weight) {
        switch (animalType) {
            case "Cow" -> {
                animalPart.setHeads(ONE_HEAD, weight * 0.1);
                animalPart.setLegs(FOUR_LEGS, weight * 0.25);
                animalPart.setChests(ONE_CHEST, weight * 0.4);
                animalPart.setBacks(ONE_BACK, weight * 0.25);
            }
            case "Pig" -> {
                animalPart.setHeads(ONE_HEAD, weight * 0.1);
                animalPart.setLegs(FOUR_LEGS, weight * 0.24);
                animalPart.setChests(ONE_CHEST, weight * 0.4);
                animalPart.setBacks(ONE_BACK, weight * 0.26);
            }
            case "Chicken" -> {
                animalPart.setHeads(ONE_HEAD, weight * 0.1);
                animalPart.setLegs(TWO_LEGS, weight * 0.1);
                animalPart.setChests(ONE_CHEST, weight * 0.4);
                animalPart.setBacks(ONE_BACK, weight * 0.4);
            }
            default -> throw new IllegalArgumentException("Unsupported animal type: " + animalType);
        }
    }

    @PostMapping
    public AnimalPart createAnimalPart(@RequestBody AnimalPart animalPart) {
        setAnimalAttributes(animalPart.getAnimalType(), animalPart, animalPart.getWeight());
        return animalPartService.addAnimalPart(animalPart);
    }

    @GetMapping("/{id}")
    public AnimalPart getAnimalPart(@PathVariable Long id) {
        return animalPartService.getAnimalPart(id);
    }

    @GetMapping
    public List<AnimalPart> getAllAnimalParts() {
        return animalPartService.getAllAnimalParts();
    }

    @PutMapping("/{id}")
    public AnimalPart updateAnimalPart(@PathVariable Long id, @RequestBody AnimalPart animalPart) {
        return animalPartService.updateAnimalPart(id, animalPart);
    }

    @DeleteMapping("/{id}")
    public boolean deleteAnimalPart(@PathVariable Long id) {
        return animalPartService.deleteAnimalPart(id);
    }
}
