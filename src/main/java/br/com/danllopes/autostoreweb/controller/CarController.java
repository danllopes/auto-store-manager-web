package br.com.danllopes.autostoreweb.controller;

import br.com.danllopes.autostoreweb.domain.entities.Car;
import br.com.danllopes.autostoreweb.dtos.CarRequestDTO;
import br.com.danllopes.autostoreweb.services.CarService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cars")
public class CarController {

    private final CarService service;

    public CarController(CarService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Car>> getAllCars() {
        return new ResponseEntity<>(this.service.getAllCars(), HttpStatus.OK);
    }

    @GetMapping("/{carId}")
    public ResponseEntity<Car> getOptionalCar(@PathVariable String carId) {
        return new ResponseEntity<>(this.service.getOptionalCar(carId), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<Car> createCar(@RequestBody @Valid CarRequestDTO data) {
        return new ResponseEntity<>(this.service.createCar(data), HttpStatus.CREATED);
    }
}
