package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
@Entity
public class AnimalPart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int heads;
    private int chests;
    private int backs;
    private int legs;

    private double headWeight;
    private double chestWeight;
    private double backWeight;
    private double legWeight;

    private String animalType;

    private int weight;

    public void setHeads(int heads, double weight) {
        this.heads = heads;
        this.headWeight = weight;
    }

    public void setLegs(int legs, double weight) {
        this.legs = legs;
        this.legWeight = weight;
    }

    public void setChests(int chests, double weight) {
        this.chests = chests;
        this.chestWeight = weight;
    }

    public void setBacks(int backs, double weight) {
        this.backs = backs;
        this.backWeight = weight;
    }
}
