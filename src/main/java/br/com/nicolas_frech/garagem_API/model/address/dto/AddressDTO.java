package br.com.nicolas_frech.garagem_API.model.address.dto;

import br.com.nicolas_frech.garagem_API.model.address.Address;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record AddressDTO(
        @NotBlank
        String street,

        @NotBlank
        String district,

        @NotBlank
        @Pattern(regexp = "\\d{8}")
        String cep,

        @NotBlank
        String city,

        @NotBlank
        String state,

        @NotBlank
        String number) {

        public AddressDTO(Address address) {
                this(address.getStreet(), address.getDistrict(), address.getCep(), address.getCity(), address.getState(), address.getNumber());
        }
}
