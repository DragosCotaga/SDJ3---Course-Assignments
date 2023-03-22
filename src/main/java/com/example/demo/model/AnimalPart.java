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
    private int heads;
    private int chests;
    private int backs;
    private int legs;

    public void setHeads(int oneHead, double v) {
    }

    public void setLegs(int fourLegs, double v) {
    }

    public void setChests(int oneChest, double v) {
    }

    public void setBacks(int oneBack, double v) {
    }
}
