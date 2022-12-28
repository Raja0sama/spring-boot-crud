package com.example.demo.service;


import com.example.demo.model.*;
import com.example.demo.repository.*;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
@AutoConfigureMockMvc
public class CarServiceTest {

    @Autowired
    private CarService carService;

    @MockBean
    private CarRepository carRepository;

    @MockBean
    private InteriorOptionRepository interiorOptionRepository;

    @MockBean
    private ExteriorColorRepository exteriorColorRepository;

    @MockBean
    private AutopilotOptionRepository autopilotOptionRepository;

    @MockBean
    private FeatureRepository featureRepository;

    @Test
    public void testGetAllCars() {
        // Set up mock objects
        when(carRepository.findAll()).thenReturn(Arrays.asList(new Car(), new Car()));
        // Invoke the method under test
        List<Car> cars = carService.getAllCars();
        // Verify the results
        assertEquals(2, cars.size());
    }
    @Test
    public void testCreatCar (){
        Car car = new Car();
        car.setBasePrice("Sample Image");
        car.setImageLink("https://url/");
        car.setModel("Model x");

        carService.createCar(car);
        verify(carRepository).save(argThat(newCar -> newCar.getBasePrice().equals("Sample Image") && newCar.getImageLink().equals("https://url/")));
    }
    @Test
    public void testGetById() {
        Long id = Long.valueOf(123);
        // Set up mock objects
        Car car = new Car();
        car.setBasePrice("Sample Image");
        car.setImageLink("https://url/");
        car.setModel("Model x");
        car.setId(id);
        when(carRepository.findById(id)).thenReturn(Optional.of(car));
        Car result = carService.getCarById(id);
        // Verify that the carRepository.findById() method was called with the correct arguments
        verify(carRepository).findById(id);
        // Verify that the returned car has the correct values
        assertEquals(id, result.getId());
        assertEquals("Sample Image", result.getBasePrice());
        assertEquals("https://url/", result.getImageLink());
        assertEquals("Model x", result.getModel());
    }


    }
