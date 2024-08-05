package br.com.danllopes.autostoreweb.services;

import br.com.danllopes.autostoreweb.domain.entities.Car;
import br.com.danllopes.autostoreweb.domain.enums.VehicleStatus;
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

    public List<Car> getAllCars() {return this.repository.findByStatus(VehicleStatus.FOR_SALE);}

    public Car getOptionalCar(String id) {return this.findCarById(id);}

    public Car createCar(CarRequestDTO data) {
        var car = new Car(data);
        return repository.save(car);
    }

    public Car updateCar(CarRequestDTO data, String id) {
        var optionalCar = this.findCarById(id);
        optionalCar.setBrand(data.brand());
        optionalCar.setModel(data.model());
        optionalCar.setModelYear(data.modelYear());
        optionalCar.setCondition(data.condition());
        optionalCar.setFuelType(data.fuelType());
        optionalCar.setTransmissionType(data.transmissionType());
        optionalCar.setMileage(data.mileage());
        optionalCar.setNumberOfDoors(data.numberOfDoors());
        optionalCar.setEngineCapacity(data.engineCapacity());
        optionalCar.setCarType(data.carType());
        this.repository.save(optionalCar);
        return optionalCar;
    }

    public void updateToSold(String id) {
        var optionalCar = this.findCarById(id);
        optionalCar.updateToSold();
    }

    private Car findCarById(String id) {
        return this.repository.findById(id)
                .orElseThrow(() -> new CarNotFoundException("Car Not Found with ID: " + id));
    }


}
