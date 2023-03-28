package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
@Entity
public class Tray {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Double maxWeightCapacity;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "tray_id")
    private List<AnimalPart> animalParts = new ArrayList<>();

    public void addAnimalPart(AnimalPart animalPart) {
        animalParts.add(animalPart);
    }
}
