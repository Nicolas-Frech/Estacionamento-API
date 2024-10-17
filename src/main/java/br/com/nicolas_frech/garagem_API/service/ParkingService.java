package br.com.nicolas_frech.garagem_API.service;

import br.com.nicolas_frech.garagem_API.model.parking.Parking;
import br.com.nicolas_frech.garagem_API.model.parking.dto.ParkingDTO;
import br.com.nicolas_frech.garagem_API.model.parking.dto.ParkingDTOReturn;
import br.com.nicolas_frech.garagem_API.model.parking.dto.ParkingDTOUpdate;
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

    public ParkingDTOReturn getParkingById(Long id) {
        if(!parkingRepository.existsById(id)) {
            throw new RuntimeException("Não existe estacionamento com esse ID!");
        } else {
            Parking parking = parkingRepository.getReferenceById(id);
            return new ParkingDTOReturn(parking);
        }
    }

    public ParkingDTOReturn updateParking(ParkingDTOUpdate dto) {
        if (!parkingRepository.existsById(dto.id())) {
            throw new RuntimeException("Não existe estacionamento com esse ID!");
        } else {
            Parking parking = parkingRepository.getReferenceById(dto.id());
            parking.update(dto);

            return new ParkingDTOReturn(parking);
        }
    }

    public void deleteParking(Long id) {
        if (!parkingRepository.existsById(id)) {
            throw new RuntimeException("Não existe estacionamento com esse ID!");
        } else {
            Parking parking = parkingRepository.getReferenceById(id);
            parking.delete();
        }
    }
}
