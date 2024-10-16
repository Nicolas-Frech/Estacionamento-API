package br.com.nicolas_frech.garagem_API.model.parking.dto;

import br.com.nicolas_frech.garagem_API.model.address.dto.AddressDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CNPJ;

public record ParkingDTO(
        @NotBlank
        String name,

        @NotBlank
        @CNPJ
        String cnpj,

        @NotNull
        @Valid
        AddressDTO address,

        @NotBlank
        String phone,

        @NotBlank
        String bikeSpace,

        @NotBlank
        String carSpace) {
}
