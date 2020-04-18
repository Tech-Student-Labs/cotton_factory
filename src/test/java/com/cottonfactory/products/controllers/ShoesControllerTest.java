package com.cottonfactory.products.controllers;

import com.cottonfactory.products.entities.Shoes;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import  static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;


import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class ShoesControllerTest {
    @Autowired
    MockMvc mockMvc;

//    @MockBean
//    ShoesService shoesService;

    ObjectMapper mapper = new ObjectMapper();
    String baseURL = "/api/shoes";

    @Test
    void createShoes() throws Exception {
        Shoes shoes = new Shoes("12", "24", "Jordan's", "leather", "Nike", true, BigDecimal.valueOf(259.99));
        String json = mapper.writeValueAsString(shoes);
//        when(shoesService.createShoes(ArgumentMatchers.any(Shoes.class))).thenReturn(shoes);
        mockMvc.perform(post(baseURL).content(json).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
