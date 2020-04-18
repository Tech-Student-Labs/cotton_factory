package com.cottonfactory.products.services;

import com.cottonfactory.products.repositories.ShirtRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ShirtServiceTest {

    @MockBean
    ShirtRepository shirtRepository;

    @Test
    public void serviceExists() {
        //Setup
        ShirtService shirtService = new ShirtService(shirtRepository);
        //Exercise
        //Assert
        assertNotNull(shirtService);
        //Teardown
    }
}
