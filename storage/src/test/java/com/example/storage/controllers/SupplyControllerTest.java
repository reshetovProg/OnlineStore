package com.example.storage.controllers;

import com.example.storage.entities.Supply;
import com.example.storage.services.SupplyService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SupplyController.class)
public class SupplyControllerTest {
    @MockBean
    private SupplyService supplyService;

    @InjectMocks
    private SupplyController supplyController;

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;


    @Test
    void getSupplyByIdTest() throws Exception{
        Supply supply = new Supply(1L, "Milk", null);
        when(supplyService.getSupplyById(1L)).thenReturn(supply);
        mockMvc.perform(get("/supplies/{id}", 1L))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id").value(1L))
            .andExpect(jsonPath("$.name").value("Milk"))
            .andExpect(jsonPath("$.username").isEmpty());
        verify(supplyService, times(1)).getSupplyById(1L);
    }

    @Test
    void createSupplyTest() throws Exception {
        Supply supply = new Supply(1L, "Milk", null);
        String supplyJson = objectMapper.writeValueAsString(supply);
        when(supplyService.createSupply(supply)).thenReturn(supply);
        mockMvc.perform(post("/supplies")
                .contentType(MediaType.APPLICATION_JSON)
                .content(supplyJson))
                .andExpect(status().isCreated());
        verify(supplyService, times(1)).createSupply(supply);
    }


}
