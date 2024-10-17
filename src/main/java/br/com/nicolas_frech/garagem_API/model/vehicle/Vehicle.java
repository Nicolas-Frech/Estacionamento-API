package br.com.nicolas_frech.garagem_API.model.vehicle;

import br.com.nicolas_frech.garagem_API.model.vehicle.dto.VehicleDTO;
import br.com.nicolas_frech.garagem_API.model.vehicle.dto.VehicleDTOUpdate;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "vehicles")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brand;

    private String model;

    private String color;

    private String plate;

    @Enumerated(EnumType.STRING)
    private VehicleType type;

    private boolean active;

    public Vehicle(VehicleDTO dto) {
        this.brand = dto.brand();
        this.model = dto.model();
        this.color = dto.color();
        this.plate = dto.plate();
        this.type = dto.type();
        this.active = true;
    }

    public void delete() {
        this.active = false;
    }

    public void update(VehicleDTOUpdate dto) {
        if(dto.brand() != null) {
            this.brand = dto.brand();
        }
        if(dto.model() != null) {
            this.model = dto.model();
        }
        if(dto.color() != null) {
            this.color = dto.color();
        }
        if(dto.plate() != null) {
            this.plate = dto.plate();
        }
        if(dto.type() != null) {
            this.type = dto.type();
        }
    }
}
