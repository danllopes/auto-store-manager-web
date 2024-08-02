package br.com.danllopes.autostoreweb.controller;

import br.com.danllopes.autostoreweb.domain.entities.Motorcycle;
import br.com.danllopes.autostoreweb.dtos.MotorcycleRequestDTO;
import br.com.danllopes.autostoreweb.services.MotorcycleService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/motorcycles")
public class MotorcycleController {

    private final MotorcycleService service;

    public MotorcycleController(MotorcycleService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public ResponseEntity<Motorcycle> createMotorcycle(@RequestBody @Valid MotorcycleRequestDTO data) {
        return new ResponseEntity<>(this.service.createMotorcycle(data), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Motorcycle>> getAllMotorcycles() {
        return new ResponseEntity<>(this.service.getAllMotorcycles(), HttpStatus.OK);
    }

    @GetMapping("/{motorcycleId}")
    public ResponseEntity<Motorcycle> getOptionalMotorcycle(@PathVariable String motorcycleId) {
        return new ResponseEntity<>(this.service.getOptionalMotorcycle(motorcycleId), HttpStatus.OK);
    }
}
