package br.com.nicolas_frech.garagem_API.model.address;

import br.com.nicolas_frech.garagem_API.model.address.dto.AddressDTO;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    private String street;
    private String district;
    private String cep;
    private String city;
    private String state;
    private String number;

    public Address(AddressDTO dto) {
        this.street = dto.street();
        this.district = dto.district();
        this.cep = dto.cep();
        this.city = dto.city();
        this.state = dto.state();
        this.number = dto.number();
    }
}
