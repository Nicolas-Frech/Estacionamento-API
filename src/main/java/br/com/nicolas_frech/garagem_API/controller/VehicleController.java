package br.com.nicolas_frech.garagem_API.controller;

import br.com.nicolas_frech.garagem_API.model.vehicle.dto.VehicleDTO;
import br.com.nicolas_frech.garagem_API.model.vehicle.dto.VehicleDTOUpdate;
import br.com.nicolas_frech.garagem_API.service.VehicleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/veiculos")
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @PostMapping
    @Transactional
    public ResponseEntity registVehicle(@RequestBody @Valid VehicleDTO dto) {
        vehicleService.registVehicle(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity getVehicleById(@PathVariable Long id) {
        var vehicle = vehicleService.getVehicleById(id);
        return ResponseEntity.ok(vehicle);
    }

    @PutMapping
    @Transactional
    public ResponseEntity updateVehicle(@RequestBody VehicleDTOUpdate dto) {
        var vehicle = vehicleService.updateVehicle(dto);
        return ResponseEntity.ok(vehicle);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteVehicle(@PathVariable Long id) {
        vehicleService.deleteVehicle(id);

        return ResponseEntity.noContent().build();
    }
}
