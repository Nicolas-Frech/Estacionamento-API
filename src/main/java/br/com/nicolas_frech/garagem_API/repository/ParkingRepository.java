package br.com.nicolas_frech.garagem_API.repository;

import br.com.nicolas_frech.garagem_API.model.parking.Parking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkingRepository extends JpaRepository<Parking, Long> {
}
