package br.com.danllopes.autostoreweb.domain.entities;

import br.com.danllopes.autostoreweb.domain.enums.CarType;
import br.com.danllopes.autostoreweb.dtos.CarRequestDTO;
import jakarta.persistence.*;

@Entity(name = "car")
@Table(name = "car")
public class Car extends Vehicle{

    @Column(name = "num_doors")
    private Short numberOfDoors;

    @Column(name = "engine_capacity")
    private Double engineCapacity;

    @Column(name = "car_type")
    @Enumerated(EnumType.STRING)
    private CarType carType;

    public Car() {super();}

    public Car(CarRequestDTO data) {
        super(data.brand(), data.model(), data.modelYear(), data.condition(), data.fuelType(), data.transmissionType(), data.mileage());
        this.numberOfDoors = data.numberOfDoors();
        this.engineCapacity = data.engineCapacity();
        this.carType = data.carType();
    }

    public Short getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(Short numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    public Double getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(Double engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }
}