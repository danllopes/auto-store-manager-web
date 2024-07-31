package br.com.danllopes.autostoreweb.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CarRequestDTO(

        @NotBlank
        String brand,

        @NotBlank
        String model,

        @NotNull
        short modelYear,

        @NotBlank
        String condition,

        @NotBlank
        String fuelType,

        @NotBlank
        String transmissionType,

        @NotNull
        int mileage,

        @NotNull
        byte numberOfDoors,

        @NotNull
        double engineCapacity,

        @NotBlank
        String carType
) {
}
