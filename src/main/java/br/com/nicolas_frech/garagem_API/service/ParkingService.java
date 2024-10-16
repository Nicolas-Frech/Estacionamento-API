package br.com.nicolas_frech.garagem_API.service;

import br.com.nicolas_frech.garagem_API.model.parking.Parking;
import br.com.nicolas_frech.garagem_API.model.parking.dto.ParkingDTO;
import br.com.nicolas_frech.garagem_API.repository.ParkingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParkingService {

    @Autowired
    private ParkingRepository parkingRepository;

    public void registParking(ParkingDTO dto) {
        Parking parking = new Parking(dto);
        parkingRepository.save(parking);
    }
}
