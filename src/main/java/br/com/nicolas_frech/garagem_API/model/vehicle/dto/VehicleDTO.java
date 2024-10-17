package br.com.nicolas_frech.garagem_API.model.vehicle.dto;

import br.com.nicolas_frech.garagem_API.model.vehicle.VehicleType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record VehicleDTO(
        @NotBlank
        String brand,

        @NotBlank
        String model,

        @NotBlank
        String color,

        @NotBlank
        String plate,

        @NotNull
        VehicleType type) {
}
