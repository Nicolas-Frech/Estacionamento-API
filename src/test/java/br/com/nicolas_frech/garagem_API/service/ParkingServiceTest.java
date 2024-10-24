package br.com.nicolas_frech.garagem_API.service;

import br.com.nicolas_frech.garagem_API.exception.ValidationExceptionClass;
import br.com.nicolas_frech.garagem_API.model.parking.Parking;
import br.com.nicolas_frech.garagem_API.model.vehicle.Vehicle;
import br.com.nicolas_frech.garagem_API.model.vehicle.VehicleType;
import br.com.nicolas_frech.garagem_API.model.vehicle.dto.VehicleEntryDTO;
import br.com.nicolas_frech.garagem_API.repository.ParkingRepository;
import br.com.nicolas_frech.garagem_API.repository.VehicleRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class ParkingServiceTest {

    @InjectMocks
    private ParkingService parkingService;

    @Mock
    private VehicleRepository vehicleRepository;

    @Mock
    private ParkingRepository parkingRepository;

    @Mock
    private Vehicle vehicle;

    @Mock
    private Parking parking;

    @Mock
    VehicleEntryDTO dto;

    @Test
    @DisplayName("Deve adicionar o veiculo no estacionamento")
    public void scenary01() {

        given(vehicleRepository.getReferenceById(dto.vehicleId())).willReturn(vehicle);
        given(parkingRepository.getReferenceById(dto.parkingId())).willReturn(parking);
        given(vehicle.getType()).willReturn(VehicleType.CAR);
        given(parking.getCarSpace()).willReturn("10");

        assertDoesNotThrow(() -> parkingService.entryVehicle(dto));

    }

    @Test
    @DisplayName("Não deve adicionar o veiculo no estacionamento")
    public void scenary02() {

        given(vehicleRepository.getReferenceById(dto.vehicleId())).willReturn(vehicle);
        given(parkingRepository.getReferenceById(dto.parkingId())).willReturn(parking);
        given(vehicle.getType()).willReturn(VehicleType.CAR);
        given(parking.getCarSpace()).willReturn("0");

        assertThrows(ValidationExceptionClass.class, () -> parkingService.entryVehicle(dto));
    }
}