package br.com.nicolas_frech.garagem_API.service;

import br.com.nicolas_frech.garagem_API.model.vehicle.Vehicle;
import br.com.nicolas_frech.garagem_API.model.vehicle.dto.VehicleDTO;
import br.com.nicolas_frech.garagem_API.model.vehicle.dto.VehicleDTOReturn;
import br.com.nicolas_frech.garagem_API.model.vehicle.dto.VehicleDTOUpdate;
import br.com.nicolas_frech.garagem_API.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {

    @Autowired
    VehicleRepository vehicleRepository;

    public void registVehicle(VehicleDTO dto) {
        Vehicle vehicle = new Vehicle(dto);
        vehicleRepository.save(vehicle);
    }

    public VehicleDTOReturn getVehicleById(Long id) {
        Vehicle vehicle = vehicleRepository.getReferenceById(id);
        return new VehicleDTOReturn(vehicle);
    }

    public VehicleDTOReturn updateVehicle(VehicleDTOUpdate dto) {
        Vehicle vehicle = vehicleRepository.getReferenceById(dto.id());
        vehicle.update(dto);

        return new VehicleDTOReturn(vehicle);
    }

    public void deleteVehicle(Long id) {
        Vehicle vehicle = vehicleRepository.getReferenceById(id);
        vehicle.delete();
    }
}
