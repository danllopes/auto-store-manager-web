package br.com.danllopes.autostoreweb.domain.entities;

import br.com.danllopes.autostoreweb.domain.enums.Condition;
import br.com.danllopes.autostoreweb.domain.enums.FuelType;
import br.com.danllopes.autostoreweb.domain.enums.TransmissionType;
import jakarta.persistence.*;

import java.util.Objects;

@Entity(name = "vehicle")
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "vehicle")
public abstract class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String brand;
    private String model;

    @Column(name = "model_year")
    private Short modelYear;
    @Column(name = "vehicle_condition ")
    @Enumerated(EnumType.STRING)
    private Condition condition;
    @Column(name = "fuel_type")
    @Enumerated(EnumType.STRING)
    private FuelType fuelType;
    @Column(name = "transmission_type")
    @Enumerated(EnumType.STRING)
    private TransmissionType transmissionType;
    private Integer mileage;

    public Vehicle() {}

    public Vehicle(String brand, String model, short year, Condition condition, FuelType fuelType, TransmissionType transmissionType, int mileage) {
        this.brand = brand;
        this.model = model;
        this.modelYear = year;
        this.condition = condition;
        this.fuelType = fuelType;
        this.transmissionType = transmissionType;
        this.mileage = mileage;
    }

    public String getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Short getModelYear() {
        return modelYear;
    }

    public void setModelYear(Short modelYear) {
        this.modelYear = modelYear;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public TransmissionType getTransmissionType() {
        return transmissionType;
    }

    public void setTransmissionType(TransmissionType transmissionType) {
        this.transmissionType = transmissionType;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(id, vehicle.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}