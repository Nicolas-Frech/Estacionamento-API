package br.com.nicolas_frech.garagem_API.controller;

import br.com.nicolas_frech.garagem_API.model.parking.dto.ParkingDTO;
import br.com.nicolas_frech.garagem_API.service.ParkingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
