package br.com.nicolas_frech.garagem_API.model.vehicle.dto;

import br.com.nicolas_frech.garagem_API.model.vehicle.Vehicle;
import br.com.nicolas_frech.garagem_API.model.vehicle.VehicleType;

public record VehicleDTOReturn(Long id, String brand, String model, String color, String plate, VehicleType type) {
    public VehicleDTOReturn(Vehicle vehicle) {
        this(vehicle.getId(), vehicle.getBrand(), vehicle.getModel(), vehicle.getColor(), vehicle.getPlate(), vehicle.getType());
    }
}
