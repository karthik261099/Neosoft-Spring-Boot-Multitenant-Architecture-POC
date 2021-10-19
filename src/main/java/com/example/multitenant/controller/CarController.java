package com.example.multitenant.controller;

import com.example.multitenant.tenant.repository.CarRepository;
import com.example.multitenant.tenant.entity.Car;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@Transactional
@RequestMapping(path = "/cars")
public class CarController {

    private final CarRepository carRepository;

    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    public Car insert(@RequestBody Car car){
        return carRepository.save(car);
    }

    @GetMapping
    public List<Car> posts(){
        return carRepository.findAll();
    }
}
