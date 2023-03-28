package com.example.demo.service;

import com.example.demo.model.Tray;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TrayService {

    private final Map<Long, Tray> trays = new HashMap<>();
    private long nextId = 1;

    public Tray addTray(Tray tray) {
        tray.setId(nextId++);
        trays.put(tray.getId(), tray);
        return tray;
    }

    public Tray getTrayById(Long id) {
        return trays.get(id);
    }

    public List<Tray> getAllTrays() {
        return new ArrayList<>(trays.values());
    }

    public Tray updateTray(Long id, Tray tray) {
        Tray existingTray = trays.get(id);
        if (existingTray != null) {
            tray.setId(id);
            trays.put(id, tray);
            return tray;
        }
        return null;
    }

    public boolean deleteTray(Long id) {
        return trays.remove(id) != null;
    }
}
