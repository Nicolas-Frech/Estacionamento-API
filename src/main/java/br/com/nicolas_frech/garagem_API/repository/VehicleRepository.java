package br.com.nicolas_frech.garagem_API.repository;

import br.com.nicolas_frech.garagem_API.model.vehicle.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}
