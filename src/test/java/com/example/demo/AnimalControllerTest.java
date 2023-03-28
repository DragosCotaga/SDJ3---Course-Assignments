package com.example.demo;

import com.example.demo.controller.AnimalController;
import com.example.demo.model.Animal;
import com.example.demo.service.AnimalService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AnimalControllerTest {

    @InjectMocks
    private AnimalController animalController;

    @Mock
    private AnimalService animalService;

    @Test
    public void testGetAllAnimals() {
        Animal animal1 = new Animal();
        Animal animal2 = new Animal();

        when(animalService.getAllAnimals()).thenReturn(Arrays.asList(animal1, animal2));

        List<Animal> animals = animalController.getAllAnimals();

        assertEquals(2, animals.size());
    }
}
