package com.example.demo.model;

import lombok.*;

import java.util.Map;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
public class Product {
    private Long id;
    private Map<String, Integer> parts;
    private Double totalWeight;

    public Product(Long id, Map<String, Integer> parts, Double totalWeight) {
        this.id = id;
        this.parts = parts;
        this.totalWeight = totalWeight;
    }
}
