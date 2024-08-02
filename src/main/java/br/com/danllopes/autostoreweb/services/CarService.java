package br.com.danllopes.autostoreweb.services;

import br.com.danllopes.autostoreweb.domain.entities.Car;
import br.com.danllopes.autostoreweb.domain.exceptions.CarNotFoundException;
import br.com.danllopes.autostoreweb.dtos.CarRequestDTO;
import br.com.danllopes.autostoreweb.repositories.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    private final CarRepository repository;

    public CarService(CarRepository repository) {
        this.repository = repository;
    }

    public List<Car> getAllCars() {return this.repository.findAll();}

    public Car getOptionalCar(String id) {return this.findCarById(id);}

    public Car createCar(CarRequestDTO data) {
        var car = new Car(data);
        return repository.save(car);
    }

    private Car findCarById(String id) {
        return this.repository.findById(id)
                .orElseThrow(() -> new CarNotFoundException("Car Not Found with ID: " + id));
    }
}
