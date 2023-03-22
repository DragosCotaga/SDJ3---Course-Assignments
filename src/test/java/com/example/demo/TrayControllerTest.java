package com.example.demo;

import com.example.demo.controller.TrayController;
import com.example.demo.model.AnimalPart;
import com.example.demo.model.Tray;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class TrayControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper objectMapper;

    private TrayController trayController;

    @Test
    public void testAddTray() throws Exception {
        Tray tray = new Tray();
        tray.setMaxWeightCapacity(100.0);

        mockMvc.perform(post("/trays")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(tray)))
                .andExpect(status().isOk());
    }

}
