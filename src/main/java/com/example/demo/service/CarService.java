package com.example.demo.service;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private ExteriorColorRepository exteriorRepository;
    @Autowired
    private InteriorOptionRepository interiorOptionRepository;
    @Autowired
    private AutopilotOptionRepository autopilotOptionRepository;
    @Autowired
    private FeatureRepository featureRepository;

    public List<Car> getAllCars() {
        return (List<Car>) carRepository.findAll();
    }

    public Car createCar(Car car) {
        return carRepository.save(car);
    }

    public Car getCarById(Long id) {
        return carRepository.findById(id).orElse(null);
    }

    public Car updateCar(Long id, Car car) {
        Car existingCar = carRepository.findById(id).orElse(null);
        if (existingCar == null) {
            return null;
        }

        // Delete all the options before mutating
        deleteOptions(existingCar.getFeatures(),featureRepository);
        deleteOptions(existingCar.getAutopilotOptions(),autopilotOptionRepository);
        deleteOptions(existingCar.getInteriorOptions(),interiorOptionRepository);
        deleteOptions(existingCar.getAutopilotOptions(),autopilotOptionRepository);

        // Adding and getting the option lists
        List<AutopilotOption> newAutopilotOptions = updateOptions(car.getAutopilotOptions(), existingCar, autopilotOptionRepository);
        List<InteriorOption> newInteriorOption = updateOptions(car.getInteriorOptions(), existingCar, interiorOptionRepository);
        List<ExteriorColor> newExteriorOption = updateOptions(car.getExteriorColors(), existingCar, exteriorRepository);
        List<Feature> newFeature = updateOptions(car.getFeatures(), existingCar, featureRepository);

        // Updating Car Model
        existingCar.setModel(car.getModel());
        existingCar.setBasePrice(car.getBasePrice());
        existingCar.setFeatures(newFeature);
        existingCar.setExteriorColors(newExteriorOption);
        existingCar.setInteriorOptions(newInteriorOption);
        existingCar.setAutopilotOptions(newAutopilotOptions);
        existingCar.setImageLink(car.getImageLink());

        // Update in the DB.
        return carRepository.save(existingCar);
    }

    public void deleteCar(Long id) {
        Car existingCar = carRepository.findById(id).orElse(null);
        if (existingCar != null) {
            // Delete all the options before mutating
            deleteOptions(existingCar.getFeatures(),featureRepository);
            deleteOptions(existingCar.getAutopilotOptions(),autopilotOptionRepository);
            deleteOptions(existingCar.getInteriorOptions(),interiorOptionRepository);
            deleteOptions(existingCar.getAutopilotOptions(),autopilotOptionRepository);
            carRepository.deleteById(id);
        }
    }

    private <T extends Option> void deleteOptions(List<T> options, JpaRepository<T, Long> repository) {
        options.forEach(option -> {
            option.setCar(null);
            repository.save(option);
            repository.deleteById(option.getId());
        });
    }
    private <T extends Option> List<T> updateOptions(List<T> options, Car car, JpaRepository<T, Long> repository) {
        List<T> newOptions = new ArrayList<>();
        for (T option : options) {
            option.setCar(car);
            T newOption = repository.save(option);
            if (newOption != null) {
                newOptions.add(newOption);
            }
        }
        return newOptions;
    }
}
