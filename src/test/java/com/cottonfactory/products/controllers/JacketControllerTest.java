package com.cottonfactory.products.controllers;

import com.cottonfactory.products.entities.Jacket;
import com.cottonfactory.products.entities.Season;
import com.cottonfactory.products.entities.Size;
import com.cottonfactory.products.entities.Style;
import com.cottonfactory.products.services.JacketService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
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
}