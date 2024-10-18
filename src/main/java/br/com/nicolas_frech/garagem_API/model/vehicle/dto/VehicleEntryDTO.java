package br.com.nicolas_frech.garagem_API.model.vehicle.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record VehicleEntryDTO(
        @NotNull
        Long parkingId,
        @NotNull
        Long vehicleId) {
}
