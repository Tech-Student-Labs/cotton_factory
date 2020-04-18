package com.cottonfactory.products.services;

import com.cottonfactory.products.entities.Shirt;
import com.cottonfactory.products.repositories.ShirtRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

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

    @Test
    void postShirt(){
        ShirtService service = new ShirtService(shirtRepository);
        Shirt expected = new Shirt(Shirt.TYPE.TEE, 3, 3, "M", "customSize", "Red", true, BigDecimal.valueOf(30.5));
        Shirt input = new Shirt(expected.getType(), expected.getSleeve(), expected.getNeck(), expected.getSize(), expected.getCustomSize(), expected.getColor(), expected.isLongSleeve(), expected.getPrice());
        input.setType(expected.getType());
        expected.setId(1L);
        when(shirtRepository.save(any(Shirt.class))).thenReturn(expected);
        assertEquals(expected, service.postShirt(input));
    }
}