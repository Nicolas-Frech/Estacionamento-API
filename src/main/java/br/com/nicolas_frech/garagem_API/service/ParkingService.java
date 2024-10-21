package br.com.nicolas_frech.garagem_API.service;

import br.com.nicolas_frech.garagem_API.exception.ValidationExceptionClass;
import br.com.nicolas_frech.garagem_API.model.parking.Parking;
import br.com.nicolas_frech.garagem_API.model.parking.dto.ParkingDTO;
import br.com.nicolas_frech.garagem_API.model.parking.dto.ParkingDTOReturn;
import br.com.nicolas_frech.garagem_API.model.parking.dto.ParkingDTOUpdate;
import br.com.nicolas_frech.garagem_API.model.vehicle.Vehicle;
import br.com.nicolas_frech.garagem_API.model.vehicle.VehicleType;
import br.com.nicolas_frech.garagem_API.model.vehicle.dto.VehicleEntryDTO;
import br.com.nicolas_frech.garagem_API.repository.ParkingRepository;
import br.com.nicolas_frech.garagem_API.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParkingService {

    @Autowired
    private ParkingRepository parkingRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    public void registParking(ParkingDTO dto) {
        Parking parking = new Parking(dto);
        parkingRepository.save(parking);
    }

    public ParkingDTOReturn getParkingById(Long id) {
         Parking parking = parkingRepository.getReferenceById(id);
         return new ParkingDTOReturn(parking);
    }

    public ParkingDTOReturn updateParking(ParkingDTOUpdate dto) {
        Parking parking = parkingRepository.getReferenceById(dto.id());
        parking.update(dto);

        return new ParkingDTOReturn(parking);
    }

    public void deleteParking(Long id) {
        Parking parking = parkingRepository.getReferenceById(id);
        parking.delete();
    }


    public void entryVehicle(VehicleEntryDTO dto) {
         Parking parking = parkingRepository.getReferenceById(dto.parkingId());
         Vehicle vehicle = vehicleRepository.getReferenceById(dto.vehicleId());

         if(vehicle.getType() == VehicleType.CAR) {
             var carParkingSpace = vehicleRepository.findByVehicleType(VehicleType.CAR, parking);
             var carSpace = Integer.parseInt(parking.getCarSpace());

             if(carParkingSpace.size() == carSpace) {
                 throw new ValidationExceptionClass("Esse estacionamento chegou a sua lotação máxima de carros!!!");
             } else {
                 parking.addVehicle(vehicle);
                 vehicle.addParking(parking);
             }
         } else {
             var bikeParkingSpace = vehicleRepository.findByVehicleType(VehicleType.BIKE, parking);
             var bikeSpace = Integer.parseInt(parking.getBikeSpace());

             if(bikeParkingSpace.size() == bikeSpace) {
                 throw new ValidationExceptionClass("Esse estacionamento chegou a sua lotação máxima de motos!!!");
             } else {
                 parking.addVehicle(vehicle);
                 vehicle.addParking(parking);
             }
        }
    }

    public void exitVehicle(VehicleEntryDTO dto) {
        Parking parking = parkingRepository.getReferenceById(dto.parkingId());
        Vehicle vehicle = vehicleRepository.getReferenceById(dto.vehicleId());

        parking.removeVehicle(vehicle);
        vehicle.removeParking();
    }
}
