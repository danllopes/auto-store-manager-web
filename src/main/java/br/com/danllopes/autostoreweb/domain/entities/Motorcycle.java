package br.com.danllopes.autostoreweb.domain.entities;

import br.com.danllopes.autostoreweb.domain.enums.BikeType;
import br.com.danllopes.autostoreweb.dtos.MotorcycleRequestDTO;
import jakarta.persistence.*;

import java.util.Objects;

@Entity(name = "motorcycle")
@Table(name = "motorcycle")
public class Motorcycle extends Vehicle{

    @Column(name = "cylinder_capacity")
    private Short cylinderCapacity;

    @Column(name = "bike_type")
    private BikeType bikeType;

    public Motorcycle() {super();}

    public Motorcycle(MotorcycleRequestDTO data) {
        super(data.brand(), data.model(), data.modelYear(), data.condition(), data.fuelType(), data.transmissionType(), data.mileage());
        this.cylinderCapacity = data.cylinderCapacity();
        this.bikeType = data.bikeType();
    }

    public Short getCylinderCapacity() {
        return cylinderCapacity;
    }

    public void setCylinderCapacity(Short cylinderCapacity) {
        this.cylinderCapacity = cylinderCapacity;
    }

    public BikeType getBikeType() {
        return bikeType;
    }

    public void setBikeType(BikeType bikeType) {
        this.bikeType = bikeType;
    }
}