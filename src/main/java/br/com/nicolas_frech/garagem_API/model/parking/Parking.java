package br.com.nicolas_frech.garagem_API.model.parking;

import br.com.nicolas_frech.garagem_API.model.address.Address;
import br.com.nicolas_frech.garagem_API.model.parking.dto.ParkingDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "parkings")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Parking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String cnpj;

    @Embedded
    private Address address;

    private String phone;

    private String bikeSpace;

    private String carSpace;

    public Parking(ParkingDTO dto) {
        this.name = dto.name();
        this.cnpj = dto.cnpj();
        this.address = new Address(dto.address());
        this.phone = dto.phone();
        this.bikeSpace = dto.bikeSpace();
        this.carSpace = dto.carSpace();
    }
}
