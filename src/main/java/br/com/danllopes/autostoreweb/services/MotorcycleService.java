package br.com.danllopes.autostoreweb.services;

import br.com.danllopes.autostoreweb.domain.entities.Motorcycle;
import br.com.danllopes.autostoreweb.domain.enums.VehicleStatus;
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

    public List<Motorcycle> getAllMotorcycles() {return this.repository.findByStatus(VehicleStatus.FOR_SALE);}

    public Motorcycle getOptionalMotorcycle(String id) {return this.findMotorcycleById(id);}

    public Motorcycle createMotorcycle(MotorcycleRequestDTO data) {
        var motorcycle = new Motorcycle(data);
        return this.repository.save(motorcycle);
    }

    public Motorcycle updateMotorcycle(MotorcycleRequestDTO data, String id) {
        var optionalBike = this.findMotorcycleById(id);
        optionalBike.setBrand(data.brand());
        optionalBike.setModel(data.model());
        optionalBike.setModelYear(data.modelYear());
        optionalBike.setCondition(data.condition());
        optionalBike.setFuelType(data.fuelType());
        optionalBike.setTransmissionType(data.transmissionType());
        optionalBike.setMileage(data.mileage());
        optionalBike.setCylinderCapacity(data.cylinderCapacity());
        optionalBike.setBikeType(data.bikeType());
        this.repository.save(optionalBike);
        return optionalBike;
    }

    public void updateToSold(String id) {
        var optionalBike = this.findMotorcycleById(id);
        optionalBike.updateToSold();
    }

    private Motorcycle findMotorcycleById(String id) {
        return this.repository.findById(id)
                .orElseThrow(() -> new MotorcycleNotFoundException("Motorcycle Not Found with ID: " + id));
    }
}
