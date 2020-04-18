package com.cottonfactory.products.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ShirtControllerTest {
    @MockBean
    ShirtService service;

    @Autowired
    MockMvc mvc;

    @Test
    public void controllerExists(){
        ShirtController controller = new ShirtController(service);
        assertNotNull(controller);
    }
}
