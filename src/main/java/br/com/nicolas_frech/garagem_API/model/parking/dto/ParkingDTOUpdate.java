package br.com.nicolas_frech.garagem_API.model.parking.dto;

import br.com.nicolas_frech.garagem_API.model.address.dto.AddressDTOUpdate;

public record ParkingDTOUpdate(Long id, String name, String cnpj, AddressDTOUpdate address, String phone, String bikeSpace, String carSpace) {
}
