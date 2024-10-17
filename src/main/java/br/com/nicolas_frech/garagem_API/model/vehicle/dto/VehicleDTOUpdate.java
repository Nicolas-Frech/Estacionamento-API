package br.com.nicolas_frech.garagem_API.model.vehicle.dto;

import br.com.nicolas_frech.garagem_API.model.vehicle.VehicleType;
import jakarta.validation.constraints.NotNull;

public record VehicleDTOUpdate(
        @NotNull
        Long id,
        String brand,
        String model,
        String color,
        String plate,
        VehicleType type) {
}
