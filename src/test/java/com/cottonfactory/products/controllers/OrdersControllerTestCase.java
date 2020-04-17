package com.cottonfactory.products.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// FIXME: 'RunWith' shouldn't be required, but without it Mockmvc is throwing 'NullPointer'
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class OrdersControllerTestCase {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getAllOrders() throws Exception {
        MockHttpServletRequestBuilder request = get("/api/orders");
        mvc.perform(request).andExpect(status().isOk());
    }

    @Test
    public void getAllOrdersByDate() throws Exception {
        MockHttpServletRequestBuilder request = get("/api/orders?date=2015-12-10");
        mvc.perform(request)
                .andExpect(status().isOk());
    }
}
