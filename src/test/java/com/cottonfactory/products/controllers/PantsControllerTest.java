package com.cottonfactory.products.controllers;

import com.cottonfactory.products.entities.Pants;
import com.cottonfactory.products.services.PantsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Arrays;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Transactional
@AutoConfigureMockMvc
public class PantsControllerTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    PantsService pantsService;

    @Autowired
    ObjectMapper objectMapper;

    Pants pants;

    @Test
    public void getAllPants_ShouldReturnsPants() throws Exception{
        pants = new Pants(25,30,"Medium","Blue","Abc Abc", BigDecimal.valueOf(12.99));
        pants.setId(1L);
        when(pantsService.getAll()).thenReturn(Arrays.asList(pants));
        mvc.perform(get("/api/pants")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(Arrays.asList(pants).size())))
                .andDo(print());
    }

}
