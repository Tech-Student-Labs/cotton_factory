package com.cottonfactory.products.controllers;

import com.cottonfactory.products.entities.Jacket;
import com.cottonfactory.products.entities.Season;
import com.cottonfactory.products.entities.Size;
import com.cottonfactory.products.entities.Style;
import com.cottonfactory.products.services.JacketService;
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
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class JacketControllerTest {
    private String url = "/api/products/jackets";

    @Autowired
    MockMvc mvc;

    @MockBean
    JacketService jacketService;

    ObjectMapper mapper = new ObjectMapper();

    @Test
    public void controllerExists(){
        JacketController controller = new JacketController(jacketService);
        assertNotNull(controller);
    }

    @Test
    void createJacket() throws Exception {
        Jacket jacket = new Jacket();
        jacket.setId(1L);
        jacket.setSize(Size.SMALL);
        jacket.setColor("Red");
        jacket.setSeason(Season.SPRING);
        jacket.setAdultSize(true);
        jacket.setPrice(new BigDecimal(10.00));
        jacket.setStyle(Style.HOODED);
        String json = mapper.writeValueAsString(jacket);
        when(jacketService.createJacket(ArgumentMatchers.any(Jacket.class))).thenReturn(jacket);
        mvc.perform(post(url).content(json).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size").value("SMALL"))
                .andExpect(jsonPath("$.color").value(jacket.getColor()))
                .andExpect(jsonPath("$.style").value("HOODED"))
                .andExpect(jsonPath("$.adultSize").value(jacket.getAdultSize()))
                .andExpect(jsonPath("$.price").value(jacket.getPrice()));

    }
//    GET /api/products/jackets (list)
    @Test
    void getAllJackets() throws Exception {
        Jacket jacket = new Jacket();
        jacket.setId(1L);
        jacket.setSize(Size.SMALL);
        jacket.setColor("Red");
        jacket.setSeason(Season.SPRING);
        jacket.setAdultSize(true);
        jacket.setPrice(new BigDecimal(10.00));
        jacket.setStyle(Style.HOODED);
        List<Jacket> jackets = new ArrayList();
        jackets.add(jacket);
        when(jacketService.findAllJackets()).thenReturn(jackets);
        mvc.perform(get(url))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(jackets.size())));
    }

//    GET /api/products/jackets/:id
//    PATCH /api/products/jackets/:id
//    PUT /api/products/jackets/:id
}