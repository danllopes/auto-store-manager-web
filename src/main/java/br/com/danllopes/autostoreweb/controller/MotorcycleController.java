package br.com.danllopes.autostoreweb.controller;

import br.com.danllopes.autostoreweb.domain.entities.Motorcycle;
import br.com.danllopes.autostoreweb.dtos.MotorcycleRequestDTO;
import br.com.danllopes.autostoreweb.services.MotorcycleService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.transaction.Transactional;
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
    @Operation(summary = "Registrar nova moto", description = "Cria uma nova moto com os dados fornecidos.", tags = "Motorcycle")
    public ResponseEntity<Motorcycle> createMotorcycle(@RequestBody @Valid MotorcycleRequestDTO data) {
        return new ResponseEntity<>(this.service.createMotorcycle(data), HttpStatus.CREATED);
    }

    @GetMapping
    @Operation(summary = "Listar todas as motos", description = "Retorna uma lista de todas as motos cadastradas.", tags = "Motorcycle")
    public ResponseEntity<List<Motorcycle>> getAllMotorcycles() {
        return new ResponseEntity<>(this.service.getAllMotorcycles(), HttpStatus.OK);
    }

    @GetMapping("/{motorcycleId}")
    @Operation(summary = "Buscar moto por ID", description = "Retorna uma moto específica com base no ID fornecido.", tags = "Motorcycle")
    public ResponseEntity<Motorcycle> getOptionalMotorcycle(@PathVariable String motorcycleId) {
        return new ResponseEntity<>(this.service.getOptionalMotorcycle(motorcycleId), HttpStatus.OK);
    }

    @PutMapping("/{motorcycleId}")
    @Transactional
    @Operation(summary = "Atualizar moto", description = "Atualiza os dados de ums moto existente com base no ID fornecido.", tags = "Motorcycle")
    public ResponseEntity<Motorcycle> updateMotorcycle(@RequestBody @Valid MotorcycleRequestDTO data, @PathVariable String motorcycleId) {
        return new ResponseEntity<>(this.service.updateMotorcycle(data, motorcycleId), HttpStatus.OK);
    }

    @DeleteMapping("/{motorcycleId}")
    @Transactional
    @Operation(summary = "Excluir moto", description = "Exclui uma moto com base no ID fornecido.", tags = "Motorcycle")
    public ResponseEntity<Void> updateToSold(@PathVariable String motorcycleId) {
        this.service.updateToSold(motorcycleId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
