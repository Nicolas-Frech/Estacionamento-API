package br.com.nicolas_frech.garagem_API.model.parking.dto;

import br.com.nicolas_frech.garagem_API.model.address.dto.AddressDTO;
import br.com.nicolas_frech.garagem_API.model.parking.Parking;

public record ParkingDTOReturn(Long id, String name, String cnpj, AddressDTO address, String phone, String bikeSpace, String carSpace) {
    public ParkingDTOReturn(Parking parking) {
        this(parking.getId(), parking.getName(), parking.getCnpj(), new AddressDTO(parking.getAddress()), parking.getPhone(), parking.getBikeSpace(), parking.getCarSpace());
    }
}
