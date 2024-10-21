package br.com.nicolas_frech.garagem_API.repository;

import br.com.nicolas_frech.garagem_API.model.parking.Parking;
import br.com.nicolas_frech.garagem_API.model.vehicle.Vehicle;
import br.com.nicolas_frech.garagem_API.model.vehicle.VehicleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    @Query("SELECT v FROM Vehicle v WHERE v.type = :type AND v.parking = :parking")
    List<Vehicle> findByVehicleType(VehicleType type, Parking parking);
}
