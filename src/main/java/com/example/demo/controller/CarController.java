package com.example.demo.controller;


import com.example.demo.model.*;
import com.example.demo.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {
    @Autowired
    private CarRepository carRepository;

    @GetMapping
    public List<Car> getAllCars() {
        return (List<Car>) carRepository.findAll();
    }

    @PostMapping
    public Car createCar(@RequestBody Car car) {
        return carRepository.save(car);
    }

    @GetMapping("/{id}")
    public Car getCarById(@PathVariable Long id) {
        return carRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Car updateCar(@PathVariable Long id, @RequestBody Car car) {
        Car existingCar = carRepository.findById(id).orElse(null);
        if (existingCar == null) {
            return null;
        }

        existingCar.setModel(car.getModel());
        existingCar.setBasePrice(car.getBasePrice());

        List<Feature> features = car.getFeatures();
        features.forEach(option -> option.setCar(car));
        existingCar.setFeatures(car.getFeatures());

        List<ExteriorColor> exteriorColors = car.getExteriorColors();
        exteriorColors.forEach(option -> option.setCar(car));
        existingCar.setExteriorColors(car.getExteriorColors());

        List<InteriorOption> interiorOptions = car.getInteriorOptions();
        interiorOptions.forEach(option -> option.setCar(car));
        existingCar.setInteriorOptions(car.getInteriorOptions());

        List<AutopilotOption> autopilotOptions = car.getAutopilotOptions();
        autopilotOptions.forEach(option -> option.setCar(existingCar));
        existingCar.setAutopilotOptions(autopilotOptions);

        existingCar.setImageLink(car.getImageLink());
        return carRepository.save(existingCar);
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable Long id) {
        carRepository.deleteById(id);
    }
}
