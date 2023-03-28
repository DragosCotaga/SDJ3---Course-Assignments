package com.example.demo.controller;

import com.example.demo.model.AnimalPart;
import com.example.demo.model.Tray;
import com.example.demo.service.TrayService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrayController {
    private final Map<Long, Tray> trays = new HashMap<>();

    private TrayService trayService;

    @PostMapping
    public Tray createTray(@RequestBody Tray tray) {
        return trayService.addTray(tray);
    }

    @GetMapping("/{id}")
    public Tray getTrayById(@PathVariable Long id) {
        return trayService.getTrayById(id);
    }

    @GetMapping
    public List<Tray> getAllTrays() {
        return trayService.getAllTrays();
    }

    @PutMapping("/{id}")
    public Tray updateTray(@PathVariable Long id, @RequestBody Tray tray) {
        return trayService.updateTray(id, tray);
    }

    @DeleteMapping("/{id}")
    public boolean deleteTray(@PathVariable Long id) {
        return trayService.deleteTray(id);
    }

    @PostMapping("/{trayId}/add-animal-part")
    public Tray addAnimalPartToTray(@PathVariable Long trayId, @RequestBody AnimalPart animalPart) {
        Tray tray = trayService.getTrayById(trayId);
        if (tray != null) {
            tray.addAnimalPart(animalPart);
            return trayService.updateTray(trayId, tray);
        }
        return null;
    }
}
