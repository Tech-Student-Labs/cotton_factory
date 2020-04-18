package com.cottonfactory.products.controllers;

import com.cottonfactory.products.entities.Pants;
import com.cottonfactory.products.services.PantsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Arrays;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@AutoConfigureMockMvc
public class PantsControllerTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    PantsService pantsService;

    ObjectMapper objectMapper = new ObjectMapper();

    Pants pants;

    @Test
    public void getAllPants_ShouldReturnsPants() throws Exception {
        pants = new Pants(25, 30, "Medium", "Blue", "Abc Abc", BigDecimal.valueOf(12.99));
        pants.setId(1L);
        String url = "/api/pants/";
        when(pantsService.getAll()).thenReturn(Arrays.asList(pants));
        mvc.perform(get("/api/pants")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(Arrays.asList(pants).size())))
                .andDo(print());
    }

    @Test
    public void savePants_ShouldReturnsPants() throws Exception {
        pants = new Pants(25, 30, "Medium", "Blue", "Abc Abc", BigDecimal.valueOf(12.99));
        pants.setId(1L);
        String url = "/api/pants/";
        when(pantsService.save(ArgumentMatchers.any(Pants.class))).thenReturn(pants);
        mvc.perform(post("/api/pants")
                .content(objectMapper.writeValueAsString(pants))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(pants.getId()));

    }

    @Test
    public void getPantsById_ShouldReturnsPants() throws Exception{
        pants = new Pants(25, 30, "Medium", "Blue", "Abc Abc", BigDecimal.valueOf(12.99));
        pants.setId(1L);
        String url = "/api/pants/" + pants.getId();
        when(pantsService.getById(ArgumentMatchers.any(Long.class))).thenReturn(pants);
        mvc.perform(get(url)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(pants.getId()));
    }

    @Test
    public void deletePantsById_ShouldReturnsTrue() throws Exception{
        pants = new Pants(25, 30, "Medium", "Blue", "Abc Abc", BigDecimal.valueOf(12.99));
        pants.setId(1L);
        String url = "/api/pants/" + pants.getId();
        when(pantsService.deleteById(ArgumentMatchers.any(Long.class))).thenReturn(Boolean.valueOf("true"));
        mvc.perform(delete(url)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }

}
