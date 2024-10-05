package com.example.JavaSpringPostgreSQL.services;


import com.example.JavaSpringPostgreSQL.models.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.JavaSpringPostgreSQL.repositories.CarRepository;

import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public Car createCar(Car car) {
        return carRepository.save(car);
    }

    public Car updateCar(Long id, Car carDetails) {
        return carRepository.findById(id)
                .map(car -> {
                    car.setModel(carDetails.getModel());
                    car.setManufacturer(carDetails.getManufacturer());
                    return carRepository.save(car);
                })
                .orElse(null);
    }

    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }

    public Car getCarById(Long id) {
        return carRepository.findById(id).orElse(null);
    }

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

}
