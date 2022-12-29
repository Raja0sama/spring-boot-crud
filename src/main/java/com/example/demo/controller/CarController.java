package com.example.demo.controller;


import com.example.demo.model.*;
import com.example.demo.service.CarService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping
    @CrossOrigin(origins = "http://localhost:8081")
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }

    @PostMapping
    public Car createCar(@RequestBody Car car) {
        return carService.createCar(car);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ResponseClass> getCarById(@PathVariable Long id) {
        Car car = carService.getCarById(id);
        if (car == null) {
            ResponseClass response = new ResponseClass(car,HttpStatus.NOT_FOUND.toString(),"No Car found with the ID" );
            return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
        }
        ResponseClass response = new ResponseClass(car,HttpStatus.OK.toString(),null );
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public Car updateCar(@PathVariable Long id, @RequestBody Car car) {
        return carService.updateCar(id, car);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseClass> deleteCar(@PathVariable Long id) {
        Car car = carService.getCarById(id);
        if (car == null) {
            ResponseClass response = new ResponseClass(car,HttpStatus.NOT_FOUND.toString(),"No Car found with the ID" );
            return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
        }
        carService.deleteCar(id);
        ResponseClass response = new ResponseClass(car,HttpStatus.OK.toString(),null );
        return new ResponseEntity<>(response, HttpStatus.OK);

    }
}

