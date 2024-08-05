package br.com.danllopes.autostoreweb.dtos;

import br.com.danllopes.autostoreweb.domain.enums.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MotorcycleRequestDTO(

        @NotBlank
        String brand,

        @NotBlank
        String model,

        @NotNull
        short modelYear,

        @NotNull
        Condition condition,

        @NotNull
        FuelType fuelType,

        @NotNull
        TransmissionType transmissionType,

        @NotNull
        int mileage,

        @NotNull
        short cylinderCapacity,

        @NotNull
        BikeType bikeType
) {
}
