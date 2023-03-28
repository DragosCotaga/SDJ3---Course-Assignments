package com.example.demo;

import com.example.demo.model.Animal;
import com.example.demo.service.AnimalService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class AnimalServiceTest {

    @InjectMocks
    private AnimalService animalService;

    @Test
    public void testAddAnimal() {
        Animal animal = new Animal();
        animal.setRegistrationNumber("123");
        Animal createdAnimal = animalService.addAnimal(animal);

        assertEquals("123", createdAnimal.getRegistrationNumber());
    }
}
