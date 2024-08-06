package br.com.danllopes.autostoreweb.controller;

import br.com.danllopes.autostoreweb.domain.entities.Car;
import br.com.danllopes.autostoreweb.dtos.CarRequestDTO;
import br.com.danllopes.autostoreweb.services.CarService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.transaction.Transactional;
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

    @PostMapping("/register")
    @Operation(summary = "Registrar novo carro", description = "Cria um novo carro com os dados fornecidos.", tags = "Car")
    public ResponseEntity<Car> createCar(@RequestBody @Valid CarRequestDTO data) {
        return new ResponseEntity<>(this.service.createCar(data), HttpStatus.CREATED);
    }

    @GetMapping
    @Operation(summary = "Listar todos os carros", description = "Retorna uma lista de todos os carros cadastrados.", tags = "Car")
    public ResponseEntity<List<Car>> getAllCars() {
        return new ResponseEntity<>(this.service.getAllCars(), HttpStatus.OK);
    }

    @GetMapping("/{carId}")
    @Operation(summary = "Buscar carro por ID", description = "Retorna um carro específico com base no ID fornecido.", tags = "Car")
    public ResponseEntity<Car> getOptionalCar(@PathVariable String carId) {
        return new ResponseEntity<>(this.service.getOptionalCar(carId), HttpStatus.OK);
    }

    @PutMapping("/{carId}")
    @Transactional
    @Operation(summary = "Atualizar carro", description = "Atualiza os dados de um carro existente com base no ID fornecido.", tags = "Car")
    public ResponseEntity<Car> updateCar(@RequestBody @Valid CarRequestDTO data, @PathVariable String carId) {
        return new ResponseEntity<>(this.service.updateCar(data, carId), HttpStatus.OK);
    }

    @DeleteMapping("/{carId}")
    @Transactional
    @Operation(summary = "Excluir carro", description = "Exclui um carro com base no ID fornecido.", tags = "Car")
    public ResponseEntity<Void> updateToSold(@PathVariable String carId) {
        this.service.updateToSold(carId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}