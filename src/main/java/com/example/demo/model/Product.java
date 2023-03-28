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

}
