package br.com.nicolas_frech.garagem_API.controller;

import br.com.nicolas_frech.garagem_API.model.parking.dto.ParkingDTO;
import br.com.nicolas_frech.garagem_API.model.parking.dto.ParkingDTOUpdate;
import br.com.nicolas_frech.garagem_API.service.ParkingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/estacionamento")
public class ParkingController {

    @Autowired
    private ParkingService parkingService;

    @PostMapping
    @Transactional
    public ResponseEntity registParking(@RequestBody @Valid ParkingDTO dto) {
        parkingService.registParking(dto);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity getParkingById(@PathVariable Long id) {
        var parking = parkingService.getParkingById(id);

        return ResponseEntity.ok(parking);
    }

    @PutMapping
    @Transactional
    public ResponseEntity updateParking(@RequestBody ParkingDTOUpdate dto) {
        var parking = parkingService.updateParking(dto);

        return ResponseEntity.ok(parking);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteParking(@PathVariable Long id) {
        parkingService.deleteParking(id);

        return ResponseEntity.noContent().build();
    }

}
