package br.com.danllopes.autostoreweb.services;

import br.com.danllopes.autostoreweb.domain.entities.Motorcycle;
import br.com.danllopes.autostoreweb.domain.exceptions.MotorcycleNotFoundException;
import br.com.danllopes.autostoreweb.dtos.MotorcycleRequestDTO;
import br.com.danllopes.autostoreweb.repositories.MotorcycleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotorcycleService {

    private final MotorcycleRepository repository;

    public MotorcycleService(MotorcycleRepository repository) {
        this.repository = repository;
    }

    public List<Motorcycle> getAllMotorcycles() {return this.repository.findAll();}

    public Motorcycle getOptionalMotorcycle(String id) {return this.findMotorcycleById(id);}

    public Motorcycle createMotorcycle(MotorcycleRequestDTO data) {
        var motorcycle = new Motorcycle(data);
        return this.repository.save(motorcycle);
    }

    private Motorcycle findMotorcycleById(String id) {
        return this.repository.findById(id)
                .orElseThrow(() -> new MotorcycleNotFoundException("Motorcycle Not Found with ID: " + id));
    }
}
